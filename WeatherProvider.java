import java.util.concurrent.ThreadLocalRandom;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String weather[] = { "RAIN", "SUN", "FOG", "SNOW" };

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) + 1);
        return weather[randomNum % 4];
    }
}