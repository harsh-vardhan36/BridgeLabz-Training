package com.multithreading.restaurantorder;

public class RestaurantManager {

    public static void main(String[] args) {

        System.out.println("Kitchen opened... Orders started \n");

        // 4 Chef Threads
        Chef chef1 = new Chef("Chef-1", "Pizza", 3000);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2000);
        Chef chef3 = new Chef("Chef-3", "Salad", 1000);
        Chef chef4 = new Chef("Chef-4", "Burger", 2500);

        // Start Cooking
        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        // Manager waits for all chefs
        try {
            chef1.join();
            chef2.join();
            chef3.join();
            chef4.join();
        } catch (InterruptedException e) {
            System.out.println("Manager interrupted!");
        }

        // Closing Kitchen
        System.out.println("\nKitchen closed - All orders completed ");
    }
}
