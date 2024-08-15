package io.ravi.multithreading.completionservice;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SleepingCallable implements Callable<String> {

    private final String name;
    private final int period;

    public SleepingCallable(String name, int period) {
        this.name = name;
        this.period = period;
    }



    @Override
    public String call() throws Exception {
        System.out.println("Sleeping "+name+" for " + period + " seconds");
        TimeUnit.SECONDS.sleep(period);
        return name;
    }
}
