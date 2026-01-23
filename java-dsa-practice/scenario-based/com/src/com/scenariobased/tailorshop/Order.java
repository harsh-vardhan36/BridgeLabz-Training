package com.scenariobased.tailorshop;

public class Order {
    String orderId;
    int deadlineDay; // number of days from today

    public Order(String orderId, int deadlineDay) {
        this.orderId = orderId;
        this.deadlineDay = deadlineDay;
    }
}
