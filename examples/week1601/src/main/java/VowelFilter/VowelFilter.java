package VowelFilter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class VowelFilter {

    public String filterVowels(BufferedReader bufferedReader) throws IOException {
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = bufferedReader.readLine())  != null) {
            if (line.isEmpty()){
                return "";
            }
            String vowels = "aáeéiíoóöőuúAÁEÉIÍOÓÖŐUÚ";
            char[] chars = line.toCharArray();
            for (char c : chars) {
                if (!vowels.contains(String.valueOf(c))){
                    result.append(c);

                }
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("vowelfilter.txt"))) {
            System.out.println(new VowelFilter().filterVowels(reader));
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }
    }

}
