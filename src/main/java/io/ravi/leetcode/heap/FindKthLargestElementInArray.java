package io.ravi.leetcode.heap;

import java.util.PriorityQueue;

public class FindKthLargestElementInArray {

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(array, 2));
    }

    public static int findKthLargest(int[] nums, int k) {

        // Create a min-heap (PriorityQueue in Java)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}