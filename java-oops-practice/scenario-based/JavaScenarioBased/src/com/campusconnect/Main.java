package com.campusconnect;

public class Main {
    public static void main(String[] args) {

        Faculty f1 = new Faculty("Dr. Sharma", "sharma@uni.edu", 101);
        Course java = new Course("Java Programming", f1);

        Student s1 = new Student("Harsh", "harsh@uni.edu", 1);
        s1.setGrades(8.5, 9.0, 8.0);

        s1.enrollCourse(java);

        s1.printDetails();
        f1.printDetails();
        java.printCourseDetails();
    }
}
