package com.app.employeePayroll.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentResponseDTO {
	@Schema(description = "Department Id.")
	private Long id;
	@Schema(description = "Department Name")
	private String depName;
	
	private String description;
	
	public DepartmentResponseDTO() {
		
	}
	public DepartmentResponseDTO(Long id, String depName, String description) {
		this.id = id;
		this.depName = depName;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
