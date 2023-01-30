package io.ravi.programs;

public class MaxSumOfSubArrayInGivenArray {
    public static void main(String args[]) {
        System.out.println(maxSubArray(new int[]{-2,-4,-9,-19}));
    }

    public static int maxSubArray(int[] array){
        int max = array[0];
        int newSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]<newSum+array[i]){
                newSum = newSum+array[i];
            }else {
                newSum = array[i];
            }
            if(max < newSum){
                max = newSum;
            }
        }
       return max;
    }

    public static int maxSubArray1(int[] array){
        int max=array[0];
        int newSum = array[0];
        for (int i=1;i<array.length;i++){
            newSum = Integer.max(newSum+array[i],array[i]);
            max = Integer.max(max,newSum);
        }
        return max;
    }
}
