package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class DoctorSpecializationTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS doctor_specializations (" +
                         "doctorId INT NOT NULL, " +
                         "spId INT NOT NULL, " +
                         "PRIMARY KEY (doctorId, spId), " +
                         "FOREIGN KEY (doctorId) REFERENCES doctors(doctorId), " +
                         "FOREIGN KEY (spId) REFERENCES specializations(spId)" +
                         ")";
            stmt.executeUpdate(sql);
           // System.out.println("Doctor-Specialization mapping table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
