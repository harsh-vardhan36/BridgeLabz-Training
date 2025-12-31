package com.objectmodelling.ecommerce;

//Main class to test
public class EcommmerceMain {
 public static void main(String[] args) {
     // Create products
     Product p1 = new Product("Laptop", 1200.00);
     Product p2 = new Product("Smartphone", 800.00);
     Product p3 = new Product("Headphones", 150.00);

     // Create customer
     Customer c1 = new Customer("Alice");

     // Create order
     Order o1 = new Order(101, c1);
     o1.addProduct(p1);
     o1.addProduct(p3);

     // Customer places order
     c1.placeOrder(o1);

     // Show order details
     o1.showOrderDetails();
 }
}
