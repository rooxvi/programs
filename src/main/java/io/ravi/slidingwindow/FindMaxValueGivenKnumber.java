package io.ravi.slidingwindow;

public class FindMaxValueGivenKnumber {

    public static void main(String[] args) {

        System.out.println(findMaxSumGivenK(new int[]{1,2,3,4,5,6},3));
    }

    private static int findMaxSumGivenK(int[] array,int k){
        int runningMaxValue = 0;
        int i=0;

        while (i<k){
            runningMaxValue+=array[i];
            i++;
        }

        while (i<array.length){
            runningMaxValue = Math.max(runningMaxValue,runningMaxValue-array[i-k]+array[i]);
            i++;
        }

        return runningMaxValue;
    }

}
