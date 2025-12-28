package com.org.jucstuddy251214.volatiledemo;

import java.util.concurrent.atomic.LongAdder;

/**
 *  LongAdder为什么比AtomicInteger更快？
 *  因为LongAdder具有窗口机制，在高并发下可以拆分变量，减少冲突
 *  AtomicInteger在高并发场景下容易CAS冲突
 *  性能对比：单线程/低并发、频繁读下AtomicInteger占优，高并发写场景下LongAdder占优
 */
public class VolatileCalculatorBugFixDemo4 {

    private static final LongAdder count = new LongAdder();

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                count.increment();
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
