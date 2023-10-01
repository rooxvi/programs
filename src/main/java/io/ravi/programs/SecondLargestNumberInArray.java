package io.ravi.programs;

import java.util.Collections;
import java.util.PriorityQueue;

public class SecondLargestNumberInArray {
    public static void main(String[] args) {

        int[] array = {-1,-3,1, 2, 3, 4, 6};
        System.out.println(findSecondLargestNumberInArray(array));

    }

    // Note: Not completed
    private static int findSecondLargestNumberInArray(int[] array) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());
        for (int index = 0; index < array.length; index++) {
            integers.add(array[index]);
        }
        int secondMax = -1;
        for (int pop = 0; pop < 2; pop++) {
            secondMax = integers.poll();
        }
        return secondMax;
    }
}
