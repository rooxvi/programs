package io.ravi.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) {

        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            long result = 10 / 0; // Causes an ArithmeticException
            return result;
        });

        future.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return 1l; // Default value to return if there's an exception
        }).thenAccept(result -> {
            System.out.println("Result: " + result);
        });
    }
}