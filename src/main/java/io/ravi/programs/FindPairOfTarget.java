package io.ravi.programs;

import java.util.HashMap;
import java.util.Map;

public class FindPairOfTarget {
    public static void main(String[] args) {
        int[] nums = { 8, 7, 2, 5, 3, 1 };
        int target = 10;

        findPair(nums, target);
    }

    public static void findPair(int[] arrays,int target){
        Map<Integer,Integer> values = new HashMap<>();
        for(int i=0;i<arrays.length;i++){
            if(values.containsKey(target-arrays[i])){
                System.out.printf("Pair found (%d, %d)",
                        arrays[values.get(target - arrays[i])], arrays[i]);
                return;
            }
            values.put(arrays[i],i);
        }
        System.out.println("Pair not found...");
    }
}
