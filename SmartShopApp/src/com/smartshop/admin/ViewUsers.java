package com.smartshop.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.smartshop.dbconnection.DBConnection;

public class ViewUsers {
	
	public void getRegisteredUsers() {
		
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while(rs.next()) {
				String uid = rs.getString(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String uname = rs.getString(4);
				String city = rs.getString(6);
				String email = rs.getString(7);
				String mobile = rs.getString(8);


				System.out.println("User ID >> "+uid+" Name >> "+fname+ " " +lname+" Email ID >> "+email+" Contact >> "+mobile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
