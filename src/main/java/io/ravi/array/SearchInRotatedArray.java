package io.ravi.array;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] array = {4, 5, 7, 1, 3};
        System.out.println(search(array, 0, array.length - 1, 3));
    }

    private static int search(int[] array, int low, int high, int k) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == k) return mid;
            if(array[low] <=  array[mid]){
                if(array[low] <= k && array[mid] <= k)
                  return search(array,low,mid-1,k);
                return search(array,mid-1,high,k);
            }else {
                if (array[mid] <= k && array[high] <= k)
                    return search(array,low,mid-1,k);
                return search(array,mid+1,high,k);
            }
        }
        return -1;
    }
}
