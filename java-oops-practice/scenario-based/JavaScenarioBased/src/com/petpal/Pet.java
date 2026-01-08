package com.petpal;

import java.util.Random;

abstract class Pet implements IInteractable {
    protected String name;
    protected String type;
    protected int age;

    private int hunger;
    private int energy;
    private int mood;

    public Pet(String name, String type) {
        Random r = new Random();
        this.name = name;
        this.type = type;
        this.age = r.nextInt(10) + 1;
        this.hunger = r.nextInt(40);
        this.energy = r.nextInt(40) + 60;
        this.mood = r.nextInt(40) + 60;
    }

    protected void increaseEnergy(int v) { energy = Math.min(100, energy + v); }
    protected void decreaseEnergy(int v) { energy = Math.max(0, energy - v); }
    protected void decreaseHunger(int v) { hunger = Math.max(0, hunger - v); }
    protected void increaseMood(int v) { mood = Math.min(100, mood + v); }

    public void showStatus() {
        System.out.println("\n--- PET STATUS ---");
        System.out.println("Name   : " + name);
        System.out.println("Type   : " + type);
        System.out.println("Age    : " + age);
        System.out.println("Hunger : " + hunger);
        System.out.println("Energy : " + energy);
        System.out.println("Mood   : " + mood);
    }

    abstract void makeSound();
}
