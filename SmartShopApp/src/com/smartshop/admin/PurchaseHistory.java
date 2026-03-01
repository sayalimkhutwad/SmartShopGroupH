package com.smartshop.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.smartshop.dbconnection.DBConnection;

public class PurchaseHistory {
	
	public void ViewPurchaseHistory() {
		
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from purchases");
			
			System.out.println("****Purchase History*********");
			
			while(rs.next()) {
				String uid = rs.getString(2);
				String pid = rs.getString(3);
				String qty = rs.getString(4);
				String date = rs.getString(5);
				System.out.println("User "+ uid);
				System.out.println("Purchased Product ID>> "+pid+"\nDate of purchase >> "+date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
