package lambdastreams.baseoperations;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {

    private List<Integer> integers;

    public Numbers(List<Integer> integers) {
        this.integers = integers;
    }

    public Optional<Integer> min() {
        return integers.stream().min(Comparator.comparingInt(Integer::intValue));
        //return numbers.stream().min(Comparator.naturalOrder());
    }

    public int sum() {
        return integers.stream().mapToInt(Integer::intValue).sum();
        // return numbers.stream().reduce(0, (a,b) -> a+b);
    }

    public List<Integer> getDistinctElements() {
        return new ArrayList<>(new HashSet<>(integers));
        // public Set<Integer> getDistinctElements(){
        //        return numbers.stream().collect(Collectors.toSet());
        //    }
    }

    public boolean isAllPositive() {
        return integers.stream().allMatch(x -> x > 0);
    }
}
