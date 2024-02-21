package io.ravi.multithreading.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
     while (true){
         try {
             System.out.println(Thread.currentThread().getName()+" : "+blockingQueue.take());
             TimeUnit.SECONDS.sleep(3);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }
    }
}
