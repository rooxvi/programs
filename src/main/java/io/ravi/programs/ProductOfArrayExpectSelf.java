package io.ravi.programs;

import java.util.Arrays;

public class ProductOfArrayExpectSelf {

    public static void main(String[] args) {
        int arr[] = { 1 , 4 , 6 , 2 , 3};
        System.out.println(Arrays.toString(productOfArrayExpectSelf(arr)));
    }

    private static int[] productOfArrayExpectSelf(int[] array){
        int arrayLength = array.length;

        int[] result = new int[arrayLength];

        int[] prefix = new int[arrayLength];
        prefix[0] = 1;
        for (int i=1;i<arrayLength;i++){
            prefix[i] = prefix[i-1] * array[i-1];
        }

        int[] suffix = new int[arrayLength];
        suffix[arrayLength-1] = 1;
        for (int i = arrayLength-2 ;i>=0 ;i--){
            suffix[i] = suffix[i+1] * array[i+1];
        }

        for (int i=0;i<arrayLength;i++){
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}
