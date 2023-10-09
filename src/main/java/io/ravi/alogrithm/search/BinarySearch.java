package io.ravi.alogrithm.search;

class BinarySearch {

  private static int binarySearch(int[] arr,int low, int high, int k){
    if(low <= high){
      int midIndex = low + (high-low)/2;
      if(arr[midIndex] == k)
        return midIndex;
      if(arr[midIndex] > k)
        return binarySearch(arr,low,midIndex-1,k);
      return binarySearch(arr,midIndex+1,high,k);
    }
    return -1;
  }

  public static void main(String args[]) {
    BinarySearch ob = new BinarySearch();
    int arr[] = {13, 45, 65, 16, 117, 82, 19};
    int n = arr.length;
    int item = 45;
    int ans = ob.binarySearch(arr, item, 0, n - 1);
    if (ans == -1)
      System.out.println("Element not present");
    else
      System.out.println("answer: "+ans);
  }
}