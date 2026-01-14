package com.scenariobased.smartcheckoutsystem;

import java.util.*;

public class SmartCheckout {
    private Queue<Customer> queue = new LinkedList<>();
    private Map<String, Item> inventory = new HashMap<>();

   
    public void addItem(String name, double price, int stock) {
        inventory.put(name, new Item(name, price, stock));
    }

   
    public void addCustomer(Customer customer) {
        queue.add(customer);
        System.out.println(customer.getName() + " joined the queue.");
    }

    
    private void removeCustomer() {
        Customer customer = queue.poll();
        if (customer != null) {
            System.out.println(customer.getName() + " has been served.");
        }
    }

    
    public void processCheckout() {
        Customer customer = queue.peek();
        if (customer == null) {
            System.out.println("No customers in queue.");
            return;
        }

        double totalBill = 0;
        System.out.println("Processing checkout for " + customer.getName());

        for (String itemName : customer.getItems()) {
            Item item = inventory.get(itemName);
            if (item != null && item.getStock() > 0) {
                totalBill += item.getPrice();
                item.reduceStock();
                System.out.println(itemName + " purchased for ₹" + item.getPrice());
            } else {
                System.out.println(itemName + " is out of stock!");
            }
        }

        System.out.println("Total Bill for " + customer.getName() + ": ₹" + totalBill);
        removeCustomer();
    }
}
