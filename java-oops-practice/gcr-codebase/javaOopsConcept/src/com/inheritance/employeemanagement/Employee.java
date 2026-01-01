package com.inheritance.employeemanagement;

public class Employee {
	String name;
	int age;
	int salary;
	
	Employee(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	void displaydetails() {
		System.out.println("Name : " + name + " age : " + age + " salary : " + salary);
	}
}