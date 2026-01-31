package com.scenariobased.markmate;

import java.util.Map;

public class StudentMarksheet {

    private int rollNo;
    private String name;
    private Map<String, Integer> subjects;
    private int total;
    private double average;
    private String grade;

    public StudentMarksheet(int rollNo, String name, Map<String, Integer> subjects,
                             int total, double average, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.subjects = subjects;
        this.total = total;
        this.average = average;
        this.grade = grade;
    }
}
