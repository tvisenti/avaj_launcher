import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Tower {
  private static List<IFlyable> observers = new ArrayList<IFlyable>();

  public void register(IFlyable flyable) {
    observers.add(flyable);
    switch (flyable.getClass().getName()) {
    case "Baloon": {
      Baloon baloon = Baloon.class.cast(flyable);
      System.out.println(
          "Tower says: " + baloon.getClass() + "#" + baloon.name + "(" + baloon.id + ") registered to weather tower.");
      break;
    }
    case "JetPlane": {
      JetPlane jetPlane = JetPlane.class.cast(flyable);
      System.out.println("Tower says: " + jetPlane.getClass() + "#" + jetPlane.name + "(" + jetPlane.id
          + ") registered to weather tower.");
      break;
    }
    case "Helicopter": {
      Helicopter helicopter = Helicopter.class.cast(flyable);
      System.out.println("Tower says: " + helicopter.getClass() + "#" + helicopter.name + "(" + helicopter.id
          + ") registered to weather tower.");
      break;
    }
    }
  }

  public void unregister(IFlyable flyable) {
    observers.remove(flyable);
    switch (flyable.getClass().getName()) {
    case "Baloon": {
      Baloon baloon = Baloon.class.cast(flyable);
      System.out.println("Tower says: " + baloon.getClass() + "#" + baloon.name + "(" + baloon.id
          + ") unregistered to weather tower.");
      break;
    }
    case "JetPlane": {
      JetPlane jetPlane = JetPlane.class.cast(flyable);
      System.out.println("Tower says: " + jetPlane.getClass() + "#" + jetPlane.name + "(" + jetPlane.id
          + ") unregistered to weather tower.");
      break;
    }
    case "Helicopter": {
      Helicopter helicopter = Helicopter.class.cast(flyable);
      System.out.println("Tower says: " + helicopter.getClass() + "#" + helicopter.name + "(" + helicopter.id
          + ") unregistered to weather tower.");
      break;
    }
    }
  }

  protected void conditionsChanged() {
    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).updateConditions();
    }
  }
}
