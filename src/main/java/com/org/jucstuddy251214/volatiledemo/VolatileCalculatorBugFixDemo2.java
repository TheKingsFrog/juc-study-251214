package com.org.jucstuddy251214.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  AtomicInteger 线程安全
 *  适用场景：简单计数
 */
public class VolatileCalculatorBugFixDemo2 {

    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                count.getAndIncrement();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最终结果：" + count);
    }

}
