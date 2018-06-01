package dao;
import java.sql.*;
import bean.mcqbean;
import bean.numsubmitbean;

public class mcqsubmitdao {
	public String authenticateUser(mcqbean l) {
		String ans = l.getanswer();
		String queno = l.getqueno();
		
		java.sql.Connection con = null;
		java.sql.Statement statement = null;
		java.sql.ResultSet resultSet = null;
		java.sql.PreparedStatement ps = null;

		String answerdb = null;
		String hint = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
			statement = con.createStatement();
			
			resultSet = statement.executeQuery("select * from mcq_questions where que_id="+queno+"");
			
			while(resultSet.next())
			{
				answerdb = resultSet.getString("answer");

				
				if(ans.equals(answerdb)) {
					String sql = "insert into mcq_correct(username,question_id) values (?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1,l.getusername());
					ps.setString(2,queno);
					ps.executeUpdate();
					
					return "SUCCESS";
					
				}
				else {
					
					hint = resultSet.getString("hint");
					l.sethint(hint);
					
					return "The answer is incorrect. Try again with a hint.";
				}
			}
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
		
		

	}
	
}
