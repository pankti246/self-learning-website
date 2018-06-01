<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<script> 
	function validation(){
		var firstname = document.Register.firstname.value;
		var lastname = document.Register.lastname.value;
		var username = document.Register.username.value;
		var password = document.Register.password.value;
		var cpassword = document.Register.cpassword.value;
		if (firstname == "")
		{
			alert("Please enter firstname");
			return false;
		}
		if (lastname == "")
			{
				alert("Please enter lastname");
				return false;
			}
		if (username == "")
		{
			alert("Please enter username");
			return false;
		}if (password == "")
		{
			alert("Please enter password");
			return false;
		}
		if (cpassword == "")
		{
			alert("Please confirm your password");
			return false;
		}
		if (password != cpassword){
			alert("Password and confirm password do not match");
			return false;
		}
	}
</script>
<body>
<%
if(session.getAttribute("username")!=null)
{
	response.sendRedirect("Home.jsp");
}%>

 
 <h2> Registration Form</h2>
<a href="Login.jsp"> Click here to login</a>
<form name="Register" action="signupservlet" method="post" onsubmit="return validation()">
First Name: <br>
	<input type="text" name="firstname" placeholder="Enter your first name"> <br>
Last Name:<br>
	<input type="text" name="lastname" placeholder="Enter your last name"> <br>


Username: <br>
	<input type="text" name="username" placeholder="Enter username"><br>
Password: <br>
	<input type="password" name="password" placeholder="Enter password"><br>
Confirm password: <br>
	<input type="password" name="cpassword" placeholder="Enter password again"> <br>	<br>
<input type="submit" value="submit">
</form>
<h2 style="color:red"><%= (request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")  %> </h2>
</body>
</html>