package mergearrays;

import java.util.Arrays;

public class MergeElements {

    public static void main(String[] args) {
        String[] first = {"apple", "pear", "banana", "orange"};
        String[] second = {"dog", "cat"};
        String[] third = {"dog", "cat", "giraffe", "fish"};
        System.out.println(Arrays.toString(mergeElements(first, second)));
        System.out.println(Arrays.toString(mergeElements(second, first)));
        System.out.println(Arrays.toString(mergeElements(first, third)));

    }

    public static String[] mergeElements(String[] input1, String[] input2) {
        String[] result = new String[input1.length + input2.length];
        int minLength = Math.min(input1.length, input2.length);

        for (int i = 0; i < minLength * 2; i++) {
            if (i % 2 == 0) {
                result[i] = input1[i / 2];
            } else {
                result[i] = input2[i / 2];
            }
        }
        if (input1.length >= input2.length) {
            for (int i = minLength; i < input1.length; i++) {
                result[i+2] = input1[i];
            }
        }else {
            for (int i = minLength; i < input2.length; i++) {
                result[i+2] = input2[i];
            }
        }
        return result;
    }

}
