package dao;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;

import bean.signupbean;

public class signupdao {
	public String storevalues(signupbean s) {
		String firstname = s.getfirstname();
		String lastname = s.getlastname();
		String username = s.getusername();
		String pass = s.getpassword();
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps = null;
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
			String password = Base64.getEncoder().encodeToString(hash);

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
			String sql = "insert into login_details(username,pwd,firstname,lastname) values (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2, password);
			ps.setString(3, firstname);
			ps.setString(4, lastname);
			
			int i = ps.executeUpdate();
			if(i!=0) 
				return "SUCCESS";
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return "Username already exists";
	}
	

}
