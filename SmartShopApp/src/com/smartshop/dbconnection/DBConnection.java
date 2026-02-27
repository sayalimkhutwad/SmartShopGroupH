package com.smartshop.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String DB_Driver_Name = "com.mysql.cj.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/smartshop";
    private final static String DB_UNAME = "root";
    private final static String DB_PWD = "root";
	
	public Connection getConnection() throws SQLException {
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
