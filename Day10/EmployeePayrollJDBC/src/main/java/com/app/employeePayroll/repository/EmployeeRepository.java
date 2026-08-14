package com.app.employeePayroll.repository;

import java.util.List;
import com.app.employeePayroll.entity.Employee;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    int update(Long id, Employee employee);

    int deleteById(Long id);
}
