package com.universityenrollment;

class Enrollment {

    public void enroll(Student student, Course course) {
        System.out.println(student.getLevel() +
                " enrolled in " + course.getCourseInfo());
    }
}