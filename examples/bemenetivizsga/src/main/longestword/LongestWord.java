package longestword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LongestWord {

    public String findLongestWord(String fileName) {
        String result = "";
        Path path = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] split = line.split(" ");
                result = getString(result, split);
            }
            return result;
        } catch (IOException e) {
            return "";
        }
    }

    private String getString(String result, String[] words) {
        for (String word : words) {
            if (word.length() > result.length()) {
                result = word;
            }
        }
        return result;
    }
}
