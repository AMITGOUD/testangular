<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="Header.jsp"%>
<html>
<head>
<script type="text/javascript">
	function validate(frm1) {
		var flag = true;
		if (frm1.rollNo.value == '' || frm1.rollNo.value == null) {

			document.getElementById("spanRoll").innerHTML = "rollno.requier";
			alert("rollno require");
			flag = false;
		}

		return flag;

	}
</script>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="background-color: powderblue;">
		<legend style="">
			<h1>Student_management</h1>
		</legend>
		<form method="" action="StudentMgtCtl.jsp" name="frm1"
			onsubmit="return validate(this)">

			<label for="rollNo">RollNo &nbsp&nbsp&nbsp&nbsp</label><br> <input
				type="text" id="rollNo" name="rollNo"><font color="red"><span
				id="spanRoll"></span></font><br> <label for="firstName">FirstName</label><br>
			<input type="text" id="firstName" name="firstName"><font
				color="red"><span id="spanfname"></span></font><br> <label
				for="lastName">LastName</label><br> <input type="text"
				id="lastName" name="lastName"><font color="red"><span
				id="spanlname"></span></font><br>
			<br> <label for="mobileNo">mobileNo</label><br> <input
				type="text" id="mobileNo" name="mobileNo"><br>
			<br> <label for="mobileNo">upload your photo</label><font
				color="red"><span id="spanMobile"></span></font><br> <input
				type="file" name="fileToUpload" id="fileToUpload"><font
				color="red"><span id="spanFile"></span></font><br> <input
				type="submit" name="operation" value="add" onclick="validate()">&nbsp&nbsp
			<input type="submit" name="operation" value="modify"
				onclick="validate()">&nbsp&nbsp <input type="submit"
				name="operation" value="delete" onclick="validate()">&nbsp&nbsp
			<input type="submit" name="operation" value="StudentList">&nbsp&nbsp

		</form>
	</fieldset>
	<%@include file="Footer.jsp"%>
</body>
</html>