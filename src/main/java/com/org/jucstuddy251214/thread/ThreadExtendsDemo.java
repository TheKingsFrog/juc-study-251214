package com.org.jucstuddy251214.thread;

/**
 * 不推荐这种方式创建线程，因为Java是单继承，而且任务(Runnable)和线程耦合
 */
public class ThreadExtendsDemo extends Thread {


    @Override
    public void run() {
        System.out.println("ThreadExtendsDemo.run:" + getName());
    }

    public static void main(String[] args) {
        new ThreadExtendsDemo().start();
    }

}
