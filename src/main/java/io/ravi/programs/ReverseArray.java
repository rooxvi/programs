package io.ravi.programs;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        reverseArray(new int[]{1,2,3,4});
    }

    public static void reverseArray(int[] arr){
        int len = arr.length;
        for (int i=0 ; i<len/2 ; i++){
            int temp = arr[i];
            arr[i]=arr[len-1-i];
            arr[len-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

