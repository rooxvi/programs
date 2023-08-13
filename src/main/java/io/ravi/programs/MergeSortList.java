package io.ravi.programs;

import java.util.LinkedList;
import java.util.List;

public class MergeSortList {

    public static void main(String[] args) {
       // System.out.println(sort(8, List.of(345, 72,33, 3, 5, 4,0,-1 )));
    }

    public static List<Integer> sort(int n, List<Integer> arr) {
        if (n <= 1) {
            return arr;
        }
        int mid = n / 2;
        List<Integer> r = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < mid; i++) {
            l.add(arr.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.add(arr.get(i));
        }
        List<Integer> left = sort(mid, l);
        List<Integer> right =  sort(n - mid, r);
        return merge(left, right);
    }

    public static List<Integer> merge(List<Integer> l, List<Integer> r) {
        List<Integer> result = new LinkedList<>();
        int i = 0;
        int j = 0;

        while (i < r.size() && j < l.size()) {
            if (r.get(i) <= l.get(j)) {
                result.add(r.get(i));
                i++;
            } else {
                result.add(l.get(j));
                j++;
            }
        }

        while (i < r.size()) {
            result.add(r.get(i));
            i++;
        }


        while (j < l.size()) {
            result.add(l.get(j));
            j++;
        }

        return result;
    }

}
