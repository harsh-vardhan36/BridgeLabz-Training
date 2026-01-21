package com.mapinterface.groupobjects;

import java.util.*;

public class EmployeeGrouper {

    public static Map<String, List<Employee>> groupByDepartment(
            List<Employee> employees) {

        Map<String, List<Employee>> groupedMap = new HashMap<>();

        for (Employee emp : employees) {

            groupedMap
                .computeIfAbsent(emp.getDepartment(),
                                 d -> new ArrayList<>())
                .add(emp);
        }

        return groupedMap;
    }
}
