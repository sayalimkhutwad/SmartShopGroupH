package com.smartshop.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.classes.InsertOperation_UsersTable;

public class Registration{
	
	public static void registerUser() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to User Registration");
		String firstname;
		while(true){
		    try{
		        System.out.println("Enter First Name >>");
		        firstname = scanner.next();

		        if(!firstname.matches("[A-Za-z]+")){
		            throw new Exception("First name should contain only alphabets");
		        }
		        break;
		    }
		    catch(Exception e){
		        System.out.println(e.getMessage());
		    }
		}
		String lastname;
		while(true){
		    try{
		        System.out.println("Enter Last Name >>");
		        lastname = scanner.next();

		        if(!lastname.matches("[A-Za-z]+")){
		            throw new Exception("Last name should contain only alphabets");
		        }
		        break;
		    }
		    catch(Exception e){
		        System.out.println(e.getMessage());
		    }
		}	
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
		String city;
		while(true){
		    try{
		        System.out.println("Enter City >>");
		        city = scanner.next();

		        if(!city.matches("[A-Za-z]+")){
		            throw new Exception("City should contain only alphabets");
		        }
		        break;
		    }
		    catch(Exception e){
		        System.out.println(e.getMessage());
		    }
		}
		System.out.println("Enter Email ID >>");
		String emailId=scanner.next();
		double mobileNumber;
		while(true){
		    try{
				System.out.println("Enter Mobile Number >>");
				mobileNumber=scanner.nextDouble();
				break;
		    }
		    catch(Exception e){
		        System.out.println(e.getMessage());
		    }
		}		
		InsertOperation_UsersTable.InsertUser(firstname,lastname,username,password,city,emailId,mobileNumber);
		System.out.println("Successfully registered");
	}
}