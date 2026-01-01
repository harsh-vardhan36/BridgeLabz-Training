package com.inheritance.onlineretailManagement;

public class RetailMain {
	public static void main(String[] args) {

        Order order = new Order(101, "01-01-2025");
        ShippedOrder shipped = new ShippedOrder(102, "02-01-2025", "TRK123");
        DeliveredOrder delivered = new DeliveredOrder(
                103, "03-01-2025", "TRK456", "05-01-2025");

        System.out.println(order.getOrderStatus());
        System.out.println(shipped.getOrderStatus());
        System.out.println(delivered.getOrderStatus());
    }
}
