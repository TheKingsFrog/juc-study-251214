package com.org.jucstuddy251214.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadConfig {

    @Bean("bizExecutor")
    public Executor bizExecutor() {

        return new ThreadPoolExecutor(
                8,
                16,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(500),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("biz-exec" + thread.getId());
                    thread.setDaemon(false);
                    return thread;
                },
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

    }

}
