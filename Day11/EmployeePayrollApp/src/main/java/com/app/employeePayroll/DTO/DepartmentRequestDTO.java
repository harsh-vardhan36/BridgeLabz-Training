package com.app.employeePayroll.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DepartmentRequestDTO {
	@NotBlank(message = "Department Name must not be empty")
	@Column(unique = true )
private String depName;
private String description;

public DepartmentRequestDTO(){
	
}
public DepartmentRequestDTO(String depName, String description) {
	this.depName = depName;
	this.description = description;
}
public String getDepName() {
	return depName;
}
public void setDepName(String depName) {
	this.depName = depName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
	
}
