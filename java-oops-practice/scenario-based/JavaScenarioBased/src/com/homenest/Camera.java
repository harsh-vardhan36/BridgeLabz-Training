package com.homenest;

class Camera extends Device {
    public Camera(String id) {
        super(id, 5.0);
    }

    public void turnOn() {
        setStatus(true);
        System.out.println("Camera recording");
    }

    public void turnOff() {
        setStatus(false);
        System.out.println("Camera stopped");
    }

    public void reset() {
        System.out.println("Camera lens recalibrated");
    }
}
