package com.campusconnect;

import java.util.ArrayList;

public class Student extends Person implements ICourseActions {
    private ArrayList<Course> courses = new ArrayList<>();
    private double grade1;
    private double grade2;
    private double grade3;

    public Student(String name, String email, int id) {
        super(name, email, id);
    }

    public void setGrades(double g1, double g2, double g3) {
        grade1 = g1;
        grade2 = g2;
        grade3 = g3;
    }

    public double calculateGPA() {
        return (grade1 + grade2 + grade3) / 3;
    }

    @Override
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    @Override
    public void dropCourse(Course course) {
        courses.remove(course);
        course.removeStudent(this);
    }

    @Override
    public void printDetails() {
        System.out.println("Student: " + name + " | GPA: " + calculateGPA());
    }
}
