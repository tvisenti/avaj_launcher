public class Baloon extends Aircraft implements IFlyable  {
  WeatherTower weatherTower;

  public Baloon(String name, Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower weatherTower) {
      this.weatherTower = weatherTower;
  }
}
