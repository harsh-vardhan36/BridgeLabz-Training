package com.app.employeePayroll.DTO;

public class EmployeeResponseDTO {
	
	public EmployeeResponseDTO(Long empId, String empName, String departmentName, double salary) {
		
		this.empId = empId;
		this.empName = empName;
		this.departmentName = departmentName;
		this.salary = salary;
	}

	private Long empId;
	private String empName;
	private String departmentName;
	private double salary;
	
	
	public Long getEmpId() {
		return empId;
	}

	

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public double getSalary() {
		return salary;
	}

	
}
