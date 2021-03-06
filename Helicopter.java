
public class Helicopter extends Aircraft implements IFlyable {
  private WeatherTower weatherTower = new WeatherTower();

  Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN": {
        coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        Display.addString(Display.formatStringHelicopter(this, "It's raining bullet bitch (like in Matrix)!"));
        break;
      } case "FOG": {
        coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        Display.addString(Display.formatStringHelicopter(this, "You shall not pass!"));
        break;
      } case "SUN": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        Display.addString(Display.formatStringHelicopter(this, "It's hot here.."));
        break;
      } case "SNOW": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        Display.addString(Display.formatStringHelicopter(this, "Please don't freeze ....."));
        break;
      }
    }
    if (coordinates.getHeight() <= 0) {
      Display.addString(Display.formatStringHelicopter(this, "is landing."));
      weatherTower.unregister(this);
    } else if (coordinates.getHeight() > 100)
      coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
