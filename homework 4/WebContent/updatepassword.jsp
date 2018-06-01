<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validation()
{
	var password = document.update.password.value;
	var newpassword = document.update.newpassword.value;
	var confirmnewpassword = document.update.confirmnewpassword.value;


	if(password == ""){
		alert("Enter current password");
		return false;
	}
	else if(newpassword == ""){
		alert("Enter new password");
		return false;
	}
	else if(confirmnewpassword == ""){
		alert("confirm new password");
		return false;
	}
	else if(newpassword != confirmnewpassword){
		alert("passwords do not match");
	}
	
	}
</script>
<body>


<% if(session.getAttribute("username")==null){
 response.sendRedirect("Login.jsp");
}%>

<h2>Update Password!!</h2>

<form name="update" method="post" action="updateservlet" onsubmit= "return validation()">
Current password:<input type="password" name="password" placeholder="Enter your current password"><br><br>
New password:<input type="password" name="newpassword" placeholder="Enter new password"><br><br>
Confirm new password:<input type="password" name="confirmnewpassword" placeholder="Confirm password"><br><br>
<input type="submit" value="Submit">



</form>
<h3><a href="Home.jsp">Go to Home Page</a></h3>

</body>
</html>