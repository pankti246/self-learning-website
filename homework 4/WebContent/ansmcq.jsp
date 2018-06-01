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
</script>
<body>
<% if(session.getAttribute("username")==null){
 response.sendRedirect("Login.jsp");
}

%>
<h2> Multiple Choice Question</h2>
 <h3> Question:<%=request.getAttribute("queno")%> <%=request.getAttribute("quedb")%> </h3>
 
 
 <form name="anssubmit" method="post" action="mcqsubmitservlet">
 <p><input type="radio" id="radio" name="options" value="A" checked><%=request.getAttribute("Adb") %> </p>
  <p> <input type="radio" id="radio" name="options" value="B"><%=request.getAttribute("Bdb") %></p>
  <p><input type="radio" id="radio" name="options" value="C"> <%=request.getAttribute("Cdb") %></p>
  <p> <input type="radio" id="radio" name="options" value="D"><%=request.getAttribute("Ddb") %></p></h3>
  <input type="submit" value="Submit">
  <input type="hidden" value="<%=request.getAttribute("queno")%>" name="hidden">
  <input type="hidden" value="<%=request.getAttribute("quedb")%>" name="hidden1">
   <input type="hidden" value="<%=request.getAttribute("Adb")%>" name="hidden2">
   <input type="hidden" value="<%=request.getAttribute("Bdb")%>" name="hidden3">
   <input type="hidden" value="<%=request.getAttribute("Cdb")%>" name="hidden4">
   <input type="hidden" value="<%=request.getAttribute("Ddb")%>" name="hidden5">
     
   
   
 
 </form>
  <h2 style="color:blue">Hint:<%= (request.getAttribute("hint") == null) ? ""
			 : request.getAttribute("hint")  %> </h2>
	
<br>
<h2 style="color:red"><%= (request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")  %> </h2>
	
 <h3><a href="Home.jsp">Go back to home page</a></h3>
 
</body>
</html>