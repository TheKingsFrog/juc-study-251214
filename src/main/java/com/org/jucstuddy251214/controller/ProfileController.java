package com.org.jucstuddy251214.controller;

import com.org.jucstuddy251214.dto.Order;
import com.org.jucstuddy251214.dto.ProfileDto;
import com.org.jucstuddy251214.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
public class ProfileController {

    private final Executor bizExecutor;

    public ProfileController(Executor bizExecutor) {
        this.bizExecutor = bizExecutor;
    }

    @GetMapping("/profile")
    public ProfileDto profile() throws Exception {

        long start = System.currentTimeMillis();

        CompletableFuture<User> userF =
                CompletableFuture.supplyAsync(this::loadUser, bizExecutor);

        CompletableFuture<Order> orderF =
                CompletableFuture.supplyAsync(this::loadOrder, bizExecutor);

        ProfileDto result = userF.thenCombine(orderF, ProfileDto::new).get();

        long cost = System.currentTimeMillis() - start;
        System.out.println("并发耗时：" + cost + " ms");

        return result;
    }

    @GetMapping("/profile/serial")
    public ProfileDto profileSerial() {
        long start = System.currentTimeMillis();

        User user = loadUser();
        Order order = loadOrder();

        long cost = System.currentTimeMillis() - start;
        System.out.println("串行耗时：" + cost + " ms");

        return new ProfileDto(user, order);
    }

    private User loadUser() {
        sleep(800); // 模拟 RPC / DB
        return new User("u1", "张三");
    }

    private Order loadOrder() {
        sleep(800); // 模拟 RPC / DB
        return new Order("o1", "iPhone");
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}