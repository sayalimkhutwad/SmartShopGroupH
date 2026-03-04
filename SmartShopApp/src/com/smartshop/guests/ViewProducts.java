package com.smartshop.guests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.smartshop.dbconnection.DBConnection;

public class ViewProducts {

	public void ViewProductStocks() {

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from products");
			 System.out.println("===== Product List =====");
			 
			while (rs.next()) {
				String pid = rs.getString(1);
				String pname = rs.getString(2);
				String pdesc = rs.getString(3);
				String pp = rs.getString(4);
				String pqty = rs.getString(5);
				
				
				System.out.println(" Product ID >>  " + pid + " Product Name >>  " + pname + " product desciption >> "
						+ pdesc + " product price >> " + pp + " product quantity >>" + pqty);
				System.out.println("Guests can only view products");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
