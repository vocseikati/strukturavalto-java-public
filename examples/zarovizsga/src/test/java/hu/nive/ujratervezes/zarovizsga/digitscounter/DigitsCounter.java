package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {


    public int getCountOfDigits(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        String temp = "0123456789";
        Set<Integer> numbers = new HashSet<>();
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            if (temp.contains(split[i])){
                numbers.add(Integer.parseInt(split[i]));
            }
        }
        return numbers.size();
    }
    //if (s == null) {
    //            return 0;
    //        }
    //
    //        Set<Character> chars = new HashSet<>();
    //        for (char c: s.toCharArray()) {
    //            if (Character.isDigit(c)) {
    //                chars.add(c);
    //            }
    //        }
    //        return chars.size();
    //    }

}
