package com.org.jucstuddy251214.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 过渡同步，用atomicInteger或者synchronized就可以了，不需要用两个
 */
public class VolatileCalculatorBugFixDemo {

    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                count.getAndIncrement();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        synchronized (AtomicInteger.class) {
            t1.start();
            t2.start();
        }

        t1.join();
        t2.join();

        System.out.println("最终结果：" + count);
    }

}
