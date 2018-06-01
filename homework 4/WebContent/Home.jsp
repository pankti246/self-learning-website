<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("username")==null){
/* 	getServletContext().getRequestDispatcher("/Login.jsp").include(request,response);
 */	
 response.sendRedirect("Login.jsp");
}
/* if(session.getAttribute("type").equals("Consumer"))
{
	response.sendRedirect("Home2.jsp");
}
 */
 %>
<h3>  <a href="numque.jsp"> Add numerical questions </a> </h3>
 <h3>  <a href="mcq.jsp"> Add multiple choice questions </a> </h3>
  <h3>  <a href="view.jsp"> View all questions</a> </h3>
 <h3><a href="editprofile.jsp">Edit Profile</a></h3>
  <h3><a href="updatepassword.jsp">Update Password</a></h3>
 

 
<%-- <h1>Welcome Supplier</h1>
<h2 style="color:blue"><%= (new java.util.Date()).toString()%></h2>
 --%>
 <a href="logout.jsp" style="background-color:white; border:1px;">Log Out</a>

</body>
</html>