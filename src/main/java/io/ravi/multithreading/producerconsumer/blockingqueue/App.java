package io.ravi.multithreading.producerconsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(new Producer(blockingQueue));
        Thread consumer = new Thread(new Consumer(blockingQueue));
        consumer.setName("Consumer 1");
        Thread consumer1 = new Thread(new Consumer(blockingQueue));
        consumer1.setName("Consumer 2");

        producer.start();
        consumer.start();
        consumer1.start();
    }
}
