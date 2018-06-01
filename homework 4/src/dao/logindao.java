package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;
import java.util.Base64;

import bean.loginbean;
import util.dbconnection;


public class logindao {
public String authenticateUser(loginbean l)
{
	String username = l.getusername();
	String pass = l.getpassword();
	
	
	java.sql.Connection con = null;
	java.sql.Statement statement = null;
	java.sql.ResultSet resultSet = null;
	
	String usernamedb = null;
	String passworddb = null;
	
	try {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
		String password = Base64.getEncoder().encodeToString(hash);
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
		statement = con.createStatement();
		resultSet = statement.executeQuery("select * from login_details");

		while(resultSet.next())
		{
			usernamedb = resultSet.getString("username");
			passworddb = resultSet.getString("pwd");
			
			if(username.equals(usernamedb) && password.equals(passworddb)) {
				return "SUCCESS";
			}
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return "Incorrect credentials.";
	
	}
	}
