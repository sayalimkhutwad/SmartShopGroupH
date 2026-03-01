package com.smartshop.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.smartshop.dbconnection.DBConnection;

public class SelectOperation_UsersTable {

	public static List<String> viewProducts() throws SQLException {
		
		List<String> list=new ArrayList<String>();
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        con = DBConnection.getConnection();
	        ps = con.prepareStatement(
	            "SELECT * FROM products");
	        rs= ps.executeQuery();
	        while(rs.next()) {
	        	String productDetails =
	                    rs.getInt("product_id") + "  " +
	                    rs.getString("product_name") + "  " +
	                    rs.getString("description") + "  " +
	                    rs.getDouble("price") + "  " +
	                    rs.getInt("quantity");

	            list.add(productDetails);
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        con.close();
	        ps.close();
	        rs.close();
	    }
	    System.out.println("******Products are*******");
	    System.out.println(list);
	    return list;
	}
		
}
