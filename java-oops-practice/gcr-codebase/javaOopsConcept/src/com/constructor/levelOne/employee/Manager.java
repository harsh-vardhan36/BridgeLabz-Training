package com.constructor.levelOne.employee;

public class Manager extends Employee{
	public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Manager Employee ID: " + employeeID); // public member
        System.out.println("Manager Department: " + department); // protected member
        System.out.println("Manager Salary: " + getSalary()); // private member via public method
    }
}
