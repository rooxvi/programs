package io.ravi.programs;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordsInLine {
    public static void main(String[] args) throws InterruptedException {

        String words = "find how many times a word is repeating in a string , find the word and count";

       Map<String,Long> wordCount =  Arrays.stream(words.split(" ")).collect(
                Collectors.groupingBy(Function.identity(),
                        Collectors.counting())
        );

        System.out.println(wordCount);


        String duplicate = "big black bug bit a big black dog on his big black nose";


       Runnable runnable = ()-> System.out.println("Hello");

       Thread thread = new Thread(runnable);

       thread.start();

       Thread.sleep(3 * 1000);

       thread.join();


    }
}
