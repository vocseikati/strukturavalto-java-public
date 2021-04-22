package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.*;

public class UniqueFinder {
    public List<Character> uniqueChars(String input) {
        if (input == null){
            throw new IllegalArgumentException();
        }
        List<Character> result = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (!result.contains(c)){
                result.add(c);
            }
        }
        return result;
    }
}
