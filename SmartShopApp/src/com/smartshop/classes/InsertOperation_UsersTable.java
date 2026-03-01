package com.smartshop.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.smartshop.dbconnection.DBConnection;

public class InsertOperation_UsersTable {

	public static void InsertUser(String fname,String lname,String username,String password,String city,String email,double mobile) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DBConnection.getConnection();
			ps=con.prepareStatement("insert into users(first_name,last_name,username,password,city,email,mobile)values(?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, email);
			ps.setDouble(7, mobile);
			int result=ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
			ps.close();
		}	

	}
	
	public static boolean isUsernameExists(String username) throws SQLException {

	    Connection con = null;
	    PreparedStatement ps = null;
	    boolean exists = false;
	    try {
	        con = DBConnection.getConnection();
	        ps = con.prepareStatement(
	            "SELECT * FROM users WHERE username=?");
	        ps.setString(1, username);
	        if(ps.executeQuery().next()) {
	            exists = true;
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        con.close();
	        ps.close();
	    }

	    return exists;
	}
	public static boolean isPasswordExists(String password) throws SQLException {

	    Connection con = null;
	    PreparedStatement ps = null;
	    boolean exists = false;
	    try {
	        con = DBConnection.getConnection();
	        ps = con.prepareStatement(
	            "SELECT * FROM users WHERE password=?");
	        ps.setString(1, password);
	        if(ps.executeQuery().next()) {
	            exists = true;
	        }
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        con.close();
	        ps.close();
	    }

	    return exists;
	}

}
