public class Aircraft {
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private static long idCounter = 1;

  Aircraft() {
  }

  Aircraft(String name, Coordinates coordinates) {
    this.id = nextId();
    this.name = name;
    this.coordinates = coordinates;
  }

  public void finalize() {
    System.out.println("Aircraft is dead");
  }

  private long nextId() {
    return (idCounter++);
  }

}
