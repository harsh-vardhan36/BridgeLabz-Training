package com.universityenrollment;

abstract class Student {

    private int studentId;
    private String name;
    private double gpa;
    private char grade;
    private boolean enrolled;

    protected Student(int studentId, String name, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    // Enrollment controlled internally
    public void markEnrolled() {
        this.enrolled = true;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    // GPA update hidden
    protected void updateGpa(double score) {
        gpa = (gpa + score) / 2;
    }

    protected void setGrade(char grade) {
        this.grade = grade;
    }

    // Academic transcript (real-life output)
    public void printTranscript() {
        System.out.println(getLevel());
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("GPA        : " + gpa);
        System.out.println("Grade      : " + grade);
    }

    public abstract String getLevel();
}