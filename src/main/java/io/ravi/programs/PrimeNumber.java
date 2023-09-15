package io.ravi.programs;

import java.util.LinkedList;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) {

        List<Integer> primeNumbers = generatePrimeNumber(100);

        primeNumbers.stream().forEach(
           n -> System.out.print(n+" ")
        );
    }
    private static List<Integer> generatePrimeNumber(int n){
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i= 0;i<=n;i++){
            if(isPrime(i)){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    private static boolean isPrime(int number) {
        if (number <= 1)
            return false;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
            return true;
        }

}
