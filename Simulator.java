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
            AircraftFactory factory = new AircraftFactory();
            IFlyable flyable;
            WeatherTower weatherTower = new WeatherTower();
            Tower tower = new Tower();
            Pattern pattern;
            Matcher matcher;
            long generatorWeather = 0;

            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                pattern = Pattern.compile("([0-9]+)");
                matcher = pattern.matcher(lines.get(0));
                if (matcher.find() && matcher.group() == lines.get(0)) {
                    generatorWeather = Long.parseLong(matcher.group(1));
                } else {
                    System.out.println("Error line: " + lines.get(0));
                    return;
                }
                pattern = Pattern.compile("(Baloon|JetPlane|Helicopter) ([A-Za-z0-9]+) ([0-9]+) ([0-9]+) ([0-9]+)");
                for (int i = 1; i < lines.size(); i++) {
                    matcher = pattern.matcher(lines.get(i));
                    if (matcher.find() && matcher.group() == lines.get(i)) {
                        int height = (Integer.parseInt(matcher.group(5)) > 100) ? 100 : Integer.parseInt(matcher.group(5));

                        flyable = factory.newAircraft(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), height);
                        tower.register(flyable);
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
            
            for (int i = 0; i < generatorWeather; i++) {
                weatherTower.changeWeather();
            }

        } else {
            System.out.println("Put one file");
        }
        // System.out.println("FIN ! ");
    }
}