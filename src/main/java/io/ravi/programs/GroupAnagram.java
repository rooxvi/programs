package io.ravi.programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagram {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("CARS", "REPAID", "DUES", "NOSE", "SIGNED",
                "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN");

        Set<List<String>> anagrams = groupAnagrams(words);
        for (List<String> anagram: anagrams) {
            System.out.println(anagram);
        }
    }
    public static Set<List<String>> groupAnagrams(List<String> words){
        Map<String,List<String>> wordsGroups = new HashMap<>();
        //If words are empty/null then return empaty set
        if(Objects.isNull(words)){
            return null;
        }
        for(String word: words){
            String sortedWord = Arrays.stream(word.split(""))
                                      .sorted()
                                      .collect(Collectors.joining());
            wordsGroups.putIfAbsent(sortedWord,new ArrayList<>());
            wordsGroups.get(sortedWord).add(word);
        }
        return wordsGroups.values()
                          .stream().
                           collect(Collectors.toSet());
    }

}
