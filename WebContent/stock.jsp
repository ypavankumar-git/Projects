<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>STOCK AVAILABILITY</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>STOCK AVAILABILITY</h2>  
    <form method="post" action="">
    <table>
        <tr>
            <td>ITEM</td><td>CATEGORY</td><td>PRIZE</td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
            
            <td>${item.item_name}</td>
            <td>${item.category}</td>
            <td>${item.prize}</td>
            </tr>
        </c:forEach>
    </table>
    
    </form>
    <br/>
    
 
</body>
</html>