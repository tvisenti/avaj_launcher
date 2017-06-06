import java.util.ArrayList;
import java.util.List;

public class Display {
    public static List<String> strings = new ArrayList<String>();

    public static String formatStringTower(IFlyable flyable, String message) {
        return ("Tower says: " + flyable.getClass().getName() + "#" + flyable.name + "(" + flyable.id + ") " + message);
    }
    public static String formatString(IFlyable flyable, String message) {
        return (flyable.getClass().getName() + "#" + flyable.name + "(" + flyable.id + "): " + message);
    }

  public static void addString(String newString) {
    strings.add(newString);
  }
}