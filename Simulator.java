import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Simulator {
    public static void main(String[] args) {
        if (args.length == 1) {
            List<String> lines = null;
            Path path = Paths.get(args[0]);
            int i;
            Pattern pattern;
            Matcher matcher;
            AircraftFactory factory = new AircraftFactory();
            IFlyable flyable;
            Tower tower = new Tower();

            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                pattern = Pattern.compile("(Baloon|JetPlane|Helicopter) ([A-Za-z0-9]+) ([0-9]+) ([0-9]+) ([0-9]+)");
                for (i = 1; i < lines.size(); i++) {
                    matcher = pattern.matcher(lines.get(i));
                    if (matcher.find() && matcher.group() == lines.get(i)) {
                        flyable = factory.newAircraft(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
                        tower.register(flyable);
                        // System.out.println(matcher.group());
                    } else {
                        System.out.println("Error line: " + lines.get(i));
                        return;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Put one file");
        }
        // System.out.println("FIN ! ");
    }
}