package com.smartshop.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String DB_Driver_Name = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/smartshop";
    private static final String DB_UNAME = "root";
    private static final String DB_PWD = "root";
	
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName(DB_Driver_Name);
			con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
