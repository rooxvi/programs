package io.ravi.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopMostFrequestKNumber {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> bucket = new HashMap<>();
        for(int num:nums){
            if(!bucket.containsKey(num)){
                bucket.put(num,0);
            }
            bucket.put(num,bucket.get(num)+1);
        }

        System.out.println(bucket);
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(bucket.entrySet());


        entryList.sort((e1, e2) -> e2.getValue() - e1.getValue());

        System.out.println(entryList);

        int count = 0;
        int[] result = new int[k];
        for(Map.Entry<Integer,Integer> entry : entryList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            result[count++] = entry.getKey();
            if(count == k){
                break;
            }
        }

        return result;

    }
}