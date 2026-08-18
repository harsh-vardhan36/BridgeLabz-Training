package com.app.employeePayroll.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.employeePayroll.DTO.DepartmentRequestDTO;
import com.app.employeePayroll.DTO.DepartmentResponseDTO;
import com.app.employeePayroll.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @Operation(summary = "Create a new department", description = "Adds a new department to the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Department created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public DepartmentResponseDTO addDepartment(@RequestBody @Valid DepartmentRequestDTO dto) {
        return departmentService.createDepartment(dto);
    }
    @Operation(summary = "Update department", description = "Updates department details by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Department updated successfully"),
        @ApiResponse(responseCode = "404", description = "Department not found")
    })
    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(@PathVariable Long id, @RequestBody @Valid DepartmentRequestDTO dto) {
        return departmentService.updateDepartment(id, dto);
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.findByID(id);
    }
    @Operation(summary = "Get all departments", description = "Fetches all departments from the system")
    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @Operation(summary = "Delete department", description = "Deletes a department by ID")
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartment(id);
    }
    @GetMapping("/paginated")
    public Page<DepartmentResponseDTO> getDepartments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "depName") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return departmentService.getDepartments(pageable);
    }
    @GetMapping("/employeeCount")
    public Map<String, Long> getEmployeeCountByDepartment() {
        return departmentService.getEmployeeCountByDepartment();
    }
}
