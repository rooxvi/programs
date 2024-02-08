package io.ravi.multithreading.oddeven;

import java.util.concurrent.TimeUnit;

@Deprecated
public class PrintOddEvenNumberByTwoThreads {
    public static void main(String[] args) {
        PrintSequence printSequence = new PrintSequence();
        Thread odd = new Thread(new OddNumber(printSequence));
        Thread even = new Thread(new EvenNumber(printSequence));
        odd.start();
        even.start();
    }
}

class EvenNumber implements Runnable {
    PrintSequence printSequence;

    public EvenNumber(PrintSequence printSequence) {
        this.printSequence = printSequence;
    }

    @Override
    public void run() {
        while (true) {
            if (printSequence.isEven) {
                printSequence.printEven();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class OddNumber implements Runnable {
    PrintSequence printSequence;

    public OddNumber(PrintSequence printSequence) {
        this.printSequence = printSequence;
    }

    @Override
    public void run() {
        while (true) {
            if (!printSequence.isEven) {
                printSequence.printOdd();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class PrintSequence {

    private int seq = 0;
    boolean isEven = false;

    public synchronized void printOdd() {
        if (!isEven) {
            seq++;
            System.out.println(Thread.currentThread().getName() + " " + seq);
            isEven = true;
            notify();
        }
        try {
            wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void printEven() {
        if (isEven) {
            seq++;
            System.out.println(Thread.currentThread().getName() + " " + seq);
            isEven = false;
            notify();
        }
        try {
            wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}