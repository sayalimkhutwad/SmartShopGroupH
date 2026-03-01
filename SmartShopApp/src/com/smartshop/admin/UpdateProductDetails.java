package com.smartshop.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.dbconnection.DBConnection;

public class UpdateProductDetails {
	
	public void updateProduct(){
		Scanner scanner = new Scanner(System.in);

		ViewProduct viewproduct = new ViewProduct();
		viewproduct.ViewProductStock();
		System.out.println("Select product id you want to update");
		int pid = scanner.nextInt();
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
			PreparedStatement ps = con.prepareStatement("update products set product_name=?,description=?,price=?,quantity=? where product_id=?") ;
			ps.setString(1, pname);
			ps.setString(2, Descr);
			ps.setDouble(3, price);
			ps.setInt(4, qty);
			ps.setInt(5, pid);
			ps.executeUpdate();
			System.out.println("Data Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
