package com.scenariobased.markmate;

import java.util.*;

public class MarkMateApp {

    public static void main(String[] args) {

        try {
            List<String[]> csvData = CSVReaderUtil.readCSV("marks.csv");

            String[] header = csvData.get(0);
            List<StudentMarksheet> reportCards = new ArrayList<>();

            for (int i = 1; i < csvData.size(); i++) {
                StudentMarksheet sheet =
                        MarkProcessor.process(header, csvData.get(i));

                if (sheet != null) {
                    reportCards.add(sheet);
                }
            }

            JsonWriterUtil.writeToJson(reportCards, "report_card.json");
            System.out.println("✅ JSON report card generated successfully");

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
