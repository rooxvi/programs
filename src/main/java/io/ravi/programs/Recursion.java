package io.ravi.programs;

public class Recursion {
    public static void main(String[] args) {
      printNum(0);
    }

    private static void printNum(int i){
        if(i==20){
            return;
        }

        System.out.print(i+" ");
        printNum(++i);
    }
}
