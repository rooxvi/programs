package io.ravi.programs;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{1,2,3,4,5,6},9);
        System.out.println("("+result[0]+","+result[1]+")");
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i); // map<value,index>
        }

        return result;
    }
}
