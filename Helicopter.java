public class Helicopter extends Aircraft implements IFlyable {
  WeatherTower weatherTower;

  Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): It's raining bullet bitch (like in Matrix)!");
      case "FOG":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): You shall not pass!");
      case "SUN":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): It's hot here..");
      case "SNOW":
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Please don't freeze .....");
    }
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
  }
}
