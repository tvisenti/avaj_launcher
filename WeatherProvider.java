public class WeatherProvider {
    WeatherProvider weatherProvider = new WeatherProvider();
    String weather[];

    WeatherProvider() {

    }

    public WeatherProvider getProvider() {
        return this.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "RAIN";
    }
}