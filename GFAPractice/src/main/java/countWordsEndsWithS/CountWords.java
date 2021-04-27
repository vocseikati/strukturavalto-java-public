package countWordsEndsWithS;

import java.nio.file.Paths;
import java.util.Locale;

public class CountWords {

    public static void main(String[] args) {
        System.out.println(countWordsEndsWithS("ends. with, S characters! 003s"));
    }
    public static int countWordsEndsWithS(String input){
        String clearString = input.replaceAll("[^A-Za-z0-9öüóőúéáűíÖÜÓŐÚÉÁŰÍ\\s]", "");
        String[] split = clearString.split(" ");
        int counter = 0;
        for (String s : split) {
            if (s.toLowerCase().endsWith("s")){
                counter++;
            }
        }
        return counter;
    }
}
