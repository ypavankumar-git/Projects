<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Stores</title>
 
<style>
 
    body{
       background-color:#85827f;
    }
    section{
        display:grid;
        width:300px;
        background-color:#c6c5c3;
        justify-content:center;
        align-content:center;
    }
</style>
 
</head>
 
<body>
 <center>
<section>
 
    <h2>LOGIN HERE</h2>
  
    <form:form  method="GET" commandName="user" action="processlogin">
        
        <table>
            <tr>
                <td><label for="uname">Username: </label> </td>
                <td><form:input path="uname" id="uname"/></td>
                <td><form:errors path="uname" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="upass">Password: </label> </td>
                <td><form:input path="upass" id="upass"/></td>
                <td><form:errors path="upass" cssClass="error"/></td>
            </tr>
            
            <tr>
            <td>
                 <input  type="submit" value="LOGIN"/>
            </td>
            </tr>
     
            
        </table>
    </form:form>
    </div>
    <br/>
    <br/>
    
   </section>
   </center>
</body>
</html>