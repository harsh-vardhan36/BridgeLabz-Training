package com.app.employeePayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.employeePayroll.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	 
	
	@Query("""
		    SELECT d.depName, COUNT(e)
		    FROM Department d
		    LEFT JOIN d.employees e
		    GROUP BY d.depName
		""")
	List<Object[]> getEmployeeCountByDepartment();
}
