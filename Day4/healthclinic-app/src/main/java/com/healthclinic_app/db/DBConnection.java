package com.healthclinic_app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_healthclinicdb"; 
    private static final String USER  = "root";
    private static final  String PASSWORD = "1234";
    
    public static Connection getConnection() {
    	
    	Connection conn = null;
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection(URL, USER, PASSWORD);
    		//System.out.println("Successfully established Connnection");
    		
    	}catch(ClassNotFoundException e) {
    		System.err.println("JDBC Driver Not Found");
    		e.printStackTrace();
    	}catch(SQLException e) {
    		System.err.println("Connection Failed");
    		e.printStackTrace();
    	}
    	
    	return conn;
    }
    public static void main(String [] args) {
    	Connection connect = getConnection();
    	if(connect !=  null) {
    		try {
    			connect.close();
    		//	System.out.println("Connetion Closed");
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
}

