package dao;
import java.sql.DriverManager;
import bean.mcqbean;
import bean.numquebean;


public class mcqdao {
	public String storevalues(mcqbean n) {
		String question = n.getquestion();
		String hint = n.gethint();
		String A = n.getA();
		String B = n.getB();
		String C = n.getC();
		String D = n.getD();

		String answer = n.getanswer();
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps = null;
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
			String sql = "insert into mcq_questions(question,hint,A,B,C,D,answer) values (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,question);
			ps.setString(2, hint);
			ps.setString(3, A);
			ps.setString(4, B);

			ps.setString(5, C);

			ps.setString(6, D);


			ps.setString(7, answer);
			
			int i = ps.executeUpdate();
			if(i!=0) 
				return "SUCCESS";
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return "Question not submitted";
	}
	
}

