package io.ravi.programs;

import java.util.LinkedList;
import java.util.List;

public class Subsequence {

    static int count = 0;
    static List<List<Integer>> b = new LinkedList<>();

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -5};
        int target = 15;
        //subSequence(array,new LinkedList<>(),0);
        subSequence1(array, new LinkedList<>(), 0, target, 0);

    }

    public static void subSequence(int[] arr, List<Integer> bag, int index) {
        if (index == arr.length) {
            System.out.println(bag);
            return;
        }
        bag.add(arr[index]);
        subSequence(arr, bag, index + 1);
        //System.out.println("Bag size : "+bag.size());
        bag.remove(bag.size() - 1);
        subSequence(arr, bag, index + 1);
    }

    public static void subSequence(int[] arr, List<Integer> bag, int index, int target) {
        if (index == arr.length) {
            int sum = 0;
            for (int j = 0; j < bag.size(); j++) {
                sum += bag.get(j);
            }
            if (sum == target) {
                System.out.println(bag + " ");
            }
            System.out.print(count++ + " ");
            return;
        }
        bag.add(arr[index]);
        subSequence(arr, bag, index + 1, target);
        bag.remove(bag.size() - 1);
        subSequence(arr, bag, index + 1, target);
    }

    public static void subSequence(int[] arr, List<Integer> bag, int index, int target, int sum) {
        if (index == arr.length) {
            if (sum == target) {
                System.out.println(bag + " ");
            }
            return;
        }
        bag.add(arr[index]);
        subSequence(arr, bag, index + 1, target, sum + arr[index]);
        bag.remove(bag.size() - 1);
        subSequence(arr, bag, index + 1, target, sum);
    }

    public static boolean subSequence1(int[] arr, List<Integer> bag, int index, int target, int sum) {
        if (index == arr.length) {
            if (sum == target) {
                System.out.println(bag + " ");
                return true;
            }
            System.out.println(count++ + " ");
            return false;
        }
        bag.add(arr[index]);
        if(subSequence1(arr, bag, index + 1, target, sum + arr[index]) == true){
           return true;
        }
        bag.remove(bag.size() - 1);
        return subSequence1(arr, bag, index + 1, target, sum);
    }


    /* public static void subSequenceUsingArray(int[] arr, int[] bag, int index,String flag){
        //System.out.println(index+" "+Arrays.toString(arr)+" "+Arrays.toString(bag));
        if(index == arr.length){
            System.out.println( flag+" >>> "+Arrays.toString(bag));
            return;
        }
        bag[index] = arr[index];
        subSequenceUsingArray(arr,bag,index+1,"I");
        bag[index] = 0;
        subSequenceUsingArray(arr,bag,index+1,"E");
    } */

/*
    public static void subSequenceUsingArray(int[] arr, int[] bag, int index,String flag){
        //System.out.println(index+" "+Arrays.toString(arr)+" "+Arrays.toString(bag));
        if(index == arr.length){
            System.out.println( flag+" >>> "+Arrays.toString(bag));
            return;
        }
        bag[index] = arr[index];
        subSequenceUsingArray(arr,bag,index+1,"I");
        bag[index] = 0;
        subSequenceUsingArray(arr,bag,index+1,"E");
    }

*/
}

/*
[1, 2, 3]
[1, 2, -1]
[1, -1, 3]
[1, -1, -1]
[-1, 2, 3]
[-1, 2, -1]
[-1, -1, 3]
[-1, -1, -1]
 */