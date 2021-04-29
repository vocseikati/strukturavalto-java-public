package getMostcommoncharacter;

import java.util.*;

public class GetMostCommonCharacter {

    public static void main(String[] args) {
        System.out.println(getMostCommonCharacter("apple, jjjj...   brr"));
    }

    public static String getMostCommonCharacter(String input) {
        String clearInput = input.replaceAll("[^A-Za-z0-9öüóőúéáűíÖÜÓŐÚÉÁŰÍ\\s]", "");
        char[] chars = clearInput.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : chars) {
            if (c != ' ') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return String.valueOf(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());



    }

}
