package io.ravi.array;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;  // Handle cases where k > length of array
        reverse(nums, 0, nums.length - 1);  // Step 1: Reverse the entire array
        reverse(nums, 0, k - 1);            // Step 2: Reverse the first k elements
        reverse(nums, k, nums.length - 1);  // Step 3: Reverse the remaining elements
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(java.util.Arrays.toString(arr));  // Output: [5, 6, 7, 1, 2, 3, 4]
    }
}
