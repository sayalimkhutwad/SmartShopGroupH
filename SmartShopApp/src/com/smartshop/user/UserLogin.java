package com.smartshop.user;

import java.sql.SQLException;
import java.util.Scanner;

import com.smartshop.classes.InsertOperation_UsersTable;

public class UserLogin {

	public static void userLogin() throws SQLException {
		
		System.out.println("Welcome to Login page...");
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Enter UserName >>");
		    String username=scanner.next();
			System.out.println("Enter Password >>");
			String password=scanner.next();
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
	}
	
}
