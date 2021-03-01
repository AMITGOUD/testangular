<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Photo_date" style="color: blue" method="post"><br><br><br><br><br><br>
     <table border="1" align="center" style="background-color: skybue" height="200">
     <tr><th align="center" colspan="2">Enter detail</th></tr>
	<tr><td><label for="photo">photo</label></td><td><input type="file" name="photo" id="photo"></td><br></tr>
	<tr><td><label for="sdate"> date_Birth</label></td><td><input type="text" name="sdate" id="sdate"></td></tr>
    <tr><td colspan="2"><input type="submit" value="submit"></td></tr>
    <a href="List_phot_date.jsp">photo list</a>
</table>



</form>

</body>
</html>