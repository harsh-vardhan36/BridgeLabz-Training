package com.app.employeePayroll.entity;

public class Employee {

    private Long id;
    private String empName;
    private String department;
    private double salary;

    public Employee() {
    }

    public Employee(Long id, String empName, String department, double salary) {
        this.id = id;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String empName, String department, double salary) {
        this.empName = empName;
        this.department = department;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
