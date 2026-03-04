package com.smartshop.guests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.dbconnection.DBConnection;

public class SearchProducts {

	public void searchProduct() {

		Scanner scanner = new Scanner(System.in);

		try {
			Connection con = DBConnection.getConnection();

			System.out.print("Enter product name to search: ");
			String product_name = scanner.nextLine();
			

			PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE LOWER(product_name) LIKE LOWER(?)");

			ps.setString(1, "%" + product_name + "%");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Product Found:");
				System.out.println("ID: " + rs.getInt("product_id"));
				System.out.println("Name: " + rs.getString("product_name"));
				System.out.println("Description: " + rs.getString("description"));
				System.out.println("Price: " + rs.getDouble("price"));
				System.out.println("Available Quantity: " + rs.getInt("quantity"));
			}

			else {
				System.out.println("No product found.");
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
}
