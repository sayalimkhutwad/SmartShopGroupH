package com.smartshop.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import com.smartshop.dbconnection.DBConnection;

public class ViewProduct {
	
	public void ViewProductStock() {
		
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products");
			while(rs.next()) {
				String pid = rs.getString(1);
				String pname = rs.getString(2);
				String pdesc = rs.getString(3);
				String pp = rs.getString(4);
				String pqty = rs.getString(5);
				System.out.println(" Product ID >>  "+pid+" Product Name >>  "+pname+" >> "+pqty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
