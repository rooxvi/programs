package io.ravi.alogrithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        int[] arr = {4, 8, 1, 10, 13, 5, 2, 7};
        // Sorting the whole array
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    //routine to sort the array partitions recursively
    void quickSort(int intArray[], int low, int high) {
        if (low < high) {
            //partition the array around pi=>partitioning index and return pi
            int pi = partition(intArray, low, high);
            // sort each partition recursively
            quickSort(intArray, low, pi-1);
            quickSort(intArray, pi+1, high);
        }
    }

    int partition(int intArray[], int low, int high) {
        int pi = intArray[high];
        int i = (low-1); // smaller element index
        for (int j=low; j<high; j++) {
            // check if current element is less than or equal to pi
            if (intArray[j] <= pi) {
                i++;
                // swap intArray[i] and intArray[j]
              swap(intArray,i,j);
            }
        }

        // swap intArray[i+1] and intArray[high] (or pi)
        swap(intArray,i+1,high);

        return i+1;
    }
    void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
