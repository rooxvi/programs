package io.ravi.alogrithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {23, -1, 0, 2, 76, -19};
        mergesort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    static void mergesort(int[] array, int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            //sorting the left half
            mergesort(array, left, mid);
            //sorting the right half
            mergesort(array, mid + 1, right);
            //merging both the halves
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int rightArray[] = new int[mid - left + 1];
        int leftArray[] = new int[right - mid];

  /*
    Populating the left
    range elements in the
    rightArray array.
  */
        for (int i = left; i <= mid; i++) {
            rightArray[i] = array[left+i];
        }

  /*
    Populating the right
    range elements in the
    rightArray array.
  */
        for (int i = mid + 1; i <= right; i++) {
            leftArray[i - mid - 1] = array[i];
        }

        int i = 0, j = 0, k = left;

        //merging the elements of both the ranges.
        while (i < rightArray.length && j < leftArray.length) {
            if (rightArray[i] <= leftArray[j]) {
                array[k++] = rightArray[i++];
            } else {
                array[k++] = leftArray[j++];
            }
        }

        //checking if any of the elements left.
        while (i < rightArray.length) array[k++] = rightArray[i++];
        while (j < leftArray.length) array[k++] = leftArray[j++];
    }
}

