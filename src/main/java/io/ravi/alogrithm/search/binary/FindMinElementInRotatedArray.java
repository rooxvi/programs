package io.ravi.alogrithm.search.binary;

public class FindMinElementInRotatedArray {
    public static void main(String[] args) {
       // int[] nums = {4,5,6,-1,-2,0,1,2,3};
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search1(nums));
    }

    //0,1,2,3,4,5,6
    //5,6,0,1,2,3,4

    //0,1,2,3,4,5,6
    //4,5,6,7,0,1,2
    private static int search1(int[] array) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < min) {
                min = array[mid];
            }

            if (array[mid] > array[end]) { // Find which part is rotated
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return min;
    }
}
