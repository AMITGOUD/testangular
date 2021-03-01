<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="bean.UserBean"%>
<%@page import="util.*"%>
<jsp:useBean id="bean" class="bean.UserBean" scope="request"></jsp:useBean>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="Header.jsp"%>
	<br>
	<br>
	<br>
	<% UserBean bean1=(UserBean)request.getAttribute("bean");
		String error = (String) request.getAttribute("error");
		if (error != null) {
	%>
	<h3 align="center">
		<%
			out.print(request.getAttribute("error"));
		%>
	</h3>

	<%
		}
	%>
	<form action="LoginCtl" method="post">

		<table align="center">
			<th align="center">Login here</th>

			<tr>
				<td><label for="email">user id*:</label></td>
				<td><input type="text" id="email" name="email"
					value="<%=DataUtility.getStringData(bean1.getUserId())%>"><font
					color="red"> <%=ServletUtility.getErrorMessage("email", request)%></font>
				</td>
			</tr>
			<tr>
				<td><label for="pass">Password*:</label></td>
				<td><input type="password" id="pass" name="pass"
					value="<%=DataUtility.getStringData(bean1.getPwd())%>"><font
					color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font></td>

			</tr>
			<tr>
				<td><input type="submit" value="Log_in"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
			<tr>
				<td><a href="Registration1.jsp">Signup here</a></td>
				<td><a href="ForgetPass.jsp">Forgot Password</a></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@include file="Footer.jsp"%>
</body>
</html>