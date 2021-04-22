package exam03retake02;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.*;

import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getResourceAsStream;

public class BalatonStorm {

//
//    public List<String> getStationsInStorm(BufferedReader reader) {
//        Objects.requireNonNull(reader);
//        List<String> stationsInStorm = new ArrayList<>();
//        Gson gson = new Gson();
//        Station[] stations = gson.fromJson(reader, Station[].class);
//        for (Station station : stations) {
//            System.out.println(station);
//            if (station.getLevel() == 3) {
//                stationsInStorm.add(station.getAllomas());
//            }
//        }
//        stationsInStorm.sort(Collator.getInstance(new Locale("hu", "HU")));
//        return stationsInStorm;
//    }


    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
//        Map<String, Integer> map = new TreeMap<>(collator);
        List<String> stations = new ArrayList<>();
        String station = "";
        int level = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("allomas")) {
                station = line.substring(line.indexOf(":") + 3, line.indexOf(",") - 1);
            }
            if (line.contains("level")) {
                level = Integer.parseInt(line.substring(line.indexOf(":") + 2, line.indexOf(",")));
                if (level == 3) {
//                    map.put(station, level);
                    stations.add(station);
                }
            }

        }
        stations.sort(collator);
        return stations;
    }


}
