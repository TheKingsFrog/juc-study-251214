package com.org.jucstuddy251214.volatiledemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 即使判断了map是否存在，还是会存在线程不安全问题
 */
public class HashMapConcurrentDemo {

    private static Map<Integer, Integer> map = new HashMap<>();

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
