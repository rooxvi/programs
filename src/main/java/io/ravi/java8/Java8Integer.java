package io.ravi.java8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Integer {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(3,4,1,7,2,9,5,6,8);

        Integer sum =  numbers.stream().mapToInt(Integer::valueOf).sum();
        System.out.println(sum);

        List<Integer> sortedValue = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedValue);

        List<Integer> sortedValueComp = numbers.stream()
                                               .sorted(Comparator.comparing(Integer::new))
                                               .collect(Collectors.toList());
        System.out.println(sortedValueComp);
    }
}
