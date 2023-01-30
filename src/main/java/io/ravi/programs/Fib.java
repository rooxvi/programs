package io.ravi.programs;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    static Map<Double,Double> bag = new HashMap<>();
    static Double value = 0d;
    public static void main(String[] args) {
        System.out.println(fibonacci(150d));
    }

    public static Double fibonacci(Double n, Double[] arr){
        if(n == 0d || n == 1d){
            return n;
        }

        if(bag.containsKey(n)){
            return bag.get(n);
        }else {
            value = fibonacci(n-1)+fibonacci(n-2);
            bag.put(n,value);
        }
        return value;
        // return fibonacci(n-1)+fibonacci(n-2);
    }

    public static Double fibonacci(Double n){
        if(n == 0 || n == 1){
            return n;
        }

        if(bag.containsKey(n)){
            return bag.get(n);
        }else {
            value = fibonacci(n-1)+fibonacci(n-2);
            bag.put(n,value);
        }
        return value;
        // return fibonacci(n-1)+fibonacci(n-2);
    }
}
