package com.inheritance.restaturantManagement;

public class Waiter extends Person implements Worker {

    private int tableCount;

    public Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter Duties:");
        System.out.println("Name: " + name);
        System.out.println("Tables Assigned: " + tableCount);
        System.out.println("Serving food and assisting customers.");
    }
}