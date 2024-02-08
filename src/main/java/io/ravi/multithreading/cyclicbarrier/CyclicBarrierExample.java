package io.ravi.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All bikers reached common point");
            }
        });

        Thread thread1 = new Thread(new Biker("Biker1",cyclicBarrier,3000));
        Thread thread2 = new Thread(new Biker("Biker2",cyclicBarrier,6000));
        Thread thread3 = new Thread(new Biker("Biker3",cyclicBarrier,9000));

        thread1.start();
        thread2.start();
        thread3.start();

    }

    static class Biker implements Runnable{
        String name;
        CyclicBarrier cyclicBarrier;
        int travelTime;

        public Biker(String name, CyclicBarrier cyclicBarrier, int travelTime) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
            this.travelTime = travelTime;
        }

        @Override
        public void run() {
            System.out.println(name+" started from this place");
            try{
                Thread.sleep(travelTime);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(name+" reached common point and waiting for others to join...");

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }finally {
                System.out.println("Reached finally...");
            }

            System.out.println(name+" continues his journey");
        }
    }
}