package com.org.jucstuddy251214.volatiledemo;

/**
 *  这里有个问题：
 *  主线程修改running = false后，子线程感知不到，会导致这种情况：
 *  线程启动
 *  主线程修改 running = false
 *  （程序卡住，线程不结束）
 */
public class VolatileDemo {

    private static boolean running = true;

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
