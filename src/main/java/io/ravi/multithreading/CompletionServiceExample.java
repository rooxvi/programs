package io.ravi.multithreading;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.concurrent.*;

public class CompletionServiceExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        
        // Submit tasks for execution
        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            completionService.submit(() -> {
                // Simulate a long-running task
                Thread.sleep(5000);
                return taskNumber;
            });
        }
        
        // Retrieve results in the order they are completed
   /*     for (int i = 0; i < 10; i++) {
            Future<Integer> future = completionService.take();
            System.out.println("Task " + future.get() + " completed.");
        }*/

        for (int i = 0; i < 10; i++) {
            Optional<Future<Integer>> future = Optional.ofNullable(completionService.poll());
            if (future.isPresent()) {
                System.out.println("Task " + future.get() + " completed.");
            }

        }

        Optional<Integer> result;

        do {
            Future<Integer> future = completionService.poll();
            if (future != null) {
                result = Optional.of(future.get());
            }else {
                result = Optional.empty();
            }
           // Optional<> future = Optional.ofNullable(completionService.poll());
            System.out.println("Task " + result + " completed.");
        }while (result.isPresent());

        executor.shutdown();
    }
}