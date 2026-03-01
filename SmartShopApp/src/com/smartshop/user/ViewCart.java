package com.smartshop.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smartshop.dbconnection.DBConnection;

public class ViewCart {
	
	public static List<String> viewCart() throws SQLException {
			
			List<String> list=new ArrayList<String>();
			Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;
		    try {
		        con = DBConnection.getConnection();
		        ps = con.prepareStatement(
		            "SELECT * FROM purchases");
		        rs= ps.executeQuery();
		        while(rs.next()) {
		        	String cartDetails =
		                    rs.getInt("purchase_id") + "  " +
		                    rs.getInt("user_id") + "  " +
		                    rs.getInt("product_id") + "  " +
		                    rs.getInt("quantity") + "  " +
		                    rs.getString("purchase_date");

		            list.add(cartDetails);
		        }
		    } catch(Exception e) {
		        e.printStackTrace();
		    } finally {
		        con.close();
		        ps.close();
		        rs.close();
		    }
		    System.out.println("******Cart Items are*******");
		    for(String product : list) {

		        String[] details = product.split("  ");

		        System.out.println("----------------------------");
		        System.out.println("Purchase ID	: " + details[0]);
		        System.out.println("User ID 	: " + details[1]);
		        System.out.println("Product ID  : " + details[2]);
		        System.out.println("Quantity    : " + details[3]);
		        System.out.println("Purchase_date : " + details[4]);
		    }
		    return list;
	}
			
	

}
