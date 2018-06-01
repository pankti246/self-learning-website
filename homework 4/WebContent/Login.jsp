<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login | Homework4</title>
<script> 
function validation()
{
	var username = document.login.username.value;
	var password = document.login.password.value;
	if (username=="" && password=="")
		{
			alert("Please enter username and password");
			return false;
			
		}
	else if (username=="")
		{
			alert("Please enter username");
			return false;
		}
	else if (password=="")
		{
			alert("Please enter password");
			return false;
		}
	


	}
</script>
</head>
<body>



<%
if(session.getAttribute("username")!=null)
{
 	response.sendRedirect("Home.jsp");
}
%>
 
 
<a href="Register.jsp"> Click here to register </a>
<h2> Login </h2>
	<form name="login" action ="loginservlet" method="post" onsubmit="return validation()">
	Username: <br>
	<input type="text" name="username" placeholder="Enter username"><br>
	Password: <br>
	<input type="password" name="password" placeholder="Enter password"><br>
	<input type="submit" value="submit">
	</form>
	
	<h2 style="color:red"><%= (request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")  %> </h2>
			<%--  <%
if(session.getAttribute("username")==null)
{
 	response.sendRedirect("Login.jsp");
}
%> --%>
			 
			 
</body>
</html>