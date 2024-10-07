package io.ravi.leetcode.heap;

import java.util.PriorityQueue;

public class FindKthSmallestElementInArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6, 7, 8};
        System.out.println(findKthSmallest(array, 2));
    }

    public static int findKthSmallest(int[] nums, int k) {

        // Max-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}