package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.Statement;

public class SpecializationTableSetup {
    public static void createTable() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS specializations (" +
                         "spId INT PRIMARY KEY AUTO_INCREMENT, " +
                         "specialization VARCHAR(100) NOT NULL" +
                         ")";
            stmt.executeUpdate(sql);
      //      System.out.println("Specializations table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
