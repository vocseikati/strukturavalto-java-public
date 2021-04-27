package multiplymatrix;

import java.util.Arrays;

public class MultiplyMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 6, 2}, {4, 5, 6, 1}, {3, 3, 1, 5}, {9, 0, 5, 2}};
        System.out.println(Arrays.deepToString(multiplyMatrixItems(matrix)));
    }

    public static int[][] multiplyMatrixItems (int[][] inputMatrix){
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                if (i % 2 != 0){
                    if (inputMatrix[i][j] % 2 == 0){
                        inputMatrix[i][j] = inputMatrix[i][j] * 2;
                    }
                }
            }
        }
        return inputMatrix;
    }

}
