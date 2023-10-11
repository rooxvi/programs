package io.ravi.java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class STGLabs {
    public static void main(String[] args) {

        // Return second-highest salary
        Map<String,Integer> map = new HashMap<>();
        map.put("pankaj",100000);
        map.put("mukesh",200000);
        map.put("rajesh",400000);
        map.put("sanu",300000);

        String name =map.entrySet().stream()
                //.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .get(1);
        System.out.println(name);

        //Find the longest String from a given Array using java 8
        String[] strArray={"Java","sai","system","microservices"};
        Optional<String> max = Arrays.stream(strArray)
                                     .max(Comparator.comparingInt(String::length));
        if (max.isPresent()){
            System.out.println(max.get());
        }


    }
}
