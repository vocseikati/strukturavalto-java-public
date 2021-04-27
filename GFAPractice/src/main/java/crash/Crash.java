package crash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Crash {

    public static void main(String[] args) {
        String filename = "crash-incidents.csv";
        try {
            getCrashStatistics(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCrashStatistics(String filename) throws IOException {
        Path path = Paths.get(filename);
        if (!Files.exists(path)){
            System.out.println("File nem létezik: " + filename);
        }
        List<String> lines = Files.readAllLines(path);

        int goodWeatherCrashesCounter = 0;
        int badWeatherCrashesCounter = 0;
        for (String line : lines) {
            String[] split = line.split(";");
            if (split[5].equals("CLOUDY") || split[5].equals("CLEAR")){
                goodWeatherCrashesCounter++;
            }
            if (split[5].equals("RAIN") || split[5].equals("FREEZING RAIN")
            || split[5].equals("SNOW") || split[5].equals("FOG") || split[5].equals("SEVERE CROSSWINDS")){
                badWeatherCrashesCounter++;
            }
        }
        System.out.println("The amount of crashes at good weather conditions: " + goodWeatherCrashesCounter);
        System.out.println("The amount of crashes at bad weather conditions: " + badWeatherCrashesCounter);
    }

}
