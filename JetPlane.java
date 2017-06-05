public class JetPlane extends Aircraft implements IFlyable  {
  private WeatherTower weatherTower;

  JetPlane(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the rain");
      case "FOG":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the fog");
      case "SUN":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the sun");
      case "SNOW":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Too fast for the snow");
    }
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
