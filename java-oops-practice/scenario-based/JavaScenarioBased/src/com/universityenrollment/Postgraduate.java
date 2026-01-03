package com.universityenrollment;

class Postgraduate extends Student {

    public Postgraduate(int id, String name, double gpa) {
        super(id, name, gpa);
    }

    @Override
    public String getLevel() {
        return "Postgraduate";
    }
}