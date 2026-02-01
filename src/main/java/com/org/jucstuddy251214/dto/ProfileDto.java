package com.org.jucstuddy251214.dto;

public class ProfileDto {

    private User user;
    private Order order;

    public ProfileDto(User user, Order order) {
        this.user = user;
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }
}