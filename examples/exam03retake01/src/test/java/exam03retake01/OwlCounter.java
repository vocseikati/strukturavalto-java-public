package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    Map<String, Integer> result = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.split("=");
            result.put(split[0], Integer.parseInt(split[1].trim()));
        }
    }


    public int getNumberOfOwls(String shire) {
//        for (Map.Entry<String, Integer> entry : result.entrySet()) {
//            if (entry.getKey().equals(shire)) {
//                return entry.getValue();
//            }
//        }
        return result.get(shire);
    }
}
