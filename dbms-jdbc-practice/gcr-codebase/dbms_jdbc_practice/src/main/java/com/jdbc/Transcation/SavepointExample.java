package com.jdbc.Transcation;

import java.sql.*;

import com.jdbc.DatabaseConnection;

public class SavepointExample {

    public static void complexTransaction() {

        try (Connection conn = DatabaseConnection.getConnection()) {

            conn.setAutoCommit(false); // Start transaction

            Savepoint sp1 = null;
            Savepoint sp2 = null;

            try {

                // Operation 1
                PreparedStatement pstmt1 =
                        conn.prepareStatement("INSERT INTO logs (message) VALUES (?)");
                pstmt1.setString(1, "Operation 1 Completed");
                pstmt1.executeUpdate();

                sp1 = conn.setSavepoint("Savepoint1");

                // Operation 2
                PreparedStatement pstmt2 =
                        conn.prepareStatement("INSERT INTO logs (message) VALUES (?)");
                pstmt2.setString(1, "Operation 2 Completed");
                pstmt2.executeUpdate();

                sp2 = conn.setSavepoint("Savepoint2");

                // Operation 3 (simulate failure)
                PreparedStatement pstmt3 =
                        conn.prepareStatement("INSERT INTO logs (message) VALUES (?)");
                pstmt3.setString(1, "Operation 3 Failed");
                pstmt3.executeUpdate();

                // Rollback only Operation 3
                conn.rollback(sp2);
                System.out.println("Rolled back to Savepoint2");

                conn.commit();
                System.out.println("Transaction Committed Successfully!");

            } catch (SQLException e) {

                conn.rollback();
                System.out.println("Full Transaction Rolled Back!");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        complexTransaction();
    }
}
