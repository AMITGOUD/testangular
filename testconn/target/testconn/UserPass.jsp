<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>your password for login
<h1><%String pass=(String)request.getAttribute("pass");
		out.print(pass);
		%></h1>
		<br>
		<a href="Login.jsp">Login here</a>
</body>
</html>