package com.objectmodelling.universitywithfaculties;

import java.util.ArrayList;
import java.util.List;

// Faculty class (Aggregation: can exist independently)
public class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name + " | Specialization: " + specialization);
    }
}

