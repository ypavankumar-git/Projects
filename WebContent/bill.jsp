<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>INVOICE</h1></center>
<p>CUSTOMER NAME:${name}<br\></p>
<p>DATE:${date}<br\></p>
<center>
    
    <table border="1">
        <tr>
            <td>ITEM</td><td>CATEGORY</td><TD>PRIZE<td>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
            <td>${item.item_name}</td>
            <td>${item.category}</td>
            <td>${item.prize}</td>
            </tr>
        </c:forEach>
            <tr>
            <td></td><td>TOTAL COST::</td><td>${totalcost}</td>
            </tr>
      </table>
      <form method="GET"  action="logout">
      <input type="submit" value="logout" >
      </form>
</center>
</body>
</html>