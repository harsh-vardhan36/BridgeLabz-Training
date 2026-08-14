package com.app.employeePayroll.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.employeePayroll.DTO.DepartmentRequestDTO;
import com.app.employeePayroll.DTO.DepartmentResponseDTO;
import com.app.employeePayroll.entity.Department;
import com.app.employeePayroll.exception.DepartmentNotFoundException;
import com.app.employeePayroll.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
		// Creating the department...
	 @Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
		Department department = new Department(dto.getDepName(), dto.getDescription());
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentResponseDTO  response = new DepartmentResponseDTO(
				savedDepartment.getId(),
				savedDepartment.getDepName(),
				savedDepartment.getDescription()
				);
		
		return response;
				
	}
	
	// updating the department 
	 @Override
	public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto) {
	
		Optional<Department> optionalDepartment  = departmentRepository.findById(id);
		if(optionalDepartment.isEmpty()) {
			throw  new  DepartmentNotFoundException("Department with id: "+ id + " not found!");
		}
		Department department = optionalDepartment.get();
		department.setDepName(dto.getDepName());
		department.setDescription(dto.getDescription());
	
	Department updateDepartment = departmentRepository.save(department);
	
	return new DepartmentResponseDTO (
			updateDepartment.getId(),
			updateDepartment.getDepName(),
			updateDepartment.getDescription());
	}
	
	// find department by Id
	 @Override
	public DepartmentResponseDTO findByID(Long id) {
		Department department = departmentRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Department with id: "+ id + " not found!"));

	    return new DepartmentResponseDTO(
	        department.getId(),
	        department.getDepName(),
	        department.getDescription()
	    );
		
	}
 
	// show all the department 
	 @Override
	public List<DepartmentResponseDTO> getAllDepartments() {
	    List<Department> departments = departmentRepository.findAll();

	    return departments.stream()
	        .map(department -> new DepartmentResponseDTO(
	            department.getId(),
	            department.getDepName(),
	            department.getDescription()
	        ))
	        .toList();
	}
	
	// Delete by ID
	@Override
	public String deleteDepartment(Long id) {
	    Department department = departmentRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Department with id " + id + " not found"));

	    // Business rule: check employees before deleting
	    if (department.getEmployees() != null && !department.getEmployees().isEmpty()) {
	        throw new RuntimeException("Cannot delete department with existing employees");
	    }

	    departmentRepository.deleteById(id);
	    return "Department with id: "+ id + " Deleted Successfully.";
	}
	@Override
	public Page<DepartmentResponseDTO> getDepartments(Pageable pageable) {
	    Page<Department> departments = departmentRepository.findAll(pageable);

	    return departments.map(dep -> new DepartmentResponseDTO(
	        dep.getId(),
	        dep.getDepName(),
	        dep.getDescription()
	    ));
	}
	  @Override
	    public Map<String, Long> getEmployeeCountByDepartment() {
	        List<Object[]> results = departmentRepository.getEmployeeCountByDepartment();
	        Map<String, Long> counts = new HashMap<>();
	        for (Object[] row : results) {
	            counts.put((String) row[0], (Long) row[1]);
	        }
	        return counts;
	    }

}
