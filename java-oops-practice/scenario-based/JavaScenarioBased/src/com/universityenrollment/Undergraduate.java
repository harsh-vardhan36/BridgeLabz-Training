package com.universityenrollment;

class Undergraduate extends Student {

    public Undergraduate(int id, String name, double gpa) {
        super(id, name, gpa);
    }

    @Override
    public String getLevel() {
        return "Undergraduate";
    }
}