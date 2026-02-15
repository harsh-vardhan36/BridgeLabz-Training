package com.jdbc.CRUD;

import java.sql.*;

import com.jdbc.DatabaseConnection;

public class InsertStudent {

	public static void insertStudent(String name, String email, int age, String grade) {
		String sql = "INSERT INTO students (name, email, age, grade, enrollment_date) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, age);
			pstmt.setString(4, grade);
			pstmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			int rowsAffected = pstmt.executeUpdate();
			System.out.println(rowsAffected + " row(s) inserted successfully!");
		} catch (SQLException e) {
			System.err.println("Insert failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		insertStudent("Harsh Vardhan", "hrshvardhan@proton.me", 20, "A");
		insertStudent("Hare Krishna", "harekrishna@god.universe", 22, "B");
	}

	public void getAllStudents() {
		String sql = "SELECT * FROM students";

		try (Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			System.out.println("ID\tName\t\tEmail\t\t\tAge\tGrade");
			System.out.println("--------------------------------------------------------");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				String grade = rs.getString("grade");

				System.out.printf("%d\t%s\t%s\t%d\t%s%n", id, name, email, age, grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}