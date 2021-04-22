package hu.nive.ujratervezes.zarovizsga.words;

public class Words {


    public boolean hasMoreDigits(String s) {
        int digitCounter = 0;
        int letterCounter = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCounter++;
            }
            if (Character.isAlphabetic(c)) {
                letterCounter++;
            }
        }
        return digitCounter > letterCounter;
    }
}
