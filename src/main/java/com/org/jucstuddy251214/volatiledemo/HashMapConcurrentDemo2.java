package com.org.jucstuddy251214.volatiledemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 换成ConcurrentHashMap后，结果恒等于10000了
 */
public class HashMapConcurrentDemo2 {

    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                if (!map.containsKey(i)) {
                    map.put(i, i);
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map.size());

    }

}
