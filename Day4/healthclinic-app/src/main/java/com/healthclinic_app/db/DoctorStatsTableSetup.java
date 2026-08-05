package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class DoctorStatsTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS doctor_stats (" +
                         "doctorId INT PRIMARY KEY, " +
                         "totalPatients INT, " +
                         "FOREIGN KEY (doctorId) REFERENCES doctors(doctorId)" +
                         ")";
            stmt.executeUpdate(sql);
            System.out.println("DoctorStats table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
