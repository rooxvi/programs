package io.ravi.sony;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        final int[] original = new int[]{1, 1, 2, 8, 9, 8, 4, 7, 4, 9, 1, 1000, 1000};
        System.out.println(Arrays.toString(original));
        final int[] buckets = new int[1001];
        for (final int i : original) {
            buckets[i]++;
        }
        System.out.println(Arrays.toString(buckets));
        final int[] unique = new int[original.length];
        int count = 0;
        for (int i = 0; i < buckets.length; ++i) {
            if (buckets[i] > 0) {
                unique[count++] = i;
            }
        }
        final int[] compressed = new int[count];
        System.arraycopy(unique, 0, compressed, 0, count);
        System.out.println(Arrays.toString(compressed));
    }
}
