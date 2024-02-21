package io.ravi.multithreading.producerconsumer.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final BlockingQueue<Integer> blockingQueue;
    private Random random = new Random();
    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                int number = random.nextInt(100);
                //System.out.println("Produced: "+number +" and queue size: "+blockingQueue.size());
                blockingQueue.put(number);
                //TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
