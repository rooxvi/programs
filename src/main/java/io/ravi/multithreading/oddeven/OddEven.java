package io.ravi.multithreading.oddeven;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class OddEven implements Runnable{

    private static int sequence = 1;
    private int threadValue;
    private static Object lock = new Object();

    public OddEven(int threadValue){
        this.threadValue = threadValue;
    }
    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                while (sequence % 2 != threadValue) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(Thread.currentThread().getName() + " " + sequence);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sequence++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        OddEven odd = new OddEven(1);
        OddEven even = new OddEven(0);

        Thread oddThread = new Thread(odd);
        oddThread.setName("Odd ");
        Thread evenThread = new Thread(even);
        evenThread.setName("Even ");

        oddThread.start();
        evenThread.start();
    }
}
