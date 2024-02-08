package io.ravi.multithreading.producerconsumer;

class ShowRoom {
    int value;
    boolean pro_thread = true;

    synchronized void produce(int i) {
        if (pro_thread == true) {
            value = i;
            System.out.println("Producer has produced Product " + value);
            pro_thread = false;
            notify();
        }
        try {
            wait();
        } catch (InterruptedException ie) {
        }
    }

    synchronized int consume() {
        if (pro_thread == true) {
            try {
                wait();
            } catch (InterruptedException ie) {
            }
        }
        pro_thread = true;
        notify();
        return value;
    }
}

class Producer implements Runnable {
    ShowRoom sr;

    Producer(ShowRoom sr) {
        this.sr = sr;
    }

    public void run() {
        int i = 1;
        for (i = 1; i <= 10; i++) {
            sr.produce(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
        }
    }
}

class Consumer implements Runnable {
    ShowRoom sr;

    Consumer(ShowRoom sr) {
        this.sr = sr;
    }

    public void run() {
        while (true) {
            int res = sr.consume();
            System.out.println("Consumer has taken product " + res);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        ShowRoom sr = new ShowRoom();
        Producer p = new Producer(sr);
        Consumer c = new Consumer(sr);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}