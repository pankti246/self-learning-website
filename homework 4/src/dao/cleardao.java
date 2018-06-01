package dao;

import java.sql.DriverManager;
import java.sql.Statement;

import bean.clearbean;
import bean.mcqbean;

public class cleardao {
	public String storevalues(clearbean n) {
		String username = n.getusername();
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps = null;
		java.sql.PreparedStatement ps1 = null;

try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
			String sql = "delete from numerical_correct where username=?" ;
			String sql1 = "delete from mcq_correct where username=? ";
			ps=con.prepareStatement(sql);
			ps1=con.prepareStatement(sql1);

			ps.setString(1, username);
			ps.executeUpdate();
			ps1.setString(1, username);
			ps1.executeUpdate();
			return "SUCCESS";

}
catch(Exception e) {
	e.printStackTrace();
	
}

	return "not cleared";
}
}