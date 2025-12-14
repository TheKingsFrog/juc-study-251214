package com.org.jucstuddy251214.thread;

public class TicketWithSynchronizedDemo {

    private static Integer ticket = 100;

    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        Runnable task = () -> {
            while (true) {

                synchronized (LOCK) {
                    if (ticket <= 0) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出一张，剩余：" + --ticket);
                }

            }
        };
        new Thread(task, "窗口1").start();
        new Thread(task, "窗口2").start();
        new Thread(task, "窗口3").start();


    }

}
