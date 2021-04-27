package frequentWords;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequentWords {

    public static void main(String[] args) {
        getFrequentWords("input.txt", 2);
    }

    public static void getFrequentWords(String filename, int frequency) {
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            System.out.println("File nem létezik: " + filename);
        }
        Map<String, Long> collect;
        List<String> temp = new ArrayList<>();
        List<String> output;
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String clearLine = line.replaceAll("[^A-Za-z0-9öüóőúéáűíÖÜÓŐÚÉÁŰÍ\\s]", "");
                String[] split = clearLine.split(" ");
                temp.addAll(Arrays.asList(split));
            }
            collect = temp.stream()
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()));
            output = collect.entrySet().stream()
                    .filter(entry -> entry.getValue() == frequency)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            if (!output.isEmpty()) {
                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"));) {
                    writer.write(output.stream().collect(Collectors.joining(", ")));
                } catch (IOException ioe) {
                    throw new IllegalStateException("Cannot write file", ioe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
