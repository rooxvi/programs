package io.ravi.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Biker implements Runnable{
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
