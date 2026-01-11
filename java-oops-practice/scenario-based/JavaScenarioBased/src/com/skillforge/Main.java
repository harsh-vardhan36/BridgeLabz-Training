package com.skillforge;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Instructor inst = new Instructor("Harsh", "harsh@skillforge.com");

        Course java = inst.createCourse("Java Mastery");

        Student s = new Student("Aman", "aman@mail.com");
        s.enroll(java);

        s.updateProgress(java, 3);
        s.setGrade(java, 90);

        java.addReview(5);
        java.addReview(4);

        System.out.println("Course Rating: " + java.getRating());

        java.generateCertificate(s);
    }
}
