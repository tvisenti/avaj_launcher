public class Aircraft {
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private static long idCounter = 1;

  Aircraft(String name, Coordinates coordinates) {
    this.id = nextId();
    this.name = name;
    this.coordinates = coordinates;
  }

  public void finalize() {
    System.out.println("Aircraft is dead");
  }

  public long nextId() {
    return (idCounter++);
  }
}
