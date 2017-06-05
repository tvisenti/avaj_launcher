public class Baloon extends Aircraft implements IFlyable  {
  private WeatherTower weatherTower;

  Baloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): It's rain a man!");
      case "FOG":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Is it pollution or fog..?");
      case "SUN":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Wow the view is unbeliable now!");
      case "SNOW":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): We should go down, now it's snowing..");
    }
  }

  public void registerTower(WeatherTower weatherTower) {
      this.weatherTower = weatherTower;
  }
}
