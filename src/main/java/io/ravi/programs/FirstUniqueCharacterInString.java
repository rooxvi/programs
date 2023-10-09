package io.ravi.programs;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        //firstUniqueChar("Ravichandran");
        //System.out.println(firstUniqueNumber(List.of(1,2,4,3,1,2,3)));;
    }

    public static String firstUniqueChar(String s) {

        Map<Character, Long> charArray = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            charArray.merge(c, 1L, Long::sum);
        }

        Character p = charArray.entrySet().stream().filter(e -> e.getValue() == 1L).map(e -> e.getKey()).findFirst().get();
        System.out.println(p);

        Stream<Character> characterStream = s.chars().mapToObj(c -> (char) c);
        Character find = characterStream.collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting())
                )
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst().get();
        System.out.println(find);
        return "";
    }

    public static int firstUniqueNumber(List<Integer> numbers) {
        Map<Character, Long> charArray = new LinkedHashMap<>();
        int unique = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            unique ^= numbers.get(i);
        }
        return unique;
    }


    public static int firstUniqueCharacterUsingCharArray(String word) {

        char[] count = new char[256];
        for (int index = 0; index < word.length(); index++) {
            count[word.charAt(index)]++;
        }

        for (int index = 0; index < word.length(); index++) {
            if (count[word.charAt(index)] == 1) {
                return index;
            }
        }

        return -1;
    }


}
