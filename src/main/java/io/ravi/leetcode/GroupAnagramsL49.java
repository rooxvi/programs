package io.ravi.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsL49 {

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsCharArray(strs));
    }

    public static List<List<String>> groupAnagramsCharArray(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] charFreq = new char[26];
            for(int index = 0; index < str.length() ;index++){
                charFreq[str.charAt(index)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (charFreq[i] != 0) {
                    sb.append('a' + i);
                    sb.append(charFreq[i]);
                }
            }
            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> map = new HashMap<>();
        for(String str: strs){
           HashMap<Character,Integer> charFreq = new HashMap<>();
           for(int index = 0; index < str.length() ;index++){
               charFreq.merge(str.charAt(index),1,Integer::sum);
           }
           if(!map.containsKey(charFreq)){
               map.put(charFreq,new LinkedList<>());
           }
           map.get(charFreq).add(str);
        }

       return map.values().stream()
                .sorted(Comparator.comparingInt(List::size))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<ArrayList<String>> solver(ArrayList<String> list) {

        // Inner hashmap counts frequency of characters in a string. Outer hashmap for if same frequency characters are present in
        // in a string then it will add it to the arraylist.
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for (String str : list) {
            HashMap<Character, Integer> hashKeysOfGivenString = new HashMap<>();
            // Counting the frequency of the characters present in a string

            for (int i = 0; i < str.length(); i++) {
                int count = hashKeysOfGivenString.getOrDefault(str.charAt(i),0);
                hashKeysOfGivenString.put(str.charAt(i), ++count);
            }

            // If the same frequency of chanracters are alraedy present then add that string into that arraylist otherwise
            // created a new arraylist and add that string
            if(!map.containsKey(hashKeysOfGivenString)){
                map.put(hashKeysOfGivenString,new ArrayList<>());
            }

            map.get(hashKeysOfGivenString).add(str);
        }

        // Stores the result in a arraylist
        List<ArrayList<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet())
            result.add(map.get(temp));
        return result;
    }
}
