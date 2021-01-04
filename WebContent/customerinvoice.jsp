<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CUSTOMER INVOICE</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>CUSTOMER INVOICE</h2>  
    <form method="post" action="listinvoices">
    
                    <c:choose>
                        <c:when test="${edit}">
                            CUSTOMER NAME:<input type="text" name="customername" id="customername"><br>
                            FROM DATE:<input type="text" name="fromdate" id="fromdate"><br>
                            TO DATE:<input type="text" name="todate" id="todate"><br>
                            <input type="submit" value="Get Invoice Report">
                        </c:when>
                        <c:otherwise>
        <p>INVOICES OF ${customername} FROM ${fromdate} TO ${todate} </p> 
                            <table>
    
        <tr>
            <td>INVOICE NO</td><td>DATE</td>
        </tr>
        <c:forEach items="${list}" var="inv_master">
            <tr>
            
            <td>${inv_master.inv_no}</td>
            <td>${inv_master.inv_date}</td>
            
            </tr>
        </c:forEach>
    </table>
                        </c:otherwise>
                    </c:choose>
                
    
    
    </form>
    <br/>
    
 
</body>
</html>