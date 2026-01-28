package com.csv;

public class Students {

    int id;
    String name;
    int age;
    int marks;
    String grade;

    public Students(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setMarksAndGrade(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + age + ", " + marks + ", " + grade;
    }
}
