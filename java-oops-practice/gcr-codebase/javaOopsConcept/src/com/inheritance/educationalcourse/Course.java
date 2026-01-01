package com.inheritance.educationalcourse;

public class Course {

    protected String courseName;
    protected int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}
