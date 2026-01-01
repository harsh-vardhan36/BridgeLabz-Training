package com.inheritance.employeemanagement;

public class Developer extends Employee{

	Developer(String name, int age, int salary) {
		super(name, age, salary);
		// TODO Auto-generated constructor stub
	}
	String programminglanguage;
	
	void displaydetails() {
		System.out.println("Name : " + name + " age : " + age + " salary : " + salary);
	}

}