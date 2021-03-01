<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>
<form action="Userctl" method="post">
<script>
function myFunction() {
  var x = document.getElementById("pass");
  if (x.type == "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>

<fieldset style="background-color:powderblue;">
    <legend style=""><h1>User Registration:</h1></legend>
    
<label for="fname">First name*:</label><br>
<input type="text" id="fname" name="fname" ><font color="red"><%
		String error1 = (String) request.getAttribute("error1");
		if (error1 != null) {
	
	
			out.print(request.getAttribute("error1"));



		}
	%></font><br>

<label for="Lname">Last name*:</label><br>
<input type="text" id="Lname" name="Lname"><font color="red"><%
		String error2 = (String) request.getAttribute("error2");
		if (error2 != null) {
	
	
			out.print(request.getAttribute("error2"));



		}
	%></font><br>

 <label for="dob">Date of Birth*:</label><br>
  <input type="date" id="dob" name="dob"><font color="red"><%
		String error7 = (String) request.getAttribute("error7");
		if (error7 != null) {
	
	
			out.print(request.getAttribute("error7"));



		}
	%></font><br>
  
  <label for="email">user id*:</label><br>
<input type="text" id="email" name="email"><font color="red"><%
		String error5 = (String) request.getAttribute("error5");
		if (error5 != null) {
	
	
			out.print(request.getAttribute("error5"));



		}
	%></font><br>

<label for="pass">Password*:</label><br>
<input type="password" id="pass" name="pass"><input type="checkbox" onclick="myFunction()">Show Password<font color="red"><%
		String error3 = (String) request.getAttribute("error3");
		if (error3 != null) {
	
	
			out.print(request.getAttribute("error3"));



		}
	%></font><br>


  
Select gender:
<input type="radio" id="male" name="gender" value="male">
  <label for="male">Male</label>
  <input type="radio" id="female" name="gender" value="female">
  <label for="female">Female</label>
  <input type="radio" id="other" name="gender" value="other">
  <label for="other">Other</label><br><font color="red"><%
		String error4 = (String) request.getAttribute("error4");
		if (error4 != null) {
	
	
			out.print(request.getAttribute("error4"));



		}
	%></font><br>
  
  <label for="marital">Marital Status:</label><br>
  <select id="marital" name="marital" >
  <option value="married">married</option>
  <option value="unmarried">un-married</option>
  </select><font color="red"><%
		String error6 = (String) request.getAttribute("error6");
		if (error6 != null) {
	
	
			out.print(request.getAttribute("error6"));



		}
	%></font><br><br>

<label for="cars">Language Known:</label><br>
  <select id="Language" name="Language"  size="4" multiple="multiple">
    <option value="hindi">hindi</option>
    <option value="english">English</option>
    <option value="marathi">Marathi</option>
    <option value="french">french</option>
  </select><br><font color="red"><%
		String error8 = (String) request.getAttribute("error8");
		if (error8 != null) {
	
	
			out.print(request.getAttribute("error8"));



		}
	%></font><br>
  
  <label for="message">Tell More about your self:</label><br>
 <textarea name="message" id="message" rows="3" cols="15" value="122">
 hi this is amit
</textarea>
<input type="submit" value="submit"> <input type="reset" value="reset">
</fieldset>
</form>
</body>
<%@include file="Footer.jsp" %>
</html>