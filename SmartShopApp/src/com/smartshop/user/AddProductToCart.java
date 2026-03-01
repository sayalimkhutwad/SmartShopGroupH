package com.smartshop.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.dbconnection.DBConnection;

public class AddProductToCart {

	public static void addProductToCart(int user_id, int product_id) throws SQLException {

	    Scanner scanner = new Scanner(System.in);

	    Connection con = DBConnection.getConnection();

	    PreparedStatement ps1 = null;
	    PreparedStatement ps2 = null;
	    PreparedStatement ps3 = null;
	    ResultSet rs = null;

	    System.out.println("Enter Quantity >>");

	    int quantity = scanner.nextInt();

	    // Check stock
	    ps1 = con.prepareStatement(
	    "SELECT quantity FROM products WHERE product_id=?");

	    ps1.setInt(1, product_id);

	    rs = ps1.executeQuery();

	    if(rs.next()) {

	        int stock = rs.getInt("quantity");

	        if(stock >= quantity) {

	            // Insert purchase
	            ps2 = con.prepareStatement(
	            "INSERT INTO purchases(user_id, product_id, quantity, purchase_date) VALUES (?, ?, ?, NOW())");

	            ps2.setInt(1, user_id);
	            ps2.setInt(2, product_id);
	            ps2.setInt(3, quantity);

	            ps2.executeUpdate();

	            // Update stock
	            ps3 = con.prepareStatement(
	            "UPDATE products SET quantity=quantity-? WHERE product_id=?");

	            ps3.setInt(1, quantity);
	            ps3.setInt(2, product_id);

	            ps3.executeUpdate();

	            System.out.println("Product purchased successfully..");

	        }
	        else {

	            System.out.println("Insufficient stock..");

	        }
	    }

	    rs.close();
	    ps1.close();
	    ps2.close();
	    ps3.close();
	    con.close();
	}
}

