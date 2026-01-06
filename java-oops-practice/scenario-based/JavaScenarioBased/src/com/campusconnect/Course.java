package com.campusconnect;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private Faculty faculty;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String courseName, Faculty faculty) {
        this.courseName = courseName;
        this.faculty = faculty;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void printCourseDetails() {
        System.out.println("Course: " + courseName);
        faculty.printDetails();
        System.out.println("Enrolled Students: " + students.size());
    }
}

