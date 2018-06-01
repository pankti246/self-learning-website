<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script> 
function validation()
{
	var question = document.numque.question.value;
	var hint = document.numque.hint.value;
	var answer = document.numque.answer.value;


	if (question=="")
		{
			alert("Please enter question");
			return false;
		}
	else if (hint=="")
		{
			alert("Please enter hint");
			return false;
		}
	else if (answer=="")
	{
		alert("Please enter answer");
		return false;
	}



	}
</script>

</head>
<body>

<% if(session.getAttribute("username")==null){
 response.sendRedirect("Login.jsp");
}%>


<h2> Create a numerical question</h2>
<form name="numque" action="numqueservlet" method="post" onsubmit="return validation()">
<table>
<tr>
<td>
Question Description: 
</td>
<td>
<textarea rows="5" cols="50" maxlength="250" name="question" placeholder="Enter question">
</textarea>
</td>
</tr>
<tr>
<td>
Hint:
	</td>
	<td> 
<textarea rows="5" cols="50" maxlength="250" name="hint" placeholder="Enter hint">
</textarea>
</td>
<tr>
<td>
Answer:
	</td>
	<td>
<input type="text" name="answer" placeholder="Enter answer">

	</td>
	</tr>
	</table>
	<input type="submit" value="submit">
	 

</form>
<h2 style="color:red"><%= (request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")  %> </h2>
	
	
<h2><a href="Home.jsp">Go back to Home Page</a></h2>	
</body>
</html>