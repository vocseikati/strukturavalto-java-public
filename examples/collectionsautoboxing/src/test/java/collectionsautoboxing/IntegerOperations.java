package collectionsautoboxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerOperations {
    public List<Integer> createList(int... numbers) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            result.add(number);
        }
        return result;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }
}
