package io.ravi.exercise;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerAndTimerTask {

    public static void main(String[] args) {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer task executed: "+System.currentTimeMillis());
            }
        };

       // timer.scheduleAtFixedRate(task, 2, 5000);
        timer.schedule(task, 2, 5000);
        System.out.println("End...");

    }
}


class ScheduledExecutorServiceEx{
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = () -> {
            System.out.println("Task executed: " + System.currentTimeMillis());
        };

        // Schedule task to run every 2 seconds with an initial delay of 1 second
        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // Optional: Shut down the scheduler gracefully after 10 seconds
        scheduler.schedule(() -> scheduler.shutdown(), 10, TimeUnit.SECONDS);
    }
}
