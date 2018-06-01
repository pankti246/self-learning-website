<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validation(){
	var ans1 = document.anssubmit.ans.value;
	if(ans1 == ""){
		alert("Enter answer");
		return false;
	}
	
}
</script><body>

<% if(session.getAttribute("username")==null){
 response.sendRedirect("Login.jsp");
}%>


<h2> Numerical Question </h2>
 <h3>Question: <%=request.getAttribute("queno") %><p><%=request.getAttribute("quedb")%> </p> </h3>
 
 
 <form name="anssubmit" method="post" action="numsubmitservlet" onsubmit="return validation()">
 <p><input type="text" name="ans"> </p>
  <input type="submit" value="Submit">
  <input type="hidden" value="<%=request.getAttribute("queno")%>" name="hidden">
  <input type="hidden" value="<%=request.getAttribute("quedb")%>" name="hidden1">
 </form>
 
 <h2 style="color:blue">Hint:<%= (request.getAttribute("hint") == null) ? ""
			 : request.getAttribute("hint")  %> </h2>
	
<br>
<h2 style="color:red"><%= (request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")  %> </h2>
	
		<h3><a href="Home.jsp">Go back to Home Page</a></h3>
</body>
</html>