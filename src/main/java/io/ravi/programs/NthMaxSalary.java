package io.ravi.programs;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthMaxSalary {
    public static void main(String[] args) {

        int n =3;
        Map<String,Integer> salary = null;// Map.of("Ravi",200,"Ramu",50,"Raj",100,"Kumar",100,"Antha",25);
        Map.Entry<Integer, List<String>> result = salary.entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue
                        ,Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList()
                        )
                ))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(n-1);

        System.out.println(result);
    }
}
