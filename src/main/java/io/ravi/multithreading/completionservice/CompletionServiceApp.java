package io.ravi.multithreading.completionservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletionServiceApp {
    public static void main(String[] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        final CompletionService<String> service = new ExecutorCompletionService<String>(pool);
        final List<? extends Callable<String>> callables = Arrays.asList(
                new SleepingCallable("slow", 5000),
                new SleepingCallable("quick", 500));
        for (final Callable<String> callable : callables) {
            service.submit(callable);
        }
        pool.shutdown();
        try {
            Future<String> future;
            do {
                future = pool.isTerminated() ? service.poll() : service.take();
                if (future != null) {
                    System.out.println(future.get());
                }
            } while (future != null);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
