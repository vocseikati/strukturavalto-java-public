package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.*;

import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getResourceAsStream;

public class BalatonStorm {
//
//    public static final Gson GSON = new Gson();
//    public static final String DB_PATH = "src/test/resources/exam03retake02/storm.json";
//    private HashMap<Integer, Station> database;
//
//    public HashMap<Integer, Station> loadJSON(Path path) throws IOException {
//        byte[] jsonBytes = Files.readAllBytes(path);
//        String jsonStr = new String(jsonBytes, StandardCharsets.UTF_8);
//        Type type = new TypeToken<HashMap<String, Station>>() {
//        }.getType();
//        return GSON.fromJson(jsonStr, type);
//    }
//
//    protected void loadDB() throws IOException {
//        Path path = Paths.get(DB_PATH);
//        database = loadJSON(path);
//    }
//
//    public void init() throws IOException {
//        if (database == null) {
//            database = new HashMap<>();
//            loadDB();
//        }
//
//        System.out.println("init has been called");
//    }
//
//    public static void main(String[] args) throws IOException {
//        BalatonStorm balaton = new BalatonStorm();
//        balaton.init();
//        HashMap<Integer, Station> json = balaton.loadJSON(Paths.get("src/test/resources/exam03retake02/storm.json"));
//        System.out.println(json);
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

//    public static void main(String[] args) throws IOException {
//
//        BufferedReader reader = Files.newBufferedReader(Paths.get("stormtest.json"));
//        System.out.println(getStationsInStorm(reader));
//
//
//
//
//    }
}
