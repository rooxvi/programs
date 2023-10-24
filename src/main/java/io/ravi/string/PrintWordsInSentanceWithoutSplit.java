package io.ravi.string;

public class PrintWordsInSentanceWithoutSplit {

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";
        printWords(s);
    }

    private static void printWords(String s){
        int left=0;
        int right = 0;

        while (left<s.length()){
            while (left<right || left< s.length() && s.charAt(left) == ' '){
                left++;
            }

            while (right<left || right < s.length() &&  s.charAt(right) != ' '){
                right++;
            }

            System.out.println(s.substring(left,right));

        }

    }

}
