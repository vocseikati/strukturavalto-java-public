package exam02;

import java.util.ArrayList;
import java.util.List;

public class ArraySelector {


    public String selectEvens(int[] input) {
        StringBuilder sb = new StringBuilder();
        if (input.length == 0) {
            return sb.toString();
        }
        sb.append("[");
        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                if (input.length > 2 && i < input.length-2){
                    sb.append(input[i]).append(", ");
                }else {
                    sb.append(input[i]);
                }
            }

        }
        sb.append("]");
        return sb.toString();
    }

}
