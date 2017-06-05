public class JetPlane extends Aircraft implements IFlyable  {
  private WeatherTower weatherTower = new WeatherTower();

  JetPlane(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the rain");
        break;
      } case "FOG": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the fog");
        break;
      } case "SUN": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the sun");
        break;
      } case "SNOW": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the snow");
        break;
      }
    }
    if (coordinates.getHeight() <= 0) {
      System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): is crashing.");
      weatherTower.unregister(this);
    } else if (coordinates.getHeight() > 100)
      coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
