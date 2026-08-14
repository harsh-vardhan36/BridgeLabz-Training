package com.app.employeePayroll.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EmployeeRequestDTO {
	
	@NotBlank(message ="Please provide the Employee Name." )
	private String empName;
	@Positive(message = "Salary must be greater than 0")
	private double salary;
	@NotNull(message = "Department Id is required!")
	private Long department_id;
	public String getEmpName() {
		return empName;
	}
	public EmployeeRequestDTO(@NotBlank(message = "Please provide the Employee Name.") String empName,
			@Positive(message = "Salary must be greater than 0") double salary,
			@NotNull(message = "Department Id is required!") Long department_id) {
		this.empName = empName;
		this.salary = salary;
		this.department_id = department_id;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
