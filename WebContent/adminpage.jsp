<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
  
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin page</title>
    <h>SUCCESFULLY LOGGED IN AS ADMIN</h><br>
    <a href="<c:url value='/adduser'  />">Add User</a><br>
    <a href="<c:url value='/additem'  />">Add Item</a><br>
    <a href="<c:url value='/list' />">Go Shopping</a><br>
    <a href="<c:url value='/reports' />">Get Reports</a><br>
    
</body>
</html>