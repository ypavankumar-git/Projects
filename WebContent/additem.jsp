<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
  
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Admin page</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Add Item</h2>
  
    
    <form:form method="POST" modelAttribute="item" action="additem">
        
        <table>
            <tr>
                <td><label for="item_name">ItemName: </label> </td>
                <td><form:input path="item_name" id="item_name"/></td>
                <td><form:errors path="item_name" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="unit">Unit: </label> </td>
                <td><form:input path="unit" id="unit"/></td>
                <td><form:errors path="unit" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="prize">Prize: </label> </td>
                <td><form:input path="prize" id="prize"/></td>
                <td><form:errors path="prize" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="category">Category: </label> </td>
                <td><form:input path="category" id="category"/></td>
                <td><form:errors path="category" cssClass="error"/></td>
            </tr>
       
            <tr>
                <td><label for="image">image: </label> </td>
                <td><form:input  path="image" id="image" accept="image/*"/></td>
                <td><form:errors path="image" cssClass="error"/></td>
            </tr>
            <tr>
            <td>
               
               <input type="submit" value="additem">
            </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    
    
</body>
</html>
