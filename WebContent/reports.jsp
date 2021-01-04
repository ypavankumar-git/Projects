<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <center>
        <a href="<c:url value='/listusers' />">GET AVAILABLE CUSTOMERS LIST</a><br>
        <a href="<c:url value='/listitems' />">GET STOCK REPORT</a><br>
        <a href="<c:url value='/listinvoices' />">GET CUSTOMER INVOICE REPORT</a><br>
        </center>
</body>
</html>