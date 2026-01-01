package com.inheritance.employeemanagement;

public class Intern extends Employee{

	Intern(String name, int age, int salary) {
		super(name, age, salary);
		// TODO Auto-generated constructor stub
	}
	String workyype;
	
	void displaydetails() {
		System.out.println("Name : " + name + " age : " + age + " salary : " + salary);
	}

}