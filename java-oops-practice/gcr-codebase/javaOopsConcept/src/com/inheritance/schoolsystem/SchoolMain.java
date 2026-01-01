package com.inheritance.schoolsystem;

public class SchoolMain {
 
	public static void main(String[] args) {

        Teacher teacher = new Teacher("Alok", 40, "Mathematics");
        Student student = new Student("Somya", 16, "History");
        Staff staff = new Staff("Raghav", 35, "Administration");

        teacher.displayRole();
        System.out.println();

        student.displayRole();
        System.out.println();

        staff.displayRole();
    }
}
