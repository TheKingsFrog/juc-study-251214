package com.org.jucstuddy251214.thread;

/**
 * 输出不是固定的，CPU在调度线程
 */
public class ThreadDemo {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程1：" + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程2：" + i);
            }
        });

        thread1.start();
        thread2.start();

    }

}
