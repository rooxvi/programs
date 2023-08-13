package io.ravi.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new TaskOne());
        executorService.execute(new TaskTwo());
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.execute(new TaskOne());
        executorService1.execute(new TaskTwo());

        executorService1.shutdown();
    }
}

class TaskOne extends Thread{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.print(i+" ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class TaskTwo implements Runnable{

    @Override
    public void run() {
        for(int i=21;i<=40;i++){
            System.out.print(i+" ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}