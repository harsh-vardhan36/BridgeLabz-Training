package com.constructor.levelOne.studentUniversity;

public class PostGrduateStudent extends Student{
	String degree;

    public PostGraduateStudent(int rollNumber, String name, double CGPA, String degree) {
        super(rollNumber, name, CGPA);
        this.degree = degree;
    }
    public void displayPGStudent() {
        System.out.println("Roll Number: " + rollNumber);   // public
        System.out.println("Name: " + name);                // protected
        System.out.println("Degree :" + degree);
        System.out.println("CGPA: " + getCgpa());           // private via getter
    }	
}
