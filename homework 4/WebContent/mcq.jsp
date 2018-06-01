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
	var question = document.mcq.question.value;
	var hint = document.mcq.hint.value;
	var A = document.mcq.A.value;
	var B = document.mcq.B.value;

	var C = document.mcq.C.value;
	var D = document.mcq.D.value;


	
	var answer = document.mcq.answer.value;


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
	else if (A=="")
	{
		alert("Please enter option A ");
		return false;
	}
	else if (B=="")
	{
		alert("Please enter option B ");
		return false;
	}else if (C=="")
	{
		alert("Please enter option C ");
		return false;
	}else if (D=="")
	{
		alert("Please enter option D ");
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

<h2> Create a multiple choice question</h2>
<form name="mcq" action="mcqservlet" method="post" onsubmit="return validation()">
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
Choices of answer:
</td>
<td>
</td>
<tr>
<td> A</td>
<td> <textarea rows="5" cols="50" maxlength="250" name="A" placeholder="Enter option A">
</textarea>
</td>
</tr>

<tr>
<td> B</td>
<td> <textarea rows="5" cols="50" maxlength="250" name="B" placeholder="Enter option B">
</textarea>
</td>
</tr>

<tr>
<td> C</td>
<td> <textarea rows="5" cols="50" maxlength="250" name="C" placeholder="Enter option C">
</textarea>
</td>
</tr>

<tr>
<td> D</td>
<td> <textarea rows="5" cols="50" maxlength="250" name="D" placeholder="Enter option D">
</textarea>
</td>
</tr>


<tr>
<td>
Correct Answer:
	</td>
	<td>
<input type="text" name="answer" placeholder="Enter answer A,B,C or D">

	</td>
	</tr>
	</table>
	<input type="submit" value="submit">
	 

</form>
<h2 style="color:red"><%= (request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")  %> </h2>
	
	
	<h3><a href="Home.jsp">Go back to Home Page</a></h3>
</body>
</html>