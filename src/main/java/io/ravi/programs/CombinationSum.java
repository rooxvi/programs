package io.ravi.programs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        // combinationSum(new int[]{2,3,5,6,7},new LinkedList<>(),0,0,7);
        // var result =  combinationSum(new int[]{2,3,5,6,7}, new LinkedList<>(), 0, 0, 7,new LinkedList<>());
        // List<Integer> d = new ArrayList<>();
        // System.out.println(result);
        /*LinkedList<Integer> m = new LinkedList<>();
        m.add(10);
        m.add(1);
        m.add(2);
        m.add(7);
        m.add(6);
        m.add(1);
        m.add(5);
        System.out.println(m);
        Collections.sort(m);
        System.out.println(m);
        System.out.println(combination(m,m.size(),0,8,0,new LinkedList<>(),new LinkedList<>()));
   */
        LinkedList<Integer> m = new LinkedList<>();
        m.add(3);
        m.add(5);
        m.add(6);
        m.add(7);
        m.add(8);
        for(var e:subsetsWithDup(5,m))
         System.out.println(e);
    }

    public static void combinationSum(int[] arr, List<Integer> bag, int index, int sum, int target){
        if(index == arr.length || sum > target){
            return;
        }
        if (sum == target){
            System.out.println("bag: "+bag);
            return;
        }
        bag.add(arr[index]);
        combinationSum(arr,bag,index,sum+arr[index],target);
        bag.remove(bag.size()-1);
        combinationSum(arr,bag,index+1,sum,target);
    }

    private static List<List<Integer>> combinationSum(int[] arr, List<Integer> bag, int index, int sum, int target,List<List<Integer>> result){
        if (sum == target){
            result.add(new LinkedList<>(bag));
            return result;
        }
        if(index == arr.length || sum > target){
            return result;
        }
        bag.add(arr[index]);
        combinationSum(arr,bag,index,sum+arr[index],target,result);
        bag.remove(bag.size()-1);
        combinationSum(arr,bag,index+1,sum,target,result);
        return result;
    }

    static List<List<Integer>> combination(List<Integer> m,int n,int i,int t,int s,List<Integer> bag,List<List<Integer>> r){
        if(s == t){
            r.add(new LinkedList(bag));
            return r;
        }
        if(i == n || s > t){
            return r;
        }

        bag.add(m.get(i));
        combination(m,n,i+1,t,s+m.get(i),bag,r);
        bag.remove(bag.size()-1);
        while(i < n-1 && m.get(i) == m.get(i+1)){
            i++;
        }
        combination(m,n,i+1,t,s,bag,r);
        return r;
    }

    public static List<List<Integer>> subsetsWithDup(int n, List<Integer> matrix) {
        Collections.sort(matrix);
        return subsetsWithDup(n, matrix,new LinkedList<>(),new LinkedList<>(),0);

    }
    private static List<List<Integer>> subsetsWithDup(int n, List<Integer> matrix,List<Integer> bag,List<List<Integer>> result,int index){
        if(index == n){
            result.add(new LinkedList<>(bag));
            return result;
        }
        while((index -1 > 0) && matrix.get(index-1) == matrix.get(index)){
            index++;
        }
        bag.add(matrix.get(index));
        subsetsWithDup(n, matrix,bag,result,index+1);
        bag.remove(bag.size()-1);
        subsetsWithDup(n, matrix,bag,result,index+1);
        return result;
    }
}
