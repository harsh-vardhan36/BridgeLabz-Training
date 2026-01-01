package com.inheritance.employeemanagement;

public class Manager extends Employee{

	Manager(String name, int age, int salary) {
		super(name, age, salary);
	}
	int teamsize;
	
	void displaydetails() {
		System.out.println("Name : " + name + " age : " + age + " salary : " + salary);
	}

}