package com.java8.functional.dataexport;

public class ReportApp {

    public static void main(String[] args) {

        ReportExporter csv = new CSVExporter();
        ReportExporter pdf = new PDFExporter();
        ReportExporter json = new JSONExporter();

        csv.exportToJSON();   
        pdf.exportToJSON();
        json.exportToJSON();  
    }
}
