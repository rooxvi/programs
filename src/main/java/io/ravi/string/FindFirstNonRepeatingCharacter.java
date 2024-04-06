package io.ravi.string;

import java.util.Arrays;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String word = "aaabbxbccdeeeffg";
        System.out.println(firstNonRepeatingCharacter(word));
    }

    private static char firstNonRepeatingCharacter(String word) {
        char[] chars = new char[26];
        for (int index = 0; index < word.length(); index++) {
            chars[word.charAt(index) - 'a']++;
        }
          System.out.println(Arrays.toString(chars));
        for (int index = 0; index < word.length(); index++) {
            if (chars[word.charAt(index) - 'a'] == 1) {
                return word.charAt(index);
            }
        }
        return '_';
    }
}
