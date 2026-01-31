package com.java8.references.patientid;

import java.util.Arrays;
import java.util.List;

public class HospitalAdmin {

    public static void main(String[] args) {

        List<String> patientIds = Arrays.asList(
                "PID101",
                "PID102",
                "PID103",
                "PID104"
        );

        // Method Reference used here
        patientIds.forEach(System.out::println);
    }
}
