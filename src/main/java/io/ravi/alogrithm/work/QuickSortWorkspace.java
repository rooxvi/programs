package io.ravi.alogrithm.work;

import java.util.Arrays;

public class QuickSortWorkspace {

    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(array)));
    }

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    static int partition(int[] array, int start, int end) {
       int pivot = start;
       int i = start;
       int j = end;

       while (i < j){
           while (i < j && array[++i] < array[pivot]);

           while (i < j && array[--j] > array[pivot]);

           swap(array,i,j);
       }
       swap(array,j,pivot);
       return j;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}


