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

            try {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                pattern = Pattern.compile("(Baloon|JetPlane|Helicopter) ([A-Za-z0-9]+) ([0-9]+) ([0-9]+) ([0-9]+)");
                for (i = 1; i < lines.size(); i++) {
                    matcher = pattern.matcher(lines.get(i));
                    if (matcher.find()) {
                        if (matcher.group() == lines.get(i)) {
                            System.out.println("Line ok : " + matcher.group());
                        } else {
                            System.out.println("Error line: " + lines.get(i));
                        }
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