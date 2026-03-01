package com.smartshop.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.dbconnection.DBConnection;

public class SearchProduct {

	public static int searchProduct() throws SQLException {

	    Scanner scanner = new Scanner(System.in);

	    Connection con = DBConnection.getConnection();

	    PreparedStatement ps = con.prepareStatement(
	    "SELECT * FROM products WHERE product_id=?");

	    System.out.println("Enter the Product ID to purchase >>");

	    int product_id = scanner.nextInt();

	    ps.setInt(1, product_id);

	    ResultSet rs = ps.executeQuery();

	    if(rs.next()) {

	        System.out.println("Product Found:");
	        System.out.println("ID: " + rs.getInt("product_id"));
	        System.out.println("Name: " + rs.getString("product_name"));
	        System.out.println("Price: " + rs.getDouble("price"));
	        System.out.println("Available Quantity: " + rs.getInt("quantity"));

	        rs.close();
	        ps.close();
	        con.close();

	        return product_id;  // return valid id
	    }

	    else {

	        System.out.println("Invalid Product ID");

	        rs.close();
	        ps.close();
	        con.close();

	        return -1; // invalid id
	    }
	}
}
