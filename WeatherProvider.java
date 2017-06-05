public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private String weather[];

    WeatherProvider() {
        this.weatherProvider = new WeatherProvider();
    }

    public WeatherProvider getProvider() {
        return this.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "RAIN";
    }
}