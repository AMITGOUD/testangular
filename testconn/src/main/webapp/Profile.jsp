<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="bean.UserBean" %>
<%@ page import="model.UserModel" %>
<%@include file="Header.jsp" %>
<html>
<% String Fname=(String)session.getAttribute("Fname"); 
String Lname=(String)session.getAttribute("Lname");
String Gender=(String)session.getAttribute("Gender");
String Dob=(String)session.getAttribute("Dob");
UserModel m=new UserModel();
  

%>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="ProfileCtl">
<label for="fname">First name*:</label><br>
<input type="text" id="fname" name="fname" value="<%=Fname%>"><br>

<label for="lname">Last name*:</label><br>
<input type="text" id="lname" name="lname" value="<%=Lname%>"><br>

 <label for="dob">Date of Birth*:</label><br>
  <input type="text" id="dob" name="dob" value="<%=Dob%>"><br>
  
  <label for="gender">Gender*:</label><br>
  <input type="text" name="gender" id="gender" value="<%=Gender%>">
  <input type="submit" value="submit">
</form>

</body>
<%@include file="Footer.jsp" %>
</html>