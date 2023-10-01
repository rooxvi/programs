package io.ravi.programs;

public class SecondLargestNumberInArray {
    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6};
        System.out.println(findSecondLargestNumberInArray(array));

    }

    // Note: Not completed
    private static int findSecondLargestNumberInArray(int[] array){
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int start = 0;

        while (start < array.length){
          if(firstMax < array[start]){
              firstMax = array[start];
          }

          if(secondMax < firstMax){
             if (  secondMax < array[start]){
                 secondMax = array[start];
             }
          }
            start++;
        }
        return secondMax;
    }
}
