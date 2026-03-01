package com.smartshop.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.dbconnection.DBConnection;

public class DeleteProducts {
	
	public void deleteProduct() {
		
		try {
		Scanner scanner = new Scanner(System.in);

		ViewProduct viewproduct = new ViewProduct();
		viewproduct.ViewProductStock();
		System.out.println("Select product id you want to delete");
		int pid = scanner.nextInt();
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from products where product_id=?") ;
		ps.setInt(1, pid);
		ps.executeUpdate();
		System.out.println("Product deleted Successfully");
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
