package dao;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
	final static String username = "nayanakpatel74@gmail.com";
	final static String password = "9909103830";
	final static String adminEmail = "separkingadm@gmail.com";

	public static void send(String email, String data) {
		// TODO Auto-generated method stub
		System.out.println("helooooo");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("panktipatel246@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("You are signed up for the application...");
			String dataarray[] = data.split(",");
			//message.setContent("<h1> Message: " + data + "</h1>", "text/html");

			System.out.println(dataarray);
			message.setContent("Dear " + dataarray[0] + "," + "<br/>You have registered " + dataarray[1]
					+ " has been recieved and confirmed at <br/> <b>Albany: <b>" + dataarray[2]
					+ "<br/><b>In Time:</b> " + dataarray[3] + "<br/><b>Out Time:</b>" + dataarray[5]
					+ " <br/><br/><br/><br/>Please Scan the code at the gate: <br/><img alt='' src='https://chart.googleapis.com/chart?cht=qr&chl="
					+ "&chs=150x150&chld=L|0 '>", "text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
