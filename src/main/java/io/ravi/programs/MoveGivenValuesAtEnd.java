package io.ravi.programs;

import java.util.Arrays;

public class MoveGivenValuesAtEnd {

    public static void main(String[] args) {
        int[] array = new int[]{3,3,2,3,4,3,6,3,10,18,3,4,3,1,0};
        int x[] = {0,1,3,0,0,4,0,66,0,2,3,0,66,0};
        //System.out.println(Arrays.toString(moveDuplicateValues(array)));
        //System.out.println(Arrays.toString(moveDuplicateValues(x,0)));
        moveKOneSide(array,3);
        System.out.println(Arrays.toString(array));

    }

    private static int[] moveDuplicateValues(int[] array){
        int start = 0;
        int end = 0;

        while (end < array.length){
            if(array[end] != 3){
                int temp =  array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
            }
            end++;
        }
        return array;
    }

    private static int[] moveDuplicateValues(int[] array,int k){
        int start = 0;
        int end = 0;

        while (end < array.length){
            if(array[end] != k){
                int temp =  array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
            }
            end++;
        }
        return array;
    }

    private static void moveKOneSide(int[] numbers, int k) {
        int left = 0;
        int right= 0;

        while (left< numbers.length-1 && right < numbers.length-1) {
            while ( left < numbers.length && numbers[left] != k) {
                left++;
            }

            right = left;

            while ( right < numbers.length && numbers[right] == k) {
                right++;
            }

            int temp = numbers[right];
            numbers[left] = temp;
            numbers[right] = k;
            left++;
        }
    }
}
