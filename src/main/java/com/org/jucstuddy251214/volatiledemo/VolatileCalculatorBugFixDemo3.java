package com.org.jucstuddy251214.volatiledemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  synchronized 把count++锁住
 *  适用场景：复杂逻辑
 */
public class VolatileCalculatorBugFixDemo3 {

    private static int count = 0;

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                countAdd();
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

    public static synchronized void countAdd() {
        count++;
    }

}
