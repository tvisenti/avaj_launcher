public class AircraftFactory {
  public IFlyable newAircraft(String type, String name, int longitude, int latitude, int height) {
    Coordinates coordinates = new Coordinates(longitude, latitude, height);

    switch (type) {
    case "Baloon":
      return new Baloon(name, coordinates);
    case "JetPlane":
      return new JetPlane(name, coordinates);
    default:
      return new Helicopter(name, coordinates);
    }
  }
}
