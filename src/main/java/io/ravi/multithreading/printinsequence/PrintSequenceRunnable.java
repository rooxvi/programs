package io.ravi.multithreading.printinsequence;

import java.util.concurrent.TimeUnit;

public class PrintSequenceRunnable implements Runnable {
    static Object lock = new Object();
    static int number = 1;
    int remainder;

    public PrintSequenceRunnable(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                while (number % 3 != remainder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                }
                System.out.println(Thread.currentThread().getName() + " : " + number);
                // This use to print value in console slowly
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                number++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintSequenceRunnable r1 = new PrintSequenceRunnable(1);
        PrintSequenceRunnable r2 = new PrintSequenceRunnable(2);
        PrintSequenceRunnable r3 = new PrintSequenceRunnable(0);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();
    }
}
