package com.app.employeePayroll.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
		// Creating the department...
	 @Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
		 logger.info("Creating Department : ", dto.getDepName());
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
		 logger.info("Updating Department: ",dto.getDepName());
		Optional<Department> optionalDepartment  = departmentRepository.findById(id);
		if(optionalDepartment.isEmpty()) {
			logger.info("Failed to Update Department");
			throw  new  DepartmentNotFoundException("Department with id: "+ id + " not found!");
		}
		Department department = optionalDepartment.get();
		department.setDepName(dto.getDepName());
		department.setDescription(dto.getDescription());
	
	Department updateDepartment = departmentRepository.save(department);
	logger.info("Successfully Updated Department with description : ", department.getDescription());
	return new DepartmentResponseDTO (
			updateDepartment.getId(),
			updateDepartment.getDepName(),
			updateDepartment.getDescription());
	}
	
	// find department by Id
	 @Override
	public DepartmentResponseDTO findByID(Long id) {
		 logger.info("Finding the  Department with id : ",id );
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
	    logger.info("Showing all Departments");
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
		logger.info("Deleting the Department with  Id: ", id);
	    Department department = departmentRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Department with id " + id + " not found"));

	    // Business rule: check employees before deleting
	    if (department.getEmployees() != null && !department.getEmployees().isEmpty()) {
	       logger.info("Failed to Delete the Department");
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
