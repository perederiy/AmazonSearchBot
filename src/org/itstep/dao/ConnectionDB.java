package org.itstep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	static final String URL = "jdbc:postgresql://localhost:5432/homeworkdb";
	static final String USER = "postgres";
	static final String PASSWORD = "qwerty27011983";
	
	public static Connection getConnection() {
		
		Connection connection = null;
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
	return connection;
	
	}
}
