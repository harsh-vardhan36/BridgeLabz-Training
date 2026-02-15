package com.jdbc.Transcation;

import java.sql.*;

import com.jdbc.DatabaseConnection;

public class TransactionExample {

    public static void transferMoney(int fromAccount, int toAccount, double amount) {

        String deductSql =
                "UPDATE accounts SET balance = balance - ? " +
                "WHERE account_id = ? AND balance >= ?";

        String addSql =
                "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {

            conn.setAutoCommit(false); // Start transaction

            try (PreparedStatement deductStmt = conn.prepareStatement(deductSql);
                 PreparedStatement addStmt = conn.prepareStatement(addSql)) {

                // Step 1: Deduct Money
                deductStmt.setDouble(1, amount);
                deductStmt.setInt(2, fromAccount);
                deductStmt.setDouble(3, amount);

                int rows1 = deductStmt.executeUpdate();

                // Step 2: Add Money
                addStmt.setDouble(1, amount);
                addStmt.setInt(2, toAccount);

                int rows2 = addStmt.executeUpdate();

                // Step 3: Commit or Rollback
                if (rows1 > 0 && rows2 > 0) {
                    conn.commit();
                    System.out.println("Transfer Successful!");
                } else {
                    conn.rollback();
                    System.out.println("Transfer Failed! Rolled Back.");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction Failed! Rolled Back.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Transfer 500 from account 101 to 102
        transferMoney(101, 102, 500);
    }
}
