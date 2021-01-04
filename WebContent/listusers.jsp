<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Shopping page</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>Available Users</h2>  
    <form method="post" action="">
    <table>
        <tr>
            <td>USERNAME</td><td>POWER</td><td>LOCATION</td>
        </tr>
        <c:forEach items="${list}" var="user">
            <tr>
            
            <td>${user.uname}</td>
            <td>${user.power}</td>
            <td>${user.location}</td>
            </tr>
        </c:forEach>
    </table>
    
    </form>
    <br/>
    
 
</body>
</html>