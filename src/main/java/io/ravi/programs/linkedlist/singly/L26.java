package io.ravi.programs.linkedlist.singly;

public class L26 {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i=0;i<nums.length;i++){
           if(i>0 && nums[i] == nums[i-1]) {
               continue;
           }
        }

        return 0;
    }
}
