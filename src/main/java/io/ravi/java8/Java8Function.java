package io.ravi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Function {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple","banana","orange");

        Function<String,String> toUpperCase = String::toUpperCase;
        Function<String,String> addPrefix = string -> "Prefix_"+string;
        Function<String,String> reverseString = string -> new StringBuilder(string).reverse().toString();

        // Compose the transformations
        Function<String,String> composedFunction = toUpperCase
                .andThen(Function.identity())
                .andThen(reverseString)
                .andThen(addPrefix);

        // Apply the composed function to each word
        List<String> result = words.stream()
                .map(composedFunction)
                .collect(Collectors.toList());

        System.out.println(result);

    }
}