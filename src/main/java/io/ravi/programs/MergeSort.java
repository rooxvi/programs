package io.ravi.programs;

public class MergeSort {

    public static void main(String[] args) {

    }

    public int[] sort(int[] elements){
      return elements;
    }

    public void mergeSort(int[] elements){
        int n = elements.length;
        if(n>2)
            return;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for(int i=0;i<mid;i++){

        }
    }
    public static int[] merge(int[] elements,int[] l,int[] r){
        int[] result = new int[l.length+r.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l.length && j < r.length){
            if(l[i]<=r[j]){
                result[k++] = l[i++];
            }else {
                result[k++] = r[j++];
            }
        }

        while (i<l.length){
            result[k++] = l[i++];
        }

        while (j<r.length){
            result[k++] = r[j++];
        }
        return result;
    }
}
