package com.constructor.levelOne.studentUniversity;

public class StudentMain {
	public static void main(String[] args) {
	    Student s1 = new Student(101, "Muskan", 8.5);
        s1.displayStudent();

       System.out.println();
        System.out.println("Updated CGPA:");
        s1.setCgpa(9.1);
        System.out.println(s1.getCgpa());

        System.out.println("\nPostgraduate Student:");
        PostGraduateStudent pg = new PostGraduateStudent(201, "Amit", 8.9, "Computer Science");
        pg.displayPGStudent();
	}
}
