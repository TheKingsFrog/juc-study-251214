package com.org.jucstuddy251214.thread;

public class TicketLockDemo {

    private static Integer ticket = 100;

    public static void main(String[] args) {
        Runnable task = () -> {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出一张，剩余：" + --ticket);
            }
        };

        new Thread(task, "窗口1").start();
        new Thread(task, "窗口2").start();
        new Thread(task, "窗口3").start();

    }

}
