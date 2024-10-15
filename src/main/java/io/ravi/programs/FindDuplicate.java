package io.ravi.programs;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    private static boolean isDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int element : arr) {
            if (set.contains(element)) {
                return true;
            }else {
                set.add(element);
            }
        }
        return false;
    }
}