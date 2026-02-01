package com.java8.collectors.studentresult;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        List<Student> students = List.of(
            new Student("Amit", "A"),
            new Student("Riya", "B"),
            new Student("Karan", "A"),
            new Student("Sneha", "C"),
            new Student("Vikas", "B")
        );

        Map<String, List<String>> studentsByGrade =
                students.stream()
                        .collect(Collectors.groupingBy(
                            Student::getGrade,
                            Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        studentsByGrade.forEach((grade, names) ->
            System.out.println("Grade " + grade + " → " + names)
        );
    }
}

