package scenariobased.employee;

import java.util.*;
import java.util.stream.Collectors;

public class Department {
    public static void main(String[] args) {

        // Creating employee
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Amit", 25, "Male", "IT", 2021, 50000),
            new Employee(2, "Neha", 28, "Female", "HR", 2019, 60000),
            new Employee(3, "Rahul", 30, "Male", "Finance", 2018, 70000),
            new Employee(4, "Pooja", 26, "Female", "IT", 2022, 55000),
            new Employee(5, "Suresh", 35, "Male", "Admin", 2015, 80000)
        );

        // Print all unique department names
        employees.stream()
                 .map(Employee::getDepartment)
                 .distinct()
                 .forEach(System.out::println);
    }

}
