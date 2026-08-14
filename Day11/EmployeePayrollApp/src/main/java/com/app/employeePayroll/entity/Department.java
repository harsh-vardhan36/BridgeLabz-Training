package com.app.employeePayroll.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "department")
public class Department {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true)
private String depName;
private String description;

@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
private List<Employee> employees;

public List<Employee> getEmployees(){
	return employees;
}
public Department() {
	
}

public Long getId() {
	return id;
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

public Department(String depName, String description) {
	this.depName = depName;
	this.description = description;
}
}
