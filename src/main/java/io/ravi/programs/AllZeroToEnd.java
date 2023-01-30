package io.ravi.programs;

import java.util.Arrays;
import java.util.List;

public class AllZeroToEnd {
    public static void main(String[] args) {
        int x[] = {1,3,0,0,4,0,66,0,2,3,0,66};
        System.out.println(Arrays.toString(x));
        moveAllZeroToEnd(x);
        System.out.println(Arrays.toString(x));
    }

    public static void moveAllZeroToEnd(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            while(arr[j] == 0){
                j--;
            }
            if(arr[i] == 0){
                arr[i] = arr[j];
                arr[j] = 0;
                j--;
            }
            i++;
        }
    }


    public static List<Integer> moveAllZeroToEnd(int n,List<Integer> arr){
        int i= n - arr.size();
        int j = n;
        while(i < j){
            while(arr.get(j) == 0){
                j--;
            }
            if(arr.get(i) == 0){
                arr.set(i,arr.get(j));
                arr.set(j,0);
                j--;
            }
            i++;
        }
        return arr;
    }
}
