package com.skillforge;

import java.util.HashMap;

public class Student extends User {
    private HashMap<Course, Integer> progress = new HashMap<>();
    private HashMap<Course, Integer> grades = new HashMap<>();

    public Student(String name, String email) {
        super(name, email);
    }

    public void enroll(Course course) {
        progress.put(course, 0);
        grades.put(course, 0);
        System.out.println(name + " enrolled in " + course.getTitle());
    }

    public void updateProgress(Course course, int completedModules) {
        int total = course.getTotalModules();
        int percent = (completedModules * 100) / total;
        progress.put(course, percent);
    }

    public void setGrade(Course course, int grade) {
        grades.put(course, grade);
    }

    public int getProgress(Course course) {
        return progress.get(course);
    }

    public int getGrade(Course course) {
        return grades.get(course);
    }
}
