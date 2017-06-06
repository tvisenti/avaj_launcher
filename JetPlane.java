public class JetPlane extends Aircraft implements IFlyable  {
  private WeatherTower weatherTower = new WeatherTower();

  JetPlane(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
       Display.addString(Display.formatString(this, "Too fast for the rain"));
        break;
      } case "FOG": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
       Display.addString(Display.formatString(this, "Too fast for the fog"));
        break;
      } case "SUN": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
       Display.addString(Display.formatString(this, "Too fast for the sun"));
        break;
      } case "SNOW": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
       Display.addString(Display.formatString(this, "Too fast for the snow"));
        break;
      }
    }
    if (coordinates.getHeight() <= 0) {
     Display.addString(Display.formatString(this, "is crashing."));
      weatherTower.unregister(this);
    } else if (coordinates.getHeight() > 100)
      coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
