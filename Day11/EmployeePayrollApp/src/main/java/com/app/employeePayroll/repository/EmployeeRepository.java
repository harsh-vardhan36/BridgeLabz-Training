package com.app.employeePayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.employeePayroll.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//  Find employees with salary greater than a value
    List<Employee> findBySalaryGreaterThan(Double salary);

    //  Find employees with salary between two values
    List<Employee> findBySalaryBetween(Double min, Double max);
}
