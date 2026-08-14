package com.app.employeePayroll.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.employeePayroll.DTO.DepartmentRequestDTO;
import com.app.employeePayroll.DTO.DepartmentResponseDTO;



public interface DepartmentService {
	DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);
	DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto);
	DepartmentResponseDTO findByID(Long id);
    List<DepartmentResponseDTO> getAllDepartments();
    String deleteDepartment(Long id);
    Page<DepartmentResponseDTO> getDepartments(Pageable pageable);
    Map<String, Long> getEmployeeCountByDepartment();
}
