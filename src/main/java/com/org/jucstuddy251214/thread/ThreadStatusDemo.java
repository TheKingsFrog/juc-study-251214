package com.org.jucstuddy251214.thread;

/**
 * Q：为什么sleep(4000)后状态会TERMINATED？
 */
public class ThreadStatusDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        });

        // NEW
        System.out.println(t.getState());
        t.start();

        // RUNNABLE
        System.out.println(t.getState());

        // TIMED_WAITING
        Thread.sleep(100);
        System.out.println(t.getState());

        // TERMINATED
        Thread.sleep(4000);
        System.out.println(t.getState());

    }

}
