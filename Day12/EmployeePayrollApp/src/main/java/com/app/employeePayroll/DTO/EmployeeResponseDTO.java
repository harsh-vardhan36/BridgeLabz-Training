package com.app.employeePayroll.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class EmployeeResponseDTO {
	
	@Schema(description = "Employee ID")
	private Long empId;
	@Schema(description = "Employee Name")
	private String empName;
	@Schema(description = "Employee's Department Name")
	private String departmentName;
	@Schema(description = "Employee Salary")
	private double salary;
	
	public EmployeeResponseDTO(Long empId, String empName, String departmentName, double salary) {
		
		this.empId = empId;
		this.empName = empName;
		this.departmentName = departmentName;
		this.salary = salary;
	}
	
	
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
