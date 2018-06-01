package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;
import java.util.Base64;

import bean.loginbean;

public class editdao {
	public String authenticateUser(editbean l)
	{

	String firstname = l.getfirstname();
	String lastname = l.getlastname();
	String username1 = l.getusername();
	String password = l.getpassword();
	java.sql.Connection con = null;
	java.sql.Statement statement = null;
	java.sql.ResultSet resultSet = null;
	java.sql.Statement statement1 = null;
	java.sql.ResultSet resultSet1 = null;
	System.out.println(username1);
	
	String passworddb = null;
	try {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		String password1 = Base64.getEncoder().encodeToString(hash);

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
		statement = con.createStatement();
		resultSet = statement.executeQuery("select * from login_details where username ='"+username1+"'");
		if(resultSet.next())
		{
			passworddb = resultSet.getString("pwd");
			System.out.println(passworddb);

			if(password1.equals(passworddb)) 
				{
					statement1 = con.createStatement();
					int i = statement1.executeUpdate("update login_details set firstname='"+firstname+"', lastname='"+lastname+"' where username='"+username1+"'");
					System.out.println(i);
					return "SUCCESS";
				}
				else {
					return "FAIL";
				}
				
			}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return "incorrect current password";
	
	}
	}
