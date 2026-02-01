package com.org.jucstuddy251214.dto;

public class Order {
    private String orderId;
    private String product;

    public Order(String orderId, String product) {
        this.orderId = orderId;
        this.product = product;
    }

    // getter / setter 省略
}