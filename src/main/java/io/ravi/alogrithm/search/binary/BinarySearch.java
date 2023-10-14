package io.ravi.alogrithm.search.binary;

class BinarySearch {

  public static void main(String args[]) {
    int[] array = {1,2,4,5,7,9};
    int ans = binarySearch(array, 0, array.length - 1, 7);
    System.out.println(ans);
  }

  private static int binarySearch(int[] arr,int low, int high, int k){
    if(low <= high){
      int midIndex = low + (high-low)/2;
      if(arr[midIndex] == k)
        return midIndex;
      if(arr[midIndex] > k)
        return binarySearch(arr,low,midIndex-1,k); // return statement is important
      return binarySearch(arr,midIndex+1,high,k); // return statement is important
    }
    return -1;
  }

  //Response with status: 500 OK for URL: https://api.digiverifier.com/v1.0/candidate/getToken?invitationToken=0fa52bb173418e4d9f7d20bc263a683b4d678ca325c946d376f07cb80f84f2a1&otpResendFlag=true


}