package com.constructor.levelOne.employee;

public class EmployeeMain {
	public static void main(String[] args) {
        Employee employee = new Employee(1001, "IT", 75000.0);
        System.out.println("Employee Salary: " + employee.getSalary());

        Manager manager = new Manager(2001, "HR", 90000.0);
        manager.displayManagerDetails();
    }
}
