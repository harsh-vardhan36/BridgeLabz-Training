package com.app.employeePayroll.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.employeePayroll.DTO.EmployeeRequestDTO;
import com.app.employeePayroll.DTO.EmployeeResponseDTO;
import com.app.employeePayroll.entity.Department;
import com.app.employeePayroll.entity.Employee;
import com.app.employeePayroll.exception.EmployeeNotFoundException;
import com.app.employeePayroll.repository.DepartmentRepository;
import com.app.employeePayroll.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    // Single constructor for dependency injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // Creating Employee
    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
        Department department = departmentRepository.findById(dto.getDepartment_id())
            .orElseThrow(() -> new RuntimeException("Department not found"));

        Employee employee = new Employee(dto.getEmpName(), department, dto.getSalary());
        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeResponseDTO(
            savedEmployee.getId(),
            savedEmployee.getEmpName(),
            department.getDepName(),
            savedEmployee.getSalary()
        );
    }

    //  Update Employee
    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));

        Department department = departmentRepository.findById(dto.getDepartment_id())
            .orElseThrow(() -> new RuntimeException("Department not found"));

        // Update existing fields
       
        employee.setEmpName(dto.getEmpName());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        Employee updatedEmployee = employeeRepository.save(employee);

        return new EmployeeResponseDTO(
            updatedEmployee.getId(),
            updatedEmployee.getEmpName(),
            department.getDepName(),
            updatedEmployee.getSalary()
        );
    }

    //  Find Employee by ID
    @Override
    public EmployeeResponseDTO findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found!"));

        return new EmployeeResponseDTO(
            employee.getId(),
            employee.getEmpName(),
            employee.getDepartment().getDepName(),
            employee.getSalary()
        );
    }
    
    // FInd all employees
    @Override
    public List<EmployeeResponseDTO> findAllEmployee(){
    	List<Employee> allEmployee = employeeRepository.findAll();
    	
    	return allEmployee.stream()
    			.map(employee -> new EmployeeResponseDTO(
    				employee.getId(),
    				employee.getEmpName(),
    				employee.getDepartment().getDepName(),
    				employee.getSalary()
    				))
    			.toList();
    }
 //  Delete Employee
    @Override
    public String deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));

        employeeRepository.deleteById(id);
        return "Employee with ID " + id + " has been deleted successfully.";
    }
  
    
    @Override
    public Page<EmployeeResponseDTO> getEmployees(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);

        return employees.map(emp -> new EmployeeResponseDTO(
            emp.getId(),
            emp.getEmpName(),
            emp.getDepartment().getDepName(),
            emp.getSalary()
        ));
    }
    
    @Override
    public List<EmployeeResponseDTO> findEmployeesBySalaryGreaterThan(Double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary)
                .stream()
                .map(emp -> new EmployeeResponseDTO(
                        emp.getId(),
                        emp.getEmpName(),
                        emp.getDepartment().getDepName(),
                        emp.getSalary()
                ))
                .toList();
    }
 
    @Override
    public List<EmployeeResponseDTO> findEmployeesBySalaryBetween(Double min, Double max) {
        return employeeRepository.findBySalaryBetween(min, max)
                .stream()
                .map(emp -> new EmployeeResponseDTO(
                        emp.getId(),
                        emp.getEmpName(),
                        emp.getDepartment().getDepName(),
                        emp.getSalary()
                ))
                .toList();
    }

}
