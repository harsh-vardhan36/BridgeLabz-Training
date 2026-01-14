package com.ecowing;
class Eagle extends Bird implements Flyable {
    public Eagle(String id, String name) {
        super(id, name, "Eagle");
    }

    public void fly() {
        System.out.println("Eagle soars high in the sky.");
    }
}
