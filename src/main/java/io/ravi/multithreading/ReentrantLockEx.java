package io.ravi.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionMet = lock.newCondition();

    private void accessResource(){
        lock.lock();
        lock.lock();
        try {

        }finally {
            lock.unlock();
            lock.unlock();
        }
    }


}
