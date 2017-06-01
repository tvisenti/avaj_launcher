public class Helicopter extends Aircraft implements IFlyable {
  WeatherTower weatherTower;

  public Helicopter(String name, Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
