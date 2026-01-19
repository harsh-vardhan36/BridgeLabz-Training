package com.generics.resumescreening;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
            new Resume<>("Harsh", 3, 80, new SoftwareEngineer());

        Resume<DataScientist> r2 =
            new Resume<>("Amit", 2, 78, new DataScientist());

        Resume<ProductManager> r3 =
            new Resume<>("Neha", 5, 70, new ProductManager());

        ScreeningPipeline.processResume(r1);

        List<Resume<? extends JobRole>> batch = new ArrayList<>();
        batch.add(r1);
        batch.add(r2);
        batch.add(r3);

        System.out.println("\nBatch Screening:");
        ScreeningPipeline.processAllResumes(batch);
    }
}
