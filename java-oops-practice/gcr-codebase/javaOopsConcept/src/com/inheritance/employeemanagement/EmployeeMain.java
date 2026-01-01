package com.inheritance.employeemanagement;

public class EmployeeMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee("ABC",18,2500);
		
		Manager mng = new Manager("Priyanshu",21,5000);
		
		Developer dvp = new Developer("Sid",45,4100);
		
		Intern inr  = new Intern("DJ",23,5600);
		
		emp.displaydetails();
		mng.displaydetails();
		dvp.displaydetails();
		inr.displaydetails();
		
	}
}
