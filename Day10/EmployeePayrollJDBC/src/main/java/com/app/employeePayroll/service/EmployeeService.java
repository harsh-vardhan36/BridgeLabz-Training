package com.app.employeePayroll.service;

import java.util.List;

import com.app.employeePayroll.dto.EmployeeRequestDTO;
import com.app.employeePayroll.dto.EmployeeResponseDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);

    EmployeeResponseDTO findEmployeeById(Long id);

    List<EmployeeResponseDTO> findAllEmployees();

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);

    String deleteEmployee(Long id);
}
