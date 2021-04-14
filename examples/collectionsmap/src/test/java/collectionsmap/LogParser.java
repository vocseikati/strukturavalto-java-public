package collectionsmap;

import java.time.LocalDate;
import java.util.*;

public class LogParser {



    public Map<String, List<Entry>> parseLog(String log) {
        String[] split = log.split("\n");
        List<Entry> entryList = new ArrayList<>();
        Map<String, List<Entry>> result = new HashMap<>();
        for (String s : split) {
            String[] logs = s.split(":");
            if (logs.length != 3){
                throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
            }
            if (!DateValidatorUsingDateTimeFormatter.isValid(logs[1])){
                throw new IllegalArgumentException("Incorrect log: incorrect date");
            }
            Entry entry = new Entry(logs[0], LocalDate.parse(logs[1]), logs[2]);
            entryList.add(entry);
            result.put(entry.getIpAddress(), entryList);
        }
        return result;
    }
}
