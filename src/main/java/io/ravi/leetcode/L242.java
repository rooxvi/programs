package io.ravi.leetcode;

import java.util.Arrays;

public class L242 {

    public static void main(String[] args) {
        System.out.println(isValid("mam","amn"));
    }
    public static boolean isValid(String l,String r){
        if(l.length() != r.length()) return false;
        int[] count_charts = new int[26];
        System.out.println(Arrays.toString(count_charts));
        for(int i = 0;i<l.length();i++){
            count_charts[l.charAt(i)-'a']++;  // int value = count_charts[l.charAt(i)-'a']; value = value + count_charts[l.charAt(i)-'a'] = value;
            count_charts[r.charAt(i)-'a']--;
         }
        System.out.println(Arrays.toString(count_charts));
        for (int value: count_charts){
            if(value!=0)
                return false;

        }
        return true;
    }

    public static boolean isValidWithChars(String l,String r){
        if(l.length() != r.length()) return false;
        int[] count_charts = new int[256];
        System.out.println(Arrays.toString(count_charts));
        for(int i = 0;i<l.length();i++){
            count_charts[l.charAt(i)]++;  // int value = count_charts[l.charAt(i)-'a']; value = value + count_charts[l.charAt(i)-'a'] = value;
            count_charts[r.charAt(i)]--;
        }
        System.out.println(Arrays.toString(count_charts));
        for (int value: count_charts){
            if(value!=0)
                return false;

        }
        return true;
    }
}
