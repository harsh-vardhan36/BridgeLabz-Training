package com.homenest;

class Lock extends Device {
    public Lock(String id) {
        super(id, 1.0);
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Door Locked");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Door Unlocked");
    }

    public void reset() {
        System.out.println("Lock security reset");
    }
}
