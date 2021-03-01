<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp"%>
<a href="Profile.jsp">edit_profile</a>
<hr>
<% String msg=(String)request.getParameter("msg1");
if(msg!=null){
	out.print(msg);
}
%>
 <h1>Welcome user</h1>
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="Footer.jsp"%> 
</body>
</html>