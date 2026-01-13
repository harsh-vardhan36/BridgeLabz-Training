package com.homenest;

class Light extends Device {
    public Light(String id) {
        super(id, 2.0);
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Light ON");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Light OFF");
    }

    public void reset() {
        System.out.println("Light brightness reset");
    }
}
