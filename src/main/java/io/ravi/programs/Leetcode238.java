package io.ravi.programs;

public class Leetcode238 {

    public static void main(String[] args) {
        selfProduct(new int[]{1,2,3,4,5});
    }
    public static int[] selfProduct(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        left[0]=1;
        for(int i = 1 ;i<n;i++){
            left[i] = left[i-1] * arr[i-1];
        }
        //System.out.println(Arrays.toString(left));
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] * arr[i+1];
        }
        //System.out.println(Arrays.toString(right));

        int[] result = new int[n];
        for (int i = 0;i<n;i++){
            result[i] = left[i] * right[i];
        }
        // System.out.println(Arrays.toString(result));
        return result;
    }

}
