package io.ravi.multithreading.printinsequence;

import java.util.concurrent.TimeUnit;

public class PrintInSequence {

    public static void main(String[] args) {
        PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
        PrintSequenceRunnable runnable2=new PrintSequenceRunnable(0);

        Thread t1=new Thread(runnable1,"T1");
        Thread t2=new Thread(runnable2,"T2");

        t1.start();
        t2.start();

    }


    public static class PrintSequenceRunnable implements Runnable {

        private int printMaxLimit = 10;
        static int number = 1;
        int reminder;
        static Object lock = new Object();

        public PrintSequenceRunnable(int reminder) {
            this.reminder = reminder;
        }

        @Override
        public void run() {
            while (number < printMaxLimit) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + "entered...");
                    while (number % 2 != reminder) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println(Thread.currentThread().getName()+" "+number);
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
    }
}
