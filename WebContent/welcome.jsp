<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome..Mr...:<%=request.getAttribute("uname") %></h1>
		<h1>Welcome to Spring MVC.....................CODA 2020 Nov Batch...</h1>
		
		<h1><%=request.getAttribute("mykey") %></h1>
		<h1><%=session.getAttribute("hello") %></h1>
</body>
</html>