package io.ravi.alogrithm.search.binary;

public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1, 2, 4, 5, 7, 9};
        // int ans = binarySearch(array, 0, array.length - 1, 7);
        // System.out.println(ans);

        int indexAns = binarySearchIteration(array, 0, array.length - 1, 4);
        System.out.println(indexAns);
    }

    private static int binarySearch(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int midIndex = low + (high - low) / 2;
            if (arr[midIndex] == k)
                return midIndex;
            if (arr[midIndex] > k)
                return binarySearch(arr, low, midIndex - 1, k); // return statement is important
            return binarySearch(arr, midIndex + 1, high, k); // return statement is important
        }
        return -1;
    }

    private static int binarySearchIteration(int[] arr, int low, int high, int k) {
        while (low <= high) {
            int midIndex = low + (high - low) / 2;
            if (arr[midIndex] == k)
                return midIndex;
            if (arr[midIndex] > k) {
                high = midIndex - 1;
            } else {
                low = midIndex + 1;
            }
        }
        return -1;
    }
}