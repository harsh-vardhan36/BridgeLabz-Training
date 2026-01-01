package com.inheritance.restaturantManagement;

public class Chef extends Person implements Worker {

    private String specialization;

    public Chef(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef Duties:");
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Cooking and preparing dishes.");
    }
}