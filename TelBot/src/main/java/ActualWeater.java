import java.io.IOException;
import java.net.URL;

public class ActualWeater
{
    public static String getWeatherforCity(String message) throws IOException, InterruptedException {
        return goThread(new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&cnt=3&appid=c9ca40172686d99d581eeb4eec403b90"));
    }

    public static String getWeatherforLocation(String latitude, String longitude) throws IOException, InterruptedException {
        return goThread(new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon="+ longitude+ "&units=metric&appid=c9ca40172686d99d581eeb4eec403b90"));
    }

    public static String goThread(URL url) throws InterruptedException {
        WeatherInThread weatherInThread = new WeatherInThread(url);
        weatherInThread.start();
        weatherInThread.join();
        return WeatherInThread.getWeather();
    }
}
