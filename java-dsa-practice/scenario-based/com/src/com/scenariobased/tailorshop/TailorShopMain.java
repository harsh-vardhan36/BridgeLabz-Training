package com.scenariobased.tailorshop;

public class TailorShopMain {

    public static void main(String[] args) {

        Order[] orders = {
            new Order("ORD101", 2),
            new Order("ORD102", 4),
            new Order("ORD103", 6),
            new Order("ORD104", 5) 
        };

        InsertionSortUtil.insertionSort(orders);

        System.out.println("Order Delivery Schedule:");
        for (Order o : orders) {
            System.out.println(o.orderId + " -> Deliver in " + o.deadlineDay + " days");
        }
    }
}
