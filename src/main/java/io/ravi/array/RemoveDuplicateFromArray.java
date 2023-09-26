package io.ravi.array;

import java.util.Arrays;

public class RemoveDuplicateFromArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicate(new int[]{1,1,2,2,2,3})));
    }

    private static int[] removeDuplicate(int[] nums){

        int i = 0;
        int j = 1;
        while (i < nums.length-1){
            if(nums[i] != nums[i+1]){
                nums[j] = nums[i+1];
                j++;
            }
            i++;

        }
        return nums;
    }
}
