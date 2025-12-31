package com.objectmodelling.companyanddepartment;

import java.util.ArrayList;
import java.util.List;


public class CompanyanddepartmentMain {
    public static void main(String[] args) {
        // Create company
        Company company = new Company("Tech Solutions Pvt Ltd");

        // Create departments
        Department devDept = new Department("Development");
        Department hrDept = new Department("Human Resources");

        // Add employees to departments
        devDept.addEmployee("Alice", "Software Engineer");
        devDept.addEmployee("Bob", "Senior Developer");

        hrDept.addEmployee("Charlie", "HR Manager");
        hrDept.addEmployee("Diana", "Recruiter");

        // Add departments to company
        company.addDepartment(devDept);
        company.addDepartment(hrDept);

        // Display company structure
        company.displayCompanyStructure();

        // Delete company (composition ensures departments & employees are gone)
        company.deleteCompany();

        // Try displaying again (should show nothing)
        company.displayCompanyStructure();
    }
}
