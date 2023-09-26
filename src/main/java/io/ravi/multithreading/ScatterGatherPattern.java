package io.ravi.multithreading;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

class ScatterGatherPatternWithThreadSleep {

    static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        System.out.println(getPrices());
        threadPool.shutdown();
    }

    private static Set<Integer> getPrices(){
        Set<Integer> result = Collections.synchronizedSet(new HashSet<>());
        threadPool.submit(new Task("amazon","1",result));
        threadPool.submit(new Task("ebay","2",result));
        threadPool.submit(new Task("flipkart","3",result));
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    static class Task implements Runnable {

        private String url;
        private String productId;
        private Set<Integer> result;

        public Task(String url,String productId,Set<Integer> result){
            this.url = url;
            this.productId = productId;
            this.result = result;
        }

        @Override
        public void run() {

            result.add(url.length());

        }
    }

}

class ScatterGatherPatternWithCountDownLatch {

    static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        System.out.println(getPrices());
        threadPool.shutdown();
    }

    private static Set<Integer> getPrices(){
        Set<Integer> result = Collections.synchronizedSet(new HashSet<>());
        CountDownLatch latch = new CountDownLatch(3); // 3 - Number of threads
        threadPool.submit(new Task("amazon","1",result,latch));
        threadPool.submit(new Task("ebay","2",result,latch));
        threadPool.submit(new Task("flipkart","3",result,latch));

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    static class Task implements Runnable {

        private String url;
        private String productId;
        private Set<Integer> result;
        private CountDownLatch latch;

        public Task(String url,String productId,Set<Integer> result, CountDownLatch latch){
            this.url = url;
            this.productId = productId;
            this.result = result;
            this.latch = latch;
        }

        @Override
        public void run() {

            result.add(url.length());
            latch.countDown(); // Reduce latch details

        }
    }
}

class ScatterGatherPatternWithCompletableFeature {

    static ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        System.out.println(getPrices());
        threadPool.shutdown();
    }

    private static Set<Integer> getPrices(){
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task("amazon","1",prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task("ebay","2",prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task("flipkart","3",prices));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1,task2,task3);
        try {
            allTasks.get(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
        } catch (ExecutionException e) {
            //throw new RuntimeException(e);
        } catch (TimeoutException e) {
           // throw new RuntimeException(e);
        }

        return prices;
    }

    static class Task implements Runnable {

        private String url;
        private String productId;
        private Set<Integer> result;


        public Task(String url,String productId,Set<Integer> result){
            this.url = url;
            this.productId = productId;
            this.result = result;

        }

        @Override
        public void run() {
            if("2".equalsIgnoreCase(productId)){
                try {
                    Thread.sleep(4 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            result.add(url.length());


        }
    }

}


/**
 * We can achieve same with
 * 1.Futures/Callables
 * 2.Conditions & locks
 * 3.Phaser
 * */




