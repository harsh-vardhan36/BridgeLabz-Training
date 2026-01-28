package com.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbToCsvReportApp {

    // DB credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/companydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {

        String csvFile = "src/main/resources/employees_report.csv";

        String query = "SELECT emp_id, name, department, salary FROM employees";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                CSVWriter writer = new CSVWriter(new FileWriter(csvFile))
        ) {

            // Write header
            String[] header = {
                    "Employee ID",
                    "Name",
                    "Department",
                    "Salary"
            };
            writer.writeNext(header);

            while (rs.next()) {
                String[] row = {
                        String.valueOf(rs.getInt("emp_id")),
                        rs.getString("name"),
                        rs.getString("department"),
                        String.valueOf(rs.getInt("salary"))
                };
                writer.writeNext(row);
            }

            System.out.println("CSV report generated successfully: employees_report.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
