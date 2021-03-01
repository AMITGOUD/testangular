<%@page import="javax.imageio.stream.FileImageInputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bean.*"%>
<%@page import="model.*"%>
<%@page import="util.*"%>
<%@page import="java.util.*"%>
<%@include file="Header.jsp"%>
<%@page import="java.io.*" %>
<%@page import="javax.imageio.ImageIO" %>
<%@page import="java.awt.image.BufferedImage" %>

<!DOCTYPE html>
<jsp:useBean id="Std" scope="page" class="bean.StudentBean" />
<jsp:setProperty name="Std" property="*" />



<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String op = request.getParameter("operation");

		if (op.equals("add")) {
			int i = 0;
			try {
				i = StudentModel.add(Std);
				if (i == 1) {
					out.print("Student added successfully");

				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		} else if (op.equals("modify")) {
			int j = 0;
			try {
				j = StudentModel.update(Std);
				if (j == 1) {
					out.print("Student modify successfully");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (op.equals("delete")) {
			int k = 0;
			try {
				k = StudentModel.delete(Std);
				if (k == 1) {
					out.print("Student delete successfully");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (op.equals("StudentList")) {
			ArrayList list = new ArrayList();
			try {
				int s=1;

				list = (ArrayList) StudentModel.getList();
				
				Iterator it = list.iterator();
	%>
	<h2 align="center">List of Student</h2>
	<form action="">
	<table border="1" align="center">

		<tr>
            <th align="center"><font color="red">S.no</font></th>
			<th align="center"><font color="red">RollNo</font></th>
			<th align="center"><font color="red">FirstName</font></th>
			<th align="center"><font color="red">LastName</font></th>
			<th align="center"><font color="red">MobileNo</font></th>
			<th align="center"><font color="red">image</font></th>
		</tr>
		<%int k=0;
			while(it.hasNext()) {
				Std=(StudentBean)it.next();
			ByteArrayInputStream br=(ByteArrayInputStream)Std.getBinaryStream();
			 StringBuffer img = new StringBuffer("E:\\sign");
			 k++;
			 img.append(k+".jpg");
			FileOutputStream writer=new FileOutputStream(img.toString());
			
			int ch=br.read();
			while(ch!=-1){
				
				writer.write(ch);
				ch=br.read();
			}
			writer.close();
			br.close();
			
				
		%>

		 <tr> <td align="center"><%=s%></td>
			<td align="center"><%out.print(Std.getRollNo());%></td>
			<td align="center"><%out.print(Std.getFirstName());%></td>
			<td align="center"><%out.print(Std.getLastName());%></td>
			<td align="center"><%out.print(Std.getMobileNo());%></td>
			<td align="center"><img alt="" src="E:\\sign<%=k%>.jpg" height="80" width="80"></td>
		</tr>
		
		<%
		s++;}
		%>

</table>
	</form>

		<%
			} catch (Exception e) {
					e.printStackTrace();
				}
			}
		%>
	
	<a href="StudentView.jsp">Student home</a>
</body>
</html>
<%@include file="Footer.jsp"%>
