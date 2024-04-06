package io.ravi.string;

public class ReverseStringWithoutSpecialCharacter {
    public static void main(String[] args) {
        System.out.println(reverseStringWithoutSpecialCharacter("Ra$Vi.S"));
    }

    private static String reverseStringWithoutSpecialCharacter(String word) {
        StringBuilder wordBuilder = new StringBuilder(word);
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetter(wordBuilder.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetter(wordBuilder.charAt(right))) {
                right--;
            }

            char temp = wordBuilder.charAt(left);
            wordBuilder.setCharAt(left, wordBuilder.charAt(right));
            wordBuilder.setCharAt(right, temp);

            left++;
            right--;
        }
        return wordBuilder.toString();
    }
}
