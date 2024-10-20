package io.ravi.multithreading.printinsequence;

public class OrderedSequencePrinter {
    private final int maxLimit;
    private int currentNumber = 1;  // Start with 1
    private int currentThread = 1;  // Track the current thread (1, 2, or 3)
    private final Object lock = new Object();  // Lock object for synchronization

    public OrderedSequencePrinter(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void printNumber(int threadId) {
        while (true) {
            synchronized (lock) {

                // Stop if the current number exceeds the max limit
                if (currentNumber > maxLimit) {
                    lock.notifyAll();  // Wake up all waiting threads to exit
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " acquired the lock...");
                // Check if it is this thread's turn to print
                if (currentThread != threadId) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " released the lock...");
                        lock.wait();  // Wait until it's this thread's turn
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Thread-" + threadId + " interrupted.");
                        break;
                    }
                } else {
                    // Print the current number and move to the next thread
                    //System.out.println("Thread-" + threadId + " prints: " + currentNumber++);
                    System.out.println(Thread.currentThread().getName() + " prints: " + currentNumber++);
                    currentThread = (currentThread % 3) + 1;  // Cycle through threads 1, 2, 3
                    lock.notifyAll();  // Notify other threads
                }
                System.out.println(Thread.currentThread().getName() + " exited...");
            }
        }
    }

    public static void main(String[] args) {
        OrderedSequencePrinter printer = new OrderedSequencePrinter(10);  // Set max limit to 10

        // Create and start 3 threads
        Thread t1 = new Thread(() -> printer.printNumber(1));
        Thread t2 = new Thread(() -> printer.printNumber(2));
        Thread t3 = new Thread(() -> printer.printNumber(3));

        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads stopped gracefully.");
    }
}
