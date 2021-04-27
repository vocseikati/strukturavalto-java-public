package A66;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainA66 {
    public static void main(String[] args) {
        try {
            parse(Paths.get("logs.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parse(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<String[]> data = new ArrayList<>();
        for (String line : lines) {
            String[] row = line.split(",");
            data.add(new String[] {row[5], row[12]});
        }

        Map<String, Integer> counted = data.stream()
                .filter(item -> item[0].equals("A66 - 04 FÕBEJÁRAT (F-1) Door #1"))
                .collect(Collectors.toMap(key -> key[1], value -> 1, Integer::sum));

        ArrayList<String> output = new ArrayList<>();
        output.add("{");
        for (Map.Entry<String, Integer> entry : counted.entrySet()) {
            output.add("\t\"" + entry.getKey() + "\": " + entry.getValue() + ",");
        }
        output.set(output.size() - 1, output.get(output.size() - 1).replace(",", ""));
        output.add("}");

        Files.write(Paths.get("a66entering.json"), output);
    }
}
