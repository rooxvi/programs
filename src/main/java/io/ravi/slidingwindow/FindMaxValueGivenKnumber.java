package io.ravi.slidingwindow;

public class FindMaxValueGivenKnumber {

    public static void main(String[] args) {

       // System.out.println(findMaxSumGivenK(new int[]{1,2,3,4,5,6},3));
        System.out.println(findMinSubArray(new int[]{1,2,3,4,-1,5},7));
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

    // {1,5,3,4,-1,5}, 7
    private static int findMinSubArray(int[] array, int target){
        int windowSum = 0;
        int windowStart=0;
        for ( int windowEnd=0;windowEnd<array.length;windowEnd++ ){
            windowSum+=array[windowEnd];
            while (windowSum >= target){
                System.out.println(windowSum+" : "+ windowStart+" --- "+windowEnd);
                windowSum -= array[windowStart];
                System.out.println(windowSum+" : "+ windowStart+" --- "+windowEnd);
                windowStart++;
            }
        }

        return windowSum;
    }

}
