package A66;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A66entering {

    public static void main(String[] args) throws IOException {
        String filename = "logs.csv";
        mainTranceCounter(filename);
    }

    public static void mainTranceCounter(String filename) throws IOException {
        Path path = Paths.get(filename);
        List<String> lines = Files.readAllLines(path);
        Map<String, Integer> map = new HashMap<>();
        for (String line : lines) {
            String[] split = line.split(",");
            if (split[5].contains("A66 - 04 FÕBEJÁRAT (F-1) Door #1")) {
                map.put(split[12], map.getOrDefault(split[12], 0) + 1);
            }
        }
//        System.out.println(map);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("a66entering.json"))) {

            writer.write(gson.toJson(map));

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file" + ioe);
        }
    }

}
