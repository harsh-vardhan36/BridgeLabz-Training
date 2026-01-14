package com.ecowing;
class Penguin extends Bird implements Swimmable {
    public Penguin(String id, String name) {
        super(id, name, "Penguin");
    }

    public void swim() {
        System.out.println("Penguin swims underwater.");
    }
}
