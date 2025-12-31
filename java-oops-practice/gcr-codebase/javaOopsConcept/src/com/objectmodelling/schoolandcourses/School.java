package com.objectmodelling.schoolandcourses;

import java.util.ArrayList;
import java.util.List;

// School class (Aggregation: School HAS Students)
public class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("School: " + schoolName + " | Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}
