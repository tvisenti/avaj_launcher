public class JetPlane extends Aircraft implements IFlyable  {
  WeatherTower weatherTower;

  public JetPlane(String name, Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
