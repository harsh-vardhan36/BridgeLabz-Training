package com.skillforge;

public class Instructor extends User {

    public Instructor(String name, String email) {
        super(name, email);
    }

    public Course createCourse(String title) {
        return new Course(title, this.name);
    }
}
