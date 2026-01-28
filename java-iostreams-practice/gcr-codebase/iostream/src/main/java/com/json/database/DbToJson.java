package com.json.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.*;

public class DbToJson {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mydb";
		List<Map<String, Object>> rows = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, "user", "pass");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int i = 1; i <= columns; i++)
					row.put(md.getColumnName(i), rs.getObject(i));
				rows.add(row);
			}
			System.out.println(new ObjectMapper().writeValueAsString(rows));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}