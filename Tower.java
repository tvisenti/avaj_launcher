
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
      Display.addString(Display.formatStringTowerBaloon(baloon, "registered to weather tower."));
      break;
    }
    case "JetPlane": {
      JetPlane jetPlane = JetPlane.class.cast(flyable);
      Display.addString(Display.formatStringTowerJetPlane(jetPlane, "registered to weather tower."));
      break;
    }
    case "Helicopter": {
      Helicopter helicopter = Helicopter.class.cast(flyable);
      Display.addString(Display.formatStringTowerHelicopter(helicopter, "registered to weather tower."));
      break;
    }
    }
  }

  public void unregister(IFlyable flyable) {
    observers.remove(flyable);
    switch (flyable.getClass().getName()) {
    case "Baloon": {
      Baloon baloon = Baloon.class.cast(flyable);
      Display.addString(Display.formatStringTowerBaloon(baloon, "unregistered to weather tower."));
      break;
    }
    case "JetPlane": {
      JetPlane jetPlane = JetPlane.class.cast(flyable);
      Display.addString(Display.formatStringTowerJetPlane(jetPlane, "unregistered to weather tower."));
      break;
    }
    case "Helicopter": {
      Helicopter helicopter = Helicopter.class.cast(flyable);
      Display.addString(Display.formatStringTowerHelicopter(helicopter, "unregistered to weather tower."));
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
