package com.java8.functional.dataexport;

public class CSVExporter implements ReportExporter {

    @Override
    public void export() {
        System.out.println("Exporting report as CSV");
    }
}
