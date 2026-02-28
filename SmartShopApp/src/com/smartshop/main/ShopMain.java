package com.smartshop.main;

import java.util.Scanner;

import com.smartshop.admin.AddProduct;
import com.smartshop.admin.Login;

public class ShopMain {
	public static void selectUser() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("*****Welcome to E-Commerce Console Application*****");
		System.out.println("Select any one user type");
		System.out.println("1. Login/Register as User");
		System.out.println("2. Login as Admin");
		System.out.println("3. Login as Guest");
		
		try {
			int usertype = scanner.nextInt();
			
			switch(usertype) {
			
			case 1:
				UserChoice();
				break;
			case 2:
				AdminChoice();
				break;
			case 3:
				GuestChoice();
				break;
			default:
				System.out.println("Enter valid choice");
				break;
			
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Do you want to continue..?");
	}
	
	public static void UserChoice() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose an option:");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. View Products");
		System.out.println("4. Search Products");
		System.out.println("5. Add to Cart");
		System.out.println("6. View Cart");
		System.out.println("7. View Purchase History");
		System.out.println("8. Exit");
		int choice = scanner.nextInt();
		try {
		switch(choice) {
		
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		default:
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void AdminChoice() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Login:");
		Login login = new Login();
		login.adminLogin();
		System.out.println("Select choice");
		System.out.println("1. Add New Product");
		System.out.println("2. View Product Stock");
		System.out.println("3. View Registered Users");
		System.out.println("4. View User Purchase History");
		System.out.println("5. Update Product Details");
		System.out.println("6. Delete Product from Inventory");
		try {
		int choice = scanner.nextInt();
		switch(choice) {
		
			case 1: 		
				AddProduct addproduct = new AddProduct();
				addproduct.AddNewProduct();
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			default:
		}}catch(Exception e) {
			System.out.println(e);
		}

		}
	
	public static void GuestChoice() {
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose an option:");
		System.out.println("1. View Products");
		System.out.println("2. Search Products");
		int choice = scanner.nextInt();
		
		switch(choice) {
				
				case 1:
				case 2:
				default:
				}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		selectUser();		
	}

}
