package io.ravi.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L128 {

    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        System.out.println( longestConsecutive(nums));;
    }
    public static int longestConsecutive(int[] nums) {
        int longestSequnceLength = 0;
        Map<Integer,Boolean> numsMap = new HashMap<>();
        for(int num:nums){
            numsMap.put(num,Boolean.FALSE);
        }

        for (int num: nums){
            int currentSequenceLength = 1;

            //Check forward direction
            int nextNum = num + 1;
            while (numsMap.containsKey(nextNum) && numsMap.get(nextNum) == false){
                currentSequenceLength++;
                numsMap.put(nextNum,Boolean.TRUE);
                nextNum++;
            }

            //Check reverse direction
            int preNum = num-1;
            while (numsMap.containsKey(preNum) && !numsMap.get(preNum)){
                currentSequenceLength++;
                numsMap.put(preNum,Boolean.TRUE);
                preNum--;
            }
            longestSequnceLength = Math.max(longestSequnceLength,currentSequenceLength);
        }

        return longestSequnceLength;
    }
}

class BruteForce {
    public static void main(String[] args) {
        int[] nums = {5,100, 4, 200, 2, 1,6,-1,0};
        longestSolution(nums);
    }

    private static void longestSolution(int[] nums) {
        int maxLength = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
           int currentNum = nums[i];
           int currentMaxSeq = 1;
           int j=0;
           while (j < length){
               if(currentNum+1 == nums[j]){
                   currentNum = currentNum+1;
                   currentMaxSeq = currentMaxSeq+1;
                   j = 0;
               }else {
                   j++;
               }
            }
           maxLength = Math.max(maxLength,currentMaxSeq);
        }
    }

}

class Optimized {
    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        System.out.println( longestSolution(nums));;
    }
    private static int longestSolution(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int maxSequnceLength = 1;
        int runningSequenceLength = 1;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                continue;
            }
            if( nums[i]+1 == nums[i+1]){
                runningSequenceLength = runningSequenceLength+1;
            }else {
                runningSequenceLength = 1;
            }
            maxSequnceLength = Math.max(maxSequnceLength,runningSequenceLength);
        }
        return maxSequnceLength;
    }
}
