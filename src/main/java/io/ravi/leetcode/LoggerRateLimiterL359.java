package io.ravi.leetcode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoggerRateLimiterL359 {

    private static Map<String,LocalDateTime> bucket = new HashMap<>();

    public static void main(String[] args) {
        printMessage("Hello");
        printMessage("Hello");
       /* try {
            TimeUnit.SECONDS.sleep(11);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        printMessage("Hello");
        printMessage("Hello");
        printMessage("Hello1");
    }


    private static void printMessage(String message){
        if (shouldPrintMessage(LocalDateTime.now(),message)){
            System.out.println(message);
        }
    }

    private static boolean shouldPrintMessage(LocalDateTime dateTime,String message){
        if(!bucket.containsKey(message)){
            bucket.put(message,dateTime);
            return true;
        }

        if (dateTime.getSecond()-bucket.get(message).getSecond() >= 10){
            bucket.replace(message,dateTime);
            return true;
        }

        return false;
    }
}
