package cross;

public class DrawCrosshair {

    public static void main(String[] args) {
        drawCrosshair(9);
    }

    public static void drawCrosshair(int number) {
        if (number < 3 || number % 2 == 0) {
            throw new IllegalArgumentException("The number should be 3 or more and odd.");
        }
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i == number / 2 || j == number / 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
