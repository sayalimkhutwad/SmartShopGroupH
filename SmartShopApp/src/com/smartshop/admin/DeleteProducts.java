package com.smartshop.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
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
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select product_id from products");
		System.out.println("Query");
		int counter = 0;
		while(rs.next()) {
			if(rs.getString(1).equals(pid)) {
				
				PreparedStatement ps = con.prepareStatement("delete from products where product_id=?") ;
				ps.setInt(1, pid);
				ps.executeUpdate();
				System.out.println("Product deleted Successfully");
				
			}else {
				counter = 1;
			}
			
		}
		if(counter == 1) {
			System.out.println("Please enter correct product id");
		}
		
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
