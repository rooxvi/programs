package io.ravi.multithreading.printinsequence;

public class PrintSequenceRunnableNThread implements Runnable {

    private static Object lock = new Object();
    private final int totalThreads;
    private static volatile int sequence = 1;
    private final int reminder;
    private static int flow = 0;
    private final int maxLimit;

    public PrintSequenceRunnableNThread(int totalThreads, int threadSequence, int maxLimit) {
        this.totalThreads = totalThreads;
        this.reminder = threadSequence % totalThreads;
        this.maxLimit = maxLimit;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (sequence > maxLimit) {
                    lock.notifyAll();
                    break;
                }

                if (sequence % totalThreads != reminder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    //System.out.println((flow++) + "." + Thread.currentThread().getName() + " " + sequence);
                    System.out.println(Thread.currentThread().getName() + " " + sequence);
                    sequence++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int totalThreads = 3;
        Thread[] threads = new Thread[totalThreads];
        for (int i = 1; i <= totalThreads; i++) {
            threads[i - 1] = new Thread(new PrintSequenceRunnableNThread(totalThreads, i, 50), "T" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All executed successfully.......");
    }
}
