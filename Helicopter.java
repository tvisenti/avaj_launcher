public class Helicopter extends Aircraft implements IFlyable {
  private WeatherTower weatherTower;

  Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN": {
        coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): It's raining bullet bitch (like in Matrix)!");
      } case "FOG": {
        coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): You shall not pass!");
      } case "SUN": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): It's hot here..");
      } case "SNOW": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Please don't freeze .....");
      }
    }
    if (coordinates.getHeight() <= 0)
      weatherTower.unregister(this);
    else if (coordinates.getHeight() > 100)
      coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
