package exam03retake01;

public class CdvCheck {


    public boolean check(String s) {
        if (s == null || s.length() != 10 || !s.matches(".*\\d.*")) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            sum += Integer.parseInt(String.valueOf(chars[i])) * (i + 1);
        }
        return (sum % 11 == Integer.parseInt(String.valueOf(chars[chars.length - 1])));
    }
}
