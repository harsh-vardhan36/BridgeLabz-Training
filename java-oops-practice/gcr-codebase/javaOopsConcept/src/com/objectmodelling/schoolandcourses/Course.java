package com.objectmodelling.schoolandcourses;

import java.util.ArrayList;
import java.util.List;

// Course class
public class Course {
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    // Add student to course
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Show enrolled students
    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " | Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }
}



