package com.scenariobased.apollohospital;

public class HealthCheckPro{

    public static void main(String[] args) {
        AnnotationScanner.scan(LabController.class);
    }
}