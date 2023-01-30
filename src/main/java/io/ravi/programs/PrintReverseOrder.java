package io.ravi.programs;

public class PrintReverseOrder {

    public static void main(String[] args) {
        printReverseOrder(5);
    }

    public static void printReverseOrder(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printReverseOrder(n-1);
    }

    public static void printReverseOrder1(int n){
      if(n>5)
          return;
      printReverseOrder1(n+1);
      System.out.println(n);
    }
}
