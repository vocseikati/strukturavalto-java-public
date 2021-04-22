package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class DaVinciCode {


    public int encode(String filename, char character) throws IOException {
        Objects.requireNonNull(filename);
        if (filename.equals("")) {
            throw new IllegalArgumentException("Path cannot be empty");
        }
        if (character == 'x' || character == '0' || character == '1'){
            List<String> lines = Files.readAllLines(Paths.get(filename));
            int charCount = 0;
            for (String line : lines) {
                if (line.contains(String.valueOf(character))){
                    for (char c : line.toCharArray()) {
                        if (c == character){
                            charCount++;
                        }
                    }
                }
            }
            return charCount;
        }

        throw new IllegalArgumentException();
    }
}
