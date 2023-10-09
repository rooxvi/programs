package io.ravi.alogrithm;

import java.util.Arrays;

public class QuickSortEx {

    public static void main(String[] args) {
        int[] arr = {5,0,0,2,0,2,2,0,1,1,0,1};
        // Sorting the whole array
        quicksort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void quicksort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            quicksort(arr, low, p-1);
            quicksort(arr, p+1, high);
        }
    }

    static int partition(int[] arr, int low, int high){
        int p = low;
        for(int i=low+1; i <= high; i++)
            if(arr[i] < arr[low])
                swap(arr,i,++p);

        swap(arr, low, p);
        return p;
    }

    static void swap(int[] arr, int low, int pivot){
        int tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }
}
