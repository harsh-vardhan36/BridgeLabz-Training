package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class DoctorTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS doctors (" +
                         "doctorId INT PRIMARY KEY AUTO_INCREMENT, " +
                         "name VARCHAR(100) NOT NULL, " +
                         "phone VARCHAR(15), " +
                         "email VARCHAR(100), " +
                         "experienceYears INT, " +
                         "fees DOUBLE, " +
                         "joinedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                         ")";
            stmt.executeUpdate(sql);
            System.out.println("Doctors table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
