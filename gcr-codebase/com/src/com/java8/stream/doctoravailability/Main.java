package com.java8.stream.doctoravailability;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Doctor> doctors = List.of(
            new Doctor("Dr. Sharma", "Cardiology", true),
            new Doctor("Dr. Mehta", "Neurology", false),
            new Doctor("Dr. Khan", "Orthopedics", true),
            new Doctor("Dr. Roy", "Dermatology", true),
            new Doctor("Dr. Patel", "Cardiology", false)
        );

        doctors.stream()
               .filter(Doctor::isWeekendAvailable)      // weekend doctors
               .sorted(Comparator.comparing(Doctor::getSpecialty))
               .forEach(System.out::println);
    }
}
