package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class PatientTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS patients (" +
                         "patientId INT PRIMARY KEY AUTO_INCREMENT, " +
                         "name VARCHAR(100) NOT NULL, " +
                         "age INT NOT NULL, " +
                         "gender VARCHAR(10), " +
                         "phone VARCHAR(15), " +
                         "address VARCHAR(200), " +
                         "joinedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                         ")";
            stmt.executeUpdate(sql);
         //   System.out.println("Patients table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
