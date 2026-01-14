package com.ecowing;
class Duck extends Bird implements Flyable, Swimmable {
    public Duck(String id, String name) {
        super(id, name, "Duck");
    }

    public void fly() {
        System.out.println("Duck flies short distances.");
    }

    public void swim() {
        System.out.println("Duck swims gracefully.");
    }
}
