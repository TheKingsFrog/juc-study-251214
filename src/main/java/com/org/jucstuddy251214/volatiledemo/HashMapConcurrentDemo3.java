package com.org.jucstuddy251214.volatiledemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * computeIfAbsent与putIfAbsent区别
 * putIfAbsent会调用value方法多次
 * computeIfAbsent只会调用一次
 */
public class HashMapConcurrentDemo3 {

    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            String value = map.putIfAbsent("k", load());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map.size());

    }

    private static String load() {
        System.out.println(Thread.currentThread().getName() + " load");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return "v";
    }

}
