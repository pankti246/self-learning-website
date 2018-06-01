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
	var password = document.editprofile.password.value;
	if(password == ""){
		alert("Enter current password");
		return false;
	}
	var firstname = document.editprofile.firstname.value;
	if(firstname == ""){
		alert("Enter first name");
		return false;
	}
	var lastname = document.editprofile.lastname.value;
	if(lastname == ""){
		alert("Enter last name");
		return false;
	}
	
	
	}
</script>
<body>


<% if(session.getAttribute("username")==null){
 response.sendRedirect("Login.jsp");
}%>

<h2>Edit Profile!!</h2>

<form name="editprofile" method="post" action="editservlet" onsubmit= "return validation()">
Current password:<input type="password" name="password" placeholder="Enter your current password"><br><br>
First name:<input type="text" name="firstname" placeholder="Enter new first name"><br><br>
Last name:<input type="text" name="lastname" placeholder="Enter new last name"><br><br>
<input type="submit" value="Submit">



</form>
<h3><a href="Home.jsp">Go to Home Page</a></h3>

</body>
</html>