package com.objectmodelling.ecommerce;

import java.util.ArrayList;
import java.util.List;

//Customer class
class Customer {
 private String name;
 private List<Order> orders;

 public Customer(String name) {
     this.name = name;
     this.orders = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void placeOrder(Order order) {
     orders.add(order);
     System.out.println(name + " placed an order with ID " + order.orderId);
 }

 public List<Order> getOrders() {
     return orders;
 }
}
