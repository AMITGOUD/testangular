<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Header.jsp" %>
<br><br><br><br><br><br><br><br>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="ForgetPassCtl">
<label for="UserId">user id*:</label>
<input type="text" id="UserId" name="UserId">
<input type="submit" value="submit">
<br>
<font color="red">
"<%

String msg="your password is=";
String pass=(String)request.getAttribute("pass");
if(pass!=null){out.print(msg+pass);
}


%>"

</font>&nbsp 
</form>
</body><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="Footer.jsp" %>
</html>