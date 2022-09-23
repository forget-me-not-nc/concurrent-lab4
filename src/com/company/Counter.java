package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * lab4.Counter
 *
 * @Author: Palijchuk Nazar
 * @DateTime: 23.09.2022|20:39
 * @Version Counter: 1.0
 */

class Counter {
    private int c = 0;

    private final Lock lock = new ReentrantLock();

    public void increment() throws InterruptedException {
        try {
            if(lock.tryLock(10, TimeUnit.SECONDS)) {
                Thread.sleep(1500);
                int a;
                a = c;
                a++;
                c = a;

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
          lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        try {
            if(lock.tryLock(10, TimeUnit.SECONDS)) {
                Thread.sleep(1000);

                int a;
                a = c;
                a--;
                c = a;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int value() {
        return c;
    }
}