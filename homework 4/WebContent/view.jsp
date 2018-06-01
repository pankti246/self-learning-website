<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
td{
	vertical-align: top;
	text-align: left;
}
</style>

<script> 
function validation()
{
	var queno = document.ansques.queno.value;
	if (queno=="")
		{
			alert("Please select question number");
			return false;
			
		}
}
</script>
<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
</head>
<body>
<%
String username =(String) session.getAttribute("username");


if(session.getAttribute("username")==null){
 	response.sendRedirect("Login.jsp");
	
}
%>
<sql:setDataSource
	var="ds"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/icsi518_hw4"
	user= "icsi518"
	password= "secretICSI518"
	/>
	<sql:query var="viewnumques" dataSource="${ds}">
	SELECT * FROM `numerical_questions`;
	</sql:query>
	
	<sql:query var="viewmcqques" dataSource="${ds}">
	SELECT * FROM `mcq_questions`;
	</sql:query>
	
	<sql:query var="correctmcqques" dataSource="${ds}">
	SELECT * FROM `mcq_correct`;
	</sql:query>
	
	
	<form name="ansques" action="ansquesservlet" method="post" onsubmit="return validation()">
	<h4>Select the type of question you want to answer:
	<select name="ansque">
		<option value="numerical"> Numerical Questions </option>
		<option value="mcq"> Multiple Choice Questions </option>
	</select>
	</h4>
	<h4>Select the question number you want to answer:
	<input type="text" name="queno" placeholder="Enter question number"></h4>
	
	<input type="submit" value="Submit">
	</form>
	
	<h2> Numerical Questions</h2>
<table>
	<c:forEach var="numque" items="${viewnumques.rows}">
	<c:set var="num_correct" value="${numque.que_id}"/>
	<%
	String num_correct = (String) pageContext.getAttribute("num_correct").toString();
	%>
	
	<tr>
	<td>
	
<%Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from numerical_correct where username='"+username+"' and question_no='"+num_correct+"'");
if(rs.next()){
%>
<i class="fas fa-check" style="color:green"></i>


<%}
else{ %>

<%} %>		





	</td>
	
	<td>
	
	<c:out value="${numque.que_id}">
	</c:out>)
	</td>
	
	<td>
	<c:out value="${numque.question}">
	</c:out>
	<br>
	</td>
	</tr>
	</c:forEach>
</table>
<h2>Multiple Choice Questions</h2>
<table>
	<c:forEach var="mcqque" items="${viewmcqques.rows}">
	
	<c:set var="mcq_correct" value="${mcqque.que_id}"/>
	<%
	String mcq_correct = (String) pageContext.getAttribute("mcq_correct").toString();
	%>
	
	<tr>
	<td>
	<%
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/icsi518_hw4", "icsi518", "secretICSI518");

	Statement st1 = con.createStatement();
ResultSet rs1 = st1.executeQuery("select * from mcq_correct where username='"+username+"' and question_id='"+mcq_correct+"'");
if(rs1.next()){
%>
<i class="fas fa-check" style="color:green"></i>


<%}
else{ %>

<%} %>		

	
	
	</td>
	<td>
	<c:out value="${mcqque.que_id}">
	</c:out>)
	</td>
	<td>
	<c:out value="${mcqque.question}">
	</c:out>
	
	<br>
	(A)
	<c:out value="${mcqque.A}">
	</c:out>
	<br>
	(B)
	<c:out value="${mcqque.B}">
	</c:out>
	<br>
	(C)
	<c:out value="${mcqque.C}">
	</c:out>
	<br>
	(D)
	<c:out value="${mcqque.D}">
	</c:out>
	<br>
	</td>
	</tr>
	</c:forEach>
</table>
<br/> <br/>
<h3><a href="createservlet" >Clear History</a></h3>


<h3><a href="Home.jsp">Go to Home Page</a></h3>

<h3><a href="logout.jsp">Logout</a></h3>
</body>
</html>