package multiplybymaximum;

public class MultiplyByMaximum {


    public int[] multiplyByMaximum(int[] numbers, int n) {
        if (numbers == null || n < 1) {
            throw new IllegalArgumentException();
        }
        if (numbers.length == 0) {
            return new int[0];
        }
        int max = max(numbers);
        for (int i = n - 1; i < numbers.length; i += n) {
            numbers[i] = numbers[i] * max;
        }
        return numbers;
    }

    private int max(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }


}
