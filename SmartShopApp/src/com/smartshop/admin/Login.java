package com.smartshop.admin;

import java.util.Scanner;

public class Login {

	public void adminLogin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Username");
		String uname =scanner.next();
		System.out.println("Enter Password");
		String pwd =scanner.next();
		
		if(uname.equals("Admin") && pwd.equals("Admin")) {
			System.out.println("Logged in Successfully");
		}else {
			System.out.println("Login failed");
		}
		
	}
}
