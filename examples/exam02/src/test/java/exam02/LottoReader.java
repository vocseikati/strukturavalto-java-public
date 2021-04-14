package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LottoReader {
//    private int[] numbers = new int[90];
    Map<Integer, Integer> count = new HashMap<>();

    public LottoReader(InputStream inputStream) {

//        T360 megoldás:
//        try (
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        ) {
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] fields = line.split(";");
//                for (int i = 11; i < 16; i++) {
//                    int number = Integer.parseInt(fields[i]);
//                    numbers[number - 1] ++;
//                }
//            }
//        }
//        catch (IOException ioe) {
//            throw new RuntimeException("Error reading file", ioe);
//        }

        try {
            List<String> lines = Files.readAllLines(Paths.get("src/test/resources/otos.csv"));
            for (String line : lines) {
                String[] split = line.split(";");
                for (int i = 0; i < split.length; i++) {
                    if (i > 10) {
                        int number = Integer.parseInt(split[i]);
                        if (count.containsKey(number)) {
                            count.put(number, count.get(number) + 1);
                        } else {
                            count.put(number, 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }

    }

    public int getNumber(int number) {
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getKey() == number){
                return entry.getValue();
            }
        }
        return 0;
    }


}
