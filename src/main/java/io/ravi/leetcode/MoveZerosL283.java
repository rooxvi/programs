package io.ravi.leetcode;

import java.util.Arrays;

public class MoveZerosL283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZero(nums);
        System.out.println(Arrays.toString(nums)); // {1,3,12,0,0}
    }

    private static void moveZero(int[] nums){
        int nonZeroIndex = 0;
        int zeroIndex = 0;

        while (nonZeroIndex < nums.length){

            while (nonZeroIndex< nums.length-1 &&  nums[nonZeroIndex] == 0){
                nonZeroIndex++;
            }

            int temp = nums[zeroIndex];
            nums[zeroIndex] = nums[nonZeroIndex];
            nums[nonZeroIndex] = temp;
            zeroIndex++;
            nonZeroIndex++;
        }

    }
}