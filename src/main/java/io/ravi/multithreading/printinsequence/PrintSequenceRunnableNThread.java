package io.ravi.multithreading.printinsequence;

public class PrintSequenceRunnableNThread implements Runnable {

    private static Object lock = new Object();

    private final int totalThreads;

    private static volatile int sequence = 1;

    private final int reminder;

    private static int flow = 0;

    public PrintSequenceRunnableNThread(int totalThreads, int threadSequence) {
        this.totalThreads = totalThreads;
        this.reminder = threadSequence % totalThreads;
    }

    @Override
    public void run() {
        while (sequence < 99) {
        synchronized (lock) {
            //System.out.println((flow++) + "." + Thread.currentThread().getName() + " acquired...");

                while (sequence % totalThreads != reminder) {
                    //System.out.println((flow++) + "." + Thread.currentThread().getName() + " waiting...");
                    try {
                        lock.wait();
                        //System.out.println((flow++) + "." + Thread.currentThread().getName() + " woke up..");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println((flow++) + "." + Thread.currentThread().getName() + " " + sequence);

                sequence++;
                lock.notifyAll();
               /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                //System.out.println((flow++) + "." + Thread.currentThread().getName() + " " + "notified others....");
            }
        }
    }

    public static void main(String[] args) {
  /*      int totalThreads = 3;
        PrintSequenceRunnableNThread thread = new PrintSequenceRunnableNThread(totalThreads,1);
        PrintSequenceRunnableNThread thread1 = new PrintSequenceRunnableNThread(totalThreads,2);
        PrintSequenceRunnableNThread thread2 = new PrintSequenceRunnableNThread(totalThreads,3);

        new Thread(thread).start();
        new Thread(thread1).start();
        new Thread(thread2).start();*/

        int totalThreads = 3;
        for (int i = 1; i <= totalThreads; i++) {
            new Thread(new PrintSequenceRunnableNThread(totalThreads, i), "T" + i).start();
        }
    }
}
