package io.ravi.leetcode;

/**
 * Constraints:
 *
 * 2 <= s.length <= 100
 * s consists of lowercase English letters.
 * s has at least one repeated letter.
 */
public class FirstLetterToAppearTwice2351 {
    public static void main(String[] args) {
        System.out.println(firstLetter("zrzavvi"));
    }

    private static char firstLetter(String word) {
        char[] chars = new char[26];
        for (int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'a']++;
            if (chars[word.charAt(i) - 'a'] > 1) {
                return word.charAt(i);
            }
        }
        return 0;
    }
}
