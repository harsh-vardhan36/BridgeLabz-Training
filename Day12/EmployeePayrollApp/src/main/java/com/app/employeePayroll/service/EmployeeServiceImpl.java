package com.app.employeePayroll.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
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
    	logger.info("Creating Employee: ",dto.getEmpName());
        Department department = departmentRepository.findById(dto.getDepartment_id())
            .orElseThrow(() -> new RuntimeException("Department not found"));
        logger.info("Failed  to Create the Employee ");
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
    	logger.info("Updating the employee: ", dto.getEmpName());
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));
        logger.info("Failed to Create Employee ");
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
    	logger.info("Finding the Employee with Id: ", id);
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
    	logger.info("Finding all the Employee ");
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
    	logger.info("Deleting  the Employee with ID: ", id);
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));
        logger.info("Failed to Delete Employee ");
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
