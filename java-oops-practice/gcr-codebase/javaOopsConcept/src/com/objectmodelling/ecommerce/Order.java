package com.objectmodelling.ecommerce;

import java.util.ArrayList;
import java.util.List;

//Order class
public class Order {
 private int orderId;
 private Customer customer;
 private List<Product> products;

 public Order(int orderId, Customer customer) {
     this.orderId = orderId;
     this.customer = customer;
     this.products = new ArrayList<>();
 }

 public void addProduct(Product product) {
     products.add(product);
 }

 public void showOrderDetails() {
     System.out.println("Order ID: " + orderId);
     System.out.println("Customer: " + customer.getName());
     System.out.println("Products in this order:");
     for (Product p : products) {
         System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")");
     }
 }
}