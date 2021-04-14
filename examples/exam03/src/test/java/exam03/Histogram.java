package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Histogram {


    public String createHistogram(BufferedReader reader) throws IOException {
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line);
            if (number > 0){
                for (int i = 1; i <= number; i++) {
                    result.append("*");
                }
                result.append("\n");
            }
        }
        return result.toString();
    }


}
