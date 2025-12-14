package com.org.jucstuddy251214.thread;

/**
 * run()不会创建线程，start()才会创建新线程
 */
public class ThreadDemo2 {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName());
        });

        t.run();
        t.start();

    }

}
