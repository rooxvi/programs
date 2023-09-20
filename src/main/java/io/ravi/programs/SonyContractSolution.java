package io.ravi.programs;/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named SonyContractSolution.
 *
 * If you need more classes, simply define them inline.
 */

 /*
Given an array of temperature for each day of the week, find the largest drop of temperature between in the array. 

| Mon | Tues | Wed | Thurs | Fri | Sat | Sun |
|-----+------+-----+-------+-----+-----+-----|
| 76  | 72   | 80  | 78    | 68  | 72  | 82  |


Input: int[] temps = {76, 72, 80, 78, 68, 72, 82};
Expected output: 12 (80 - 68)

*/

class SonyContractSolution {
  public static void main(String[] args) {
    ///int[] temps = {76, 72, 80, 78, 68, 72, 82};
    int[] temps = {76, 76,76,76};
     System.out.println(findHighDiffValue(temps));
  }

  private static int findHighDiffValue(int[] array){
    int runningMaxValue = 0;
    int i=0;
    int j=1;
    while(i <array.length-1){
      if(array[i]>array[j]){
         runningMaxValue = Math.max(runningMaxValue,(array[i]-array[j]));
      }else{
        i = j;
      }
      j++;
    }
    return runningMaxValue;
  }

}