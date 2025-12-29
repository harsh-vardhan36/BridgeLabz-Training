package com.constructor.levelOne.studentUniversity;

public class Student {
	public int rollNumber;
	protected String name;
	private double cgpa;
	
	public Student(int rollNumber , String name, double cgpa) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	public void setCgpa(double num) {
		if (cgpa >= 0 && cgpa <= 10) {
            this.cgpa = cgpa;
        } else {
            System.out.println("Invalid CGPA");
        }
    }
	public double getCgpa() {
		return cgpa;
	}
	
	  public void displayStudent() {
	        System.out.println("Roll Number: " + rollNumber);
	        System.out.println("Name: " + name);
	        System.out.println("CGPA: " + cgpa);
	    }
	
}
