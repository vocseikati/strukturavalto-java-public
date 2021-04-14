package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WorkHours {


    public String minWork(String s) {
        Map<String, Integer> count = new HashMap<>();
        String result = "";
        try {
            List<String> lines = Files.readAllLines(Paths.get(s));
            for (String line : lines) {
                String[] split = line.split(",");
                count.put(split[0] + ": " + split[2], Integer.parseInt(split[1]));
            }
            Optional<Map.Entry<String, Integer>> min = count.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue));
            if (!min.isPresent()) {
                return null;
            }
            result = count.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
