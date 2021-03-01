<%@page import="bean.Photo_dateBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="bean.Photo_dateBean" %> 
  <%@page import="model.Photo_dateModel" %> 
  <%@page import="java.util.*" %> 
    <%
    Photo_dateBean bean=new Photo_dateBean();
    Photo_dateModel model=new Photo_dateModel();
    ArrayList l=(ArrayList)model.getList();
    
    Iterator it=l.iterator();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="form-1">
	
	
	<table align="center" border="1">
	<%while(it.hasNext()){
	bean=(Photo_dateBean)it.next();
	
	%>    <tr><th></th><th><%out.print(bean.getPhoto()); %></th></tr>
		<tr><td>image</td><td><img id="image-1" alt="" src="E:\\JAVA SOFTWARE\\apache-tomcat-9.0.40\\webapps\\<%=bean.getPhoto()%>.jpg" width="100" height="100"/></td></tr>
		
		
	<% } %>
	
	
	</table>
	</form>
</body>
</html>