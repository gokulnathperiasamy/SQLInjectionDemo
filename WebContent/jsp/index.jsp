<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL Injection Demo</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/servlets/LoginServlet" method="post">
		<center>
			<h2>Login Page</h2>
			<br /> <br /> 
			User Name: <input type="text" name="username" value="" id="username" /> <br /> <br /> 
			Password : <input type="text" name="password" value="" id="password" /> <br /> <br /> 
			<input type="submit" value="Submit">
		</center>
	</form>
</body>

</html>