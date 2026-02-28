package com.smartshop.main;

import java.util.Scanner;

import com.smartshop.classes.InsertOperation_UsersTable;

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
			System.out.println("Welcome to User Registration");
			System.out.println("Enter First Name >>");
			String firstname=scanner.next();
			System.out.println("Enter Last Name >>");
			String lastname=scanner.next();		
			String username;
			while(true){
			    System.out.println("Enter UserName >>");
			    username=scanner.next();
			    System.out.println("Checking for duplicate username...");
			    if(InsertOperation_UsersTable.isUsernameExists(username)){
			        System.out.println("Username already exists! Try again.");
			    }
			    else{
			        break;
			    }
			}
			System.out.println("Enter Password >>");
			String password=scanner.next();
			System.out.println("Enter City >>");
			String city=scanner.next();
			System.out.println("Enter Email ID >>");
			String emailId=scanner.next();
			System.out.println("Enter Mobile Number >>");
			double mobileNumber=scanner.nextDouble();
			
			InsertOperation_UsersTable.InsertUser(firstname,lastname,username,password,city,emailId,mobileNumber);
			System.out.println("Successfully registered");			
			
		case 2:		
			System.out.println("Welcome to Login page...");
			while(true){
				System.out.println("Enter UserName >>");
			    username=scanner.next();
				System.out.println("Enter Password >>");
				password=scanner.next();
				System.out.println("Verifying credentials...");
			    if(InsertOperation_UsersTable.isUsernameExists(username)){
			    	if(InsertOperation_UsersTable.isPasswordExists(password)){
				        System.out.println("Successfully logged in.");
				        break;
				    }
			    }
			    else{
			    	System.out.println("Wrong username or password! Try again.");
			    }
			}
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
		System.out.println("Please choose an option:");
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
	
	public static void main(String[] args) {
		selectUser();		
	}

}
