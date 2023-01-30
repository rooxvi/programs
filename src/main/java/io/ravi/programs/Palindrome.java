package io.ravi.programs;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("malayyalam"));
    }
    public static int isPalindrome(String s) {
        return isPalindrome(s, 0,s.length()-1);
    }

    private static int isPalindrome(String s, Integer i,Integer j){
        if(i == j || i>j){
            return 1;
        }
        if( i<j && (s.charAt(i) == s.charAt(j))){
           // i++;
           // j--;
            return isPalindrome(s,++i,--j);
        }
        return 0;
    }
}
