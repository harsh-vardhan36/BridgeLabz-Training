package com.java8.functional.dataexport;

public interface ReportExporter {

    void export();   // existing method

    default void exportToJSON() {
        System.out.println("JSON export is not supported for this exporter.");
    }
}
