package com.smartshop.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.dbconnection.DBConnection;

public class AddProduct {
	
	public void AddNewProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product Name");
		String pname = scanner.next();
		System.out.println("Enter Product Description");
		String Descr = scanner.next();
		System.out.println("Enter Product Price");
		double price = scanner.nextDouble();
		System.out.println("Enter Product Quantity");
		int qty = scanner.nextInt();
				
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into products(product_name,description,price,quantity) values(?,?,?,?) ") ;
			ps.setString(1, pname);
			ps.setString(2, Descr);
			ps.setDouble(3, price);
			ps.setInt(4, qty);
			ps.executeUpdate();
			System.out.println("Data Inserted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
