package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class PatientAuditLogTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS patient_audit_log (" +
                         "logId INT PRIMARY KEY AUTO_INCREMENT, " +
                         "patientId INT NOT NULL, " +
                         "patientName VARCHAR(100), " +
                         "action VARCHAR(20) NOT NULL, " +
                         "actionAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                         ")";
            stmt.executeUpdate(sql);
      //      System.out.println("Patient audit log table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
