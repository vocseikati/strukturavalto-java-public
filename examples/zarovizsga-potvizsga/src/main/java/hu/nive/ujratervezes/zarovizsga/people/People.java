package hu.nive.ujratervezes.zarovizsga.people;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class People {


    public int getNumberOfMales(String path) {
        int maleCount = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] split = line.split(",");
                if (split[4].equals("Male")) {
                    maleCount++;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File cannot be found on path " + path);
        }

        return maleCount;
    }
}
