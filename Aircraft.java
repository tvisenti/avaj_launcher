public class Aircraft {
  long id;
  String name;
  Coordinates coordinates;
  long idCounter = 0;

  public Aircraft(String name, Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
  }

  public void finalize() {
    System.out.println("Aircraft is dead");
  }

  public long nextId() {
    return idCounter++;
  }
}
