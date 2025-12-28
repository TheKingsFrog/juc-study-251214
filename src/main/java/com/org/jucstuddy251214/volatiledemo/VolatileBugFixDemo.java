package com.org.jucstuddy251214.volatiledemo;

/**
 * 加了volatile以后，子线程就能感知到running被修改了，这是volatile的特性——可见性
 * volatile特性：可见性、禁止指令重排序
 * 不保证原子性、不代表线程安全
 */
public class VolatileBugFixDemo {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("线程启动");

            while (running) {
                // do nothing
            }

            System.out.println("线程结束");

        });

        thread.start();

        Thread.sleep(1000);

        running = false;

        System.out.println("主线程修改 running = false");

    }
}
