package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class BillTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS bills (" +
                         "billId INT PRIMARY KEY AUTO_INCREMENT, " +
                         "appointmentId INT NOT NULL, " +
                         "patientId INT NOT NULL, " +
                         "doctorId INT NOT NULL, " +
                         "amount DOUBLE NOT NULL, " +
                         "status VARCHAR(20) NOT NULL DEFAULT 'UNPAID', " +
                         "generatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                         "paidAt TIMESTAMP NULL, " +
                         "FOREIGN KEY (appointmentId) REFERENCES appointments(appointmentId), " +
                         "FOREIGN KEY (patientId) REFERENCES patients(patientId), " +
                         "FOREIGN KEY (doctorId) REFERENCES doctors(doctorId)" +
                         ")";
            stmt.executeUpdate(sql);
          //  System.out.println("Bills table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
