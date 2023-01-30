package io.ravi.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class L49 {

    public static void main(String[] args) {
    }

    private static ArrayList<ArrayList<String>> solver(ArrayList<String> list) {

        // Inner hashmap counts frequency
        // of characters in a string.
        // Outer hashmap for if same
        // frequency characters are present in
        // in a string then it will add it to
        // the arraylist.
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for (String str : list) {
            HashMap<Character, Integer> hashKeysOfGivenString = new HashMap<>();
            // Counting the frequency of the
            // characters present in a string
            for (int i = 0; i < str.length(); i++) {
                if (hashKeysOfGivenString.containsKey(str.charAt(i))) {
                    int x = hashKeysOfGivenString.get(str.charAt(i));
                    hashKeysOfGivenString.put(str.charAt(i), ++x);
                } else {
                    hashKeysOfGivenString.put(str.charAt(i), 1);
                }
            }

           /* for (int i = 0; i < str.length(); i++) {
                int count = hashKeysOfGivenString.getOrDefault(str.charAt(i),0);
                hashKeysOfGivenString.put(str.charAt(i), ++count);
            }*/

            // If the same frequency of chanracters
            // are alraedy present then add that
            // string into that arraylist otherwise
            // created a new arraylist and add that string
            if (map.containsKey(hashKeysOfGivenString))
                map.get(hashKeysOfGivenString).add(str);
            else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(hashKeysOfGivenString, tempList);
            }
        }

        // Stores the result in a arraylist
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet())
            result.add(map.get(temp));
        return result;
    }
}
