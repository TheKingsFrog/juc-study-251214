package com.org.jucstuddy251214.volatiledemo;

/**
 * 这个计数器最后算出来的count <= 20000
 * 因为 count++ 这个过程  包括 读+加+写，但这三步不是原子操作
 * volatile 适合场景：状态标志、开关量、配置刷新
 * volatile 不适合场景：计数、金额、库存
 * join：强制当前的线程等待另一个线程完成后再继续执行，确保线程的执行顺序
 * t1.join会阻塞当前线程（main线程）执行，也就是不会执行t2.join，直到t1执行完毕。
 */
public class VolatileCalculatorDemo {

    private static volatile int count = 0;

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                count++;
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
