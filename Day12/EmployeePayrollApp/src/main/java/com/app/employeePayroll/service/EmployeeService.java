package com.app.employeePayroll.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.employeePayroll.DTO.EmployeeRequestDTO;
import com.app.employeePayroll.DTO.EmployeeResponseDTO;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);
    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);
    EmployeeResponseDTO findEmployeeById(Long id);
    List<EmployeeResponseDTO> findAllEmployee();
    String deleteEmployee(Long id);
    
    
    Page<EmployeeResponseDTO> getEmployees (Pageable pageable);
    
    List<EmployeeResponseDTO> findEmployeesBySalaryGreaterThan(Double salary);
  
    List<EmployeeResponseDTO> findEmployeesBySalaryBetween(Double min, Double max);
}
