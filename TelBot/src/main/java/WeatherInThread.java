import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class WeatherInThread extends Thread
{
    Model model = new Model();
    URL url;
    static String weather;

    public WeatherInThread(URL url) {
        this.url = url;
    }

    public static String rightEmoji(String main)
    {
        return switch (main) {
            case "Thunderstorm" -> Emoji.ZAP.get();
            case "Drizzle" -> Emoji.RAIN.get();
            case "Rain" -> Emoji.RAIN.get();
            case "Snow" -> Emoji.SNOW.get();
            case "Clear" -> Emoji.SUN.get();
            case "Clouds" -> Emoji.CLOUD.get();
            default -> Emoji.FOGGY.get();
        };
    }

    public void run()
    {
        try {
            Scanner in = null;
            try {
                in = new Scanner((InputStream) url.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringBuilder result = new StringBuilder();
            while (in.hasNext()) {
                result.append(in.nextLine());
            }

            JSONObject object = new JSONObject(result.toString());
            model.setName(object.getString("name"));

            JSONObject main = object.getJSONObject("main");
            model.setTemp(main.getDouble("temp"));
            model.setHumidity(main.getDouble("humidity"));
            model.setHumidity(main.getDouble("humidity"));
            model.setFeels_like(main.getDouble("feels_like"));
            model.setTemp_min(main.getDouble("temp_min"));
            model.setTemp_max(main.getDouble("temp_max"));

            JSONArray getArray = object.getJSONArray("weather");
            for (int i = 0; i < getArray.length(); i++) {
                JSONObject obj = getArray.getJSONObject(i);
                model.setMain((String) obj.get("main"));
            }

            weather = "Место: " + model.getName() + "\n" +
                    "Текущая температура: " + model.getTemp() + "C" + "\n" +
                    "Ощущается:" + model.getFeels_like() + "C" +  "\n" +
                    "Минимльная температура:" + model.getTemp_min() + "C" +  "\n" +
                    "Максимальная температура:" + model.getTemp_max() + "C" +  "\n" +
                    "Влажность:" + model.getHumidity() + "%" + "\n" +
                    "Осадки: " + model.getMain() + "\n" + rightEmoji(model.getMain())+ rightEmoji(model.getMain())+ rightEmoji(model.getMain());
        } catch (Exception e){
            weather =  "Город не найден! " + Emoji.PENSIVE.get();
        }
    }

    public static String getWeather() {
        return weather;
    }
}
