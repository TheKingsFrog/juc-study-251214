package com.org.jucstuddy251214.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable + Future
 * get()会阻塞
 * Callable适合有返回结果的任务
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 50;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);

        new Thread(futureTask).start();

        System.out.println("结果：" + futureTask.get());

    }

}
