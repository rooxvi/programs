package io.ravi.programs.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FixedSize {
    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 5, 6, 3, 8, 1};
        int k = 3;
        System.out.println(minSumOfKElement1(arr, k));
    }

    //Method 1
    public static int minSumOfKElement(int[] arr, int k) {
        int minValue = Integer.MAX_VALUE;
        int runningSum = 0;
        for (int i = 0; i < k; i++) {
            runningSum += arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            minValue = Math.min(runningSum, minValue);
            runningSum += arr[i];
            runningSum -= arr[i - k];
        }
        return minValue;
    }


    //Method 2
    public static int minSumOfKElement1(int[] arr, int k) {
        int minValue = Integer.MAX_VALUE;
        int runningSum = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if (i >= k-1) {
                minValue = Math.min(runningSum, minValue);
                runningSum -= arr[i - (k-1)];
            }
        }
        return minValue;
    }
}


class DynamicSize{
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
        Map<Character,Integer> bucket = new HashMap<>();
        int currentMaxCount = Integer.MIN_VALUE;
        int startWindow = 0;
        for(int endWindow = 0;endWindow<s.length();endWindow++){
            if(!bucket.containsKey(s.charAt(endWindow))){
                bucket.put(s.charAt(endWindow),endWindow);
                currentMaxCount = Math.max(currentMaxCount,endWindow-startWindow+1);
            }else{
                startWindow = bucket.get(s.charAt(endWindow))+1;
            }
        }
        return currentMaxCount;
    }
    public void subArraySumOfGivenValue(int[] arr,int k){

    }
}