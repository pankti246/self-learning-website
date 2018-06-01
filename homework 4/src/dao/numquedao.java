package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.util.Base64;

import bean.numquebean;

public class numquedao {
	public String storevalues(numquebean n) {
		String question = n.getquestion();
		String hint = n.gethint();
		String answer = n.getanswer();
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
			String sql = "insert into numerical_questions(question,hint,answer) values (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,question);
			ps.setString(2, hint);
			ps.setString(3, answer);
			
			int i = ps.executeUpdate();
			if(i!=0) 
				return "SUCCESS";
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return "Question not submitted... Enter numeric value for answer";
	}
	

}
