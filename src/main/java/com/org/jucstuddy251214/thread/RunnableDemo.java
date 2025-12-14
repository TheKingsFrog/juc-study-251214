package com.org.jucstuddy251214.thread;

public class RunnableDemo {

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Runnable:" + Thread.currentThread().getName());
        };

        new Thread(task).start();
        new Thread(task).start();

    }

}
