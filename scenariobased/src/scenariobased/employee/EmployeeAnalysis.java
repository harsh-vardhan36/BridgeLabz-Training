package scenariobased.employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAnalysis {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // Sample data (realistic)
        employees.add(new Employee(1, "Amit", 25, "Male", "IT", 2021, 50000));
        employees.add(new Employee(2, "Neha", 28, "Female", "HR", 2019, 60000));
        employees.add(new Employee(3, "Rahul", 30, "Male", "Finance", 2018, 70000));
        employees.add(new Employee(4, "Pooja", 26, "Female", "IT", 2022, 55000));
        employees.add(new Employee(5, "Suresh", 35, "Male", "Admin", 2015, 80000));

        // Gender-wise count
        Map<String, Long> genderCount =
                employees.stream()
                         .collect(Collectors.groupingBy(
                             Employee::getGender,
                             Collectors.counting()
                         ));

        // Print result
        genderCount.forEach((gender, count) ->
                System.out.println(gender + " Employees: " + count));
    }
}

