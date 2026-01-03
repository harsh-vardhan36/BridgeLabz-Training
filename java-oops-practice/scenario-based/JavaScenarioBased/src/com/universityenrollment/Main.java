package com.universityenrollment;

class Main {

    public static void main(String[] args) {

        Student ug = new Undergraduate(101, "Sonu Sharma", 7.5);
        Student pg = new Postgraduate(102, "Mighty Raju", 4.0);

        Course course = new Course("AL701", "Computer Vision");

        Enrollment enrollment = new Enrollment();
        Faculty faculty = new Faculty("Dr. Balwant Raghuvanshi");

        enrollment.enroll(ug, course);
        faculty.evaluateStudent(ug, 8.5);
        ug.printTranscript();

        System.out.println();

        enrollment.enroll(pg, course);
        faculty.evaluateStudent(pg, 9.0);
        pg.printTranscript();
    }
}