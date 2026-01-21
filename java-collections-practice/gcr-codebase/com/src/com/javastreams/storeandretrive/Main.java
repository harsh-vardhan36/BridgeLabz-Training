package com.javastreams.storeandretrive;

public class Main {

    public static void main(String[] args) {

        String fileName = "student.dat";

        Student student =
                new Student(101, "Harsh", 8.7);

        StudentDataUtil.writeStudent(student, fileName);
        StudentDataUtil.readStudent(fileName);
    }
}
