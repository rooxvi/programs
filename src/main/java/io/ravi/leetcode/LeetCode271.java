package io.ravi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode271 {

    public static void main(String[] args) {
        List<String> ls = List.of("Hello", "World","New","1");
        System.out.println(ls);
        String s = encode(ls);
        System.out.println(s);

        System.out.println(decode(s));

    }

    /**
     * Convert each word to length#word eg. 4#Hello
     */
    private static String encode(List<String> s) {
        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str.length()+"#"+str);
        }
        return sb.toString();
    }

    /**
     * First read length and check `#` for length end. Then convert string length to integer and use
     * Integer.value(lengthStr) then use substring to get each word
     * @param s
     * @return
     */
    private static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
             String lenStr="";
             while (s.charAt(i) != '#') {
                 lenStr+=s.charAt(i);
                 i++;
             }
             int wordLength = Integer.valueOf(lenStr);
             String str = s.substring(i+1,i+1+wordLength);
             res.add(str);
             i = i+1+wordLength;
        }
        return res;
    }
}
