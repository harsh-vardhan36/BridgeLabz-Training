package com.app.employeePayroll.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.app.employeePayroll.entity.Employee;
import com.app.employeePayroll.mapper.EmployeeRowMapper;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;
    private final EmployeeRowMapper rowMapper;

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate, EmployeeRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public Employee save(Employee employee) {

        String sql = "INSERT INTO employees (emp_name, department, salary) VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, employee.getEmpName());
            ps.setString(2, employee.getDepartment());
            ps.setDouble(3, employee.getSalary());
            return ps;
        }, keyHolder);

        employee.setId(keyHolder.getKey().longValue());
        return employee;
    }

    @Override
    public Employee findById(Long id) {

        String sql = "SELECT id, emp_name, department, salary FROM employees WHERE id = ?";

        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, id);

        return employees.isEmpty() ? null : employees.get(0);
    }

    @Override
    public List<Employee> findAll() {

        String sql = "SELECT id, emp_name, department, salary FROM employees ORDER BY id";

        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public int update(Long id, Employee employee) {

        String sql = """
                UPDATE employees
                SET emp_name = ?, department = ?, salary = ?
                WHERE id = ?
                """;

        return jdbcTemplate.update(
                sql,
                employee.getEmpName(),
                employee.getDepartment(),
                employee.getSalary(),
                id
        );
    }

    @Override
    public int deleteById(Long id) {

        return jdbcTemplate.update(
                "DELETE FROM employees WHERE id = ?",
                id
        );
    }
}
