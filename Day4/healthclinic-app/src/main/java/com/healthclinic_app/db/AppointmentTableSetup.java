package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class AppointmentTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS appointments (" +
                         "appointmentId INT PRIMARY KEY AUTO_INCREMENT, " +
                         "doctorId INT NOT NULL, " +
                         "patientId INT NOT NULL, " +
                         "appointmentTime TIMESTAMP NOT NULL, " +
                         "status VARCHAR(20), " +
                         "diagnosis VARCHAR(200), " +
                         "FOREIGN KEY (doctorId) REFERENCES doctors(doctorId), " +
                         "FOREIGN KEY (patientId) REFERENCES patients(patientId)" +
                         ")";
            stmt.executeUpdate(sql);
           // System.out.println("Appointments table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
