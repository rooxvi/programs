package io.ravi.multithreading.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("All bikers reached common point");
            }
        });

        Thread thread1 = new Thread(new Biker("Biker1",cyclicBarrier,13000));
        Thread thread2 = new Thread(new Biker("Biker2",cyclicBarrier,6000));
        Thread thread3 = new Thread(new Biker("Biker3",cyclicBarrier,9000));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
