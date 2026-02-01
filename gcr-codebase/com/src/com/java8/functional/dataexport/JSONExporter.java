package com.java8.functional.dataexport;

public class JSONExporter implements ReportExporter {

    @Override
    public void export() {
        System.out.println("Exporting report as JSON");
    }

    @Override
    public void exportToJSON() {
        System.out.println("Custom JSON export logic executed");
    }
}
