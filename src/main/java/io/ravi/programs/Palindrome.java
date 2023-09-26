package io.ravi.programs;

public class Palindrome {

    public static void main(String[] args) {
        //System.out.println(isPalindrome("malayyalam"));
        System.out.println(isChanceForPalindrome("malaabyyalam"));
    }

    public static int isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static int isPalindrome(String s, Integer i, Integer j) {
        if (i == j || i > j) {
            return 1;
        }
        if (i < j && (s.charAt(i) == s.charAt(j))) {
            // i++;
            // j--;
            return isPalindrome(s, ++i, --j);
        }
        return 0;
    }


    private static boolean isChanceForPalindrome(String s) {
        if (s == null) return false;

        if (s.length() == 1) {
            return true;
        }

        char[] chars = new char[58];

        for (char c : s.toCharArray()) {
            if (chars[c - 'a'] == 2) {
                chars[c - 'a'] = 0;
            }
            chars[c - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 57; i++) {
            if (chars[i] == 1) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
