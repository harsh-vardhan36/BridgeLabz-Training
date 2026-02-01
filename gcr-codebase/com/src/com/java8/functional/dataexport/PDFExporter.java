package com.java8.functional.dataexport;

public class PDFExporter implements ReportExporter {

    @Override
    public void export() {
        System.out.println("Exporting report as PDF");
    }
}
