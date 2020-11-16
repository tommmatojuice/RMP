import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.*;


public class TBot extends TelegramLongPollingBot
{
    private static DB db;
    private static String chatId;
    private static String city;
    private static List<Users> users;
    int flag=0;

    public static void main(String[] args)
    {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TBot());
            Connection connection = DriverManager.getConnection("jdbc:sqlite:S:\\users1.db");
            db = new DB(connection);
            users = db.getAllUsers();
        } catch (SQLException | TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendMsg(String chatId, String s)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            setButtons(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        for (Users u: db.getAllUsers()) {
            if(u.getId().equals(message.getFrom().getId()))
                city = u.getCity();
        }
        chatId = message.getChatId().toString();
        if(message.hasLocation()){
            try {
                sendMsg(chatId, ActualWeater.getWeatherforLocation(message.getLocation().getLatitude().toString(), message.getLocation().getLongitude().toString()));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (message.hasText()) {
            switch (message.getText()) {
                case "/start":
                    sendMsg(chatId, "Привет! " + Emoji.WAVE.get() + " Это погодный телеграмм-бот. Напиши любой город или отправь свою геолокацию, и получишь прогоноз погода на этот день и текущую погоду. Подпишишь на ежедневную рассылку и каждый день в 8:00 получай погоду на этот день в своем городе! " + Emoji.WINK.get() + Emoji.SUN.get());
                    break;
                case "/subscribe":
                    int f=0;
                    for (Users u: db.getAllUsers()) {
                        if(u.getId().equals(message.getFrom().getId())){
                            sendMsg(chatId, "Вы уже подписаны на рассылку! " + Emoji.RELIAVER.get()+"\n" +"Твой город:"+city);
                            f=1;
                        }
                    }
                    if(f==0){
                        sendMsg(chatId,"Введи свой город для ежедневного прогноза " + Emoji.CITY.get());
                        flag=1;
                    }
                    break;
                case "/unsubscribe":
                    for (int i=0; i<users.size(); i++) {
                        if (users.get(i).getId().equals(message.getFrom().getId())){
                            users.remove(i);
                            db.deleteUser(message.getFrom().getId());
                            sendMsg(chatId, "Вы отписались от ежедневной рассылки! " + Emoji.PENSIVE.get());
                            flag=0;
                        } else {
                            sendMsg(chatId, "Для этого сначала нужно подписаться! " + Emoji.WINK.get());
                        }
                    }
                    break;
                default:
                    try {
                        if(flag==1){
                            if(ActualWeater.getWeatherforCity(message.getText()).contains("Место")){
                                city = message.getText();
                                users.add(new Users(message.getFrom().getId(), message.getFrom().getFirstName(), true, city));
                                db.addUser(users.get(users.size()-1));
                                EverydayMessage();
                                sendMsg(chatId, "Вы успешно подписались на ежедневную рассылку! " + Emoji.TADA.get());
                                flag=0;
                            } else {
                                sendMsg(chatId, "Город не найден! " + Emoji.PENSIVE.get());
                            }
                        } else {
                            sendMsg(chatId, ActualWeater.getWeatherforCity(message.getText()));
                        }
                    } catch (Exception e) {
                        sendMsg(chatId, "Город не найден! " + Emoji.PENSIVE.get());
                    }
            }
        }
    }

    public void setButtons(SendMessage sendMessage)
    {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        KeyboardRow keyboardFourthRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("/weather"));
        keyboardFirstRow.get(0).setRequestLocation(true);
        keyboardThirdRow.add(new KeyboardButton("/subscribe"));
        keyboardFourthRow.add(new KeyboardButton("/unsubscribe"));

        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardThirdRow);
        keyboardRowList.add(keyboardFourthRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public String getBotUsername() {
        return "ActualWeather_bot";
    }

    public String getBotToken() {
        return "1314443930:AAFDuxRSbEvjlAtAMiH89XP92rHc-WUFwDE";
    }

    public void EverydayMessage()
    {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                try {
                    sendMsg(chatId,  "Сегодняшняя погода:" + "\n" + ActualWeater.getWeatherforCity(city));
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer("Timer");
        long needTime = ZonedDateTime.now().getHour() *1000L *  60L *  60L +
                ZonedDateTime.now().getMinute() * 60000L +
                ZonedDateTime.now().getSecond() * 1000L - 1000L *  60L *  60L *  23L;
        long delay = 1000L *  60L *  60L *  8L + Math.abs (needTime);
        long period = 1000L *  60L *  60L *  24L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
    }
}
