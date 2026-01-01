package com.inheritance.restaturantManagement;

public class RestaurantMain {
	public static void main(String[] args) {

        Worker chef = new Chef("Amit", 101, "Indian Cuisine");
        Worker waiter = new Waiter("Rohit", 202, 6);

        chef.performDuties();
        System.out.println();

        waiter.performDuties();
    }
}
