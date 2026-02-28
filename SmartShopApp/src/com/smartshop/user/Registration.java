package com.smartshop.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.classes.InsertOperation_UsersTable;

public class Registration{
	
	public static void registerUser() throws SQLException {
		Scanner scanner = new Scanner(System.in);
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
	}
}