package io.ravi.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,6,5,4};
        findSecondLargestNumberInArray(nums,4);
    }

    private static int findSecondLargestNumberInArray(int[] array, int k) {

        PriorityQueue<Integer> integers = new PriorityQueue<>(k,Collections.reverseOrder());


        for (int i = 0; i < array.length; i++) {
            if (integers.size() > k) {
                integers.poll();
            }
            integers.add(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(integers.poll());
        }
        //return integers.poll();
        return 0;
    }
}
