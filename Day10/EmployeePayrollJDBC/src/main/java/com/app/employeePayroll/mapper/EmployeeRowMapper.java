package com.app.employeePayroll.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.app.employeePayroll.entity.Employee;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();

        employee.setId(rs.getLong("id"));
        employee.setEmpName(rs.getString("emp_name"));
        employee.setDepartment(rs.getString("department"));
        employee.setSalary(rs.getDouble("salary"));

        return employee;
    }
}
