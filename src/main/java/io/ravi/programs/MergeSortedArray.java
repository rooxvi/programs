package io.ravi.programs;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{4,0,0,0,0,0},1,new int[]{1,2,3,5,6},5);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int k = m+n-1;
        int i = m-1;
        int j = n-1;

        while(i >= 0 && j >= 0){
            if(nums1[i]>=nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (i>=0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }

        while (j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
