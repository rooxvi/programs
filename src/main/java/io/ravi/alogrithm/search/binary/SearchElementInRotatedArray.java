package io.ravi.alogrithm.search.binary;

import java.util.HashMap;

public class SearchElementInRotatedArray {

    public static void main(String[] args) {
        int[] array = {4,5,7,1,3};
        System.out.println(search(array,0,array.length-1,3));
    }

    private static int search(int[] array,int low,int high,int k){
        while (low <= high){
            int midIndex = low + (high - low)/2;
            if(array[midIndex] == k) return midIndex;
            if(array[low] <= array[midIndex]){
                if (array[low] <= k && array [midIndex] <= k){
                    high = midIndex - 1;
                }else {
                    low = midIndex+1;
                }
            }else {
                if(array[midIndex] <= k &&  k <= array[high]){
                    low = midIndex +1;
                }else {
                    high = midIndex -1;
                }
            }
        }
        return -1;
    }
}
