<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<%@ page import="bean.UserBean" %>
</head>
<body>
<hr><br>
<img alt="" src="customLogo.jpeg" width="100" height="90" align="top">
<h1 align="center"><font color="blue">Sunrays technology</font></h1>
<%
   String u = (String) session.getAttribute("Fname");

    

    String welcomeMsg = "Hi, ";

    if (u!=null) {
        out.print(welcomeMsg+u);
    } else {
    	out.print(welcomeMsg += "Guest");
    }
%>

||<a href="Logout.jsp">Logout</a>||<a href="StudentView.jsp">Stuent_management</a>
<br>
<hr>
</body>
</html>