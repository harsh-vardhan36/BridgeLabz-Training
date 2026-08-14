package com.app.employeePayroll.controller;

import java.util.List;

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

import com.app.employeePayroll.DTO.EmployeeRequestDTO;
import com.app.employeePayroll.DTO.EmployeeResponseDTO;
import com.app.employeePayroll.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeResponseDTO createEmployee(@RequestBody @Valid EmployeeRequestDTO dto) {
        return employeeService.createEmployee(dto);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeRequestDTO dto) {
        return employeeService.updateEmployee(id, dto);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.findAllEmployee();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
    @GetMapping("/paginated")
    public Page<EmployeeResponseDTO> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "empName") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeService.getEmployees(pageable);
    }
    @GetMapping("/salaryGreaterThan/{amount}")
    public List<EmployeeResponseDTO> getEmployeesBySalary(@PathVariable Double amount) {
        return employeeService.findEmployeesBySalaryGreaterThan(amount);
    }
    @GetMapping("/salaryBetween/{min}/{max}")
    public List<EmployeeResponseDTO> getEmployeesBySalaryBetween(
            @PathVariable Double min,
            @PathVariable Double max) {
        return employeeService.findEmployeesBySalaryBetween(min, max);
    }

}
