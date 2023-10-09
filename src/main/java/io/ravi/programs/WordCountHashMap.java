package io.ravi.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCountHashMap {
    public static void main(String[] args) {
        System.out.println(wordCount8("Hello hello How are you man"));
    }

    private static Map<String,Integer> wordCount(String words){
        Map<String,Integer> wordsCount = new HashMap<>();
        for (String word: words.split(" ")){
             if(wordsCount.containsKey(word)){
                 wordsCount.put(word, wordsCount.get(word)+1);
             }else {
                 wordsCount.put(word,1);
             }
        }
        return wordsCount;
    }


    private static Map<String,Integer> wordCount8(String words){
        return Arrays.stream(words.split(" ")).map(String::toLowerCase).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(),Long::intValue)
                )
        );
    }
}
