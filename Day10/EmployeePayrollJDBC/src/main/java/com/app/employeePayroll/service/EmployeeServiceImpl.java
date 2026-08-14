package com.app.employeePayroll.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.employeePayroll.dto.EmployeeRequestDTO;
import com.app.employeePayroll.dto.EmployeeResponseDTO;
import com.app.employeePayroll.entity.Employee;
import com.app.employeePayroll.exception.EmployeeNotFoundException;
import com.app.employeePayroll.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {

        Employee employee = new Employee(
                dto.getEmpName(),
                dto.getDepartment(),
                dto.getSalary()
        );

        return convertToResponse(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponseDTO findEmployeeById(Long id) {

        return convertToResponse(getEmployeeOrThrow(id));
    }

    @Override
    public List<EmployeeResponseDTO> findAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    @Transactional
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {

        getEmployeeOrThrow(id);

        Employee employee = new Employee(
                id,
                dto.getEmpName(),
                dto.getDepartment(),
                dto.getSalary()
        );

        employeeRepository.update(id, employee);

        return convertToResponse(employee);
    }

    @Override
    @Transactional
    public String deleteEmployee(Long id) {

        getEmployeeOrThrow(id);
        employeeRepository.deleteById(id);

        return "Employee with ID " + id + " deleted successfully.";
    }

    private Employee getEmployeeOrThrow(Long id) {

        Employee employee = employeeRepository.findById(id);

        if (employee == null) {
            throw new EmployeeNotFoundException(
                    "Employee with ID " + id + " not found."
            );
        }

        return employee;
    }

    private EmployeeResponseDTO convertToResponse(Employee employee) {

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getEmpName(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}
