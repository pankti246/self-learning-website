package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.util.Base64;

public class updatedao {
	public String authenticateUser(updatebean l) {
		String passwordold = l.getpasswordold();
		String newpassword = l.getnewpassword();
		String username = l.getusername();
		java.sql.Connection con = null;
		java.sql.Statement statement = null;
		java.sql.ResultSet resultSet = null;
		java.sql.Statement statement1 = null;
		java.sql.ResultSet resultSet1 = null;
		System.out.println(passwordold);
		System.out.println(newpassword);
		System.out.println(username);
		String passworddb = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(passwordold.getBytes(StandardCharsets.UTF_8));
			String password = Base64.getEncoder().encodeToString(hash);
			MessageDigest digest1 = MessageDigest.getInstance("SHA-256");
			byte[] hash1 = digest1.digest(newpassword.getBytes(StandardCharsets.UTF_8));
			String passwordnew = Base64.getEncoder().encodeToString(hash1);

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from login_details where username ='"+username+"'");
			if(resultSet.next())
			{
				passworddb = resultSet.getString("pwd");

				if(password.equals(passworddb)) 
					{
						statement1 = con.createStatement();
						int i = statement1.executeUpdate("update login_details set pwd='"+passwordnew+"' where username='"+username+"'");
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
