package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.util.Base64;

import bean.ansquebean;

public class ansquedao {
	public String authenticateUser(ansquebean a)
	{
		String ansque = a.getansque();
		String queno = a.getqueno();
		java.sql.Connection con = null;
		java.sql.Statement statement = null;
		java.sql.ResultSet resultSet = null;
		
		String quedb = null;
		String Adb = null;
		String Bdb = null;
		String Cdb = null;
		String Ddb = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from "+ansque+"_questions where que_id="+queno+"");
			
			if(ansque.equals("numerical")) {
				while(resultSet.next())
				{
					System.out.println("num");
					quedb = resultSet.getString("question");
					a.setquedb(quedb);
					return "SUCCESS";
					
				}
			}
			else{
				while(resultSet.next())
				{
					quedb = resultSet.getString("question");
					Adb = resultSet.getString("A");
					Bdb = resultSet.getString("B");
					Cdb = resultSet.getString("C");
					Ddb = resultSet.getString("D");
					a.setquedb(quedb);
					a.setAdb(Adb);
					a.setBdb(Bdb);
					a.setCdb(Cdb);
					a.setDdb(Ddb);
					return "SUCCESS";
					
					
				}
			}
		
	
}

		catch(Exception e) {
			e.printStackTrace();
		}
		return "Sorry";
	}
}
			
			
			



	

