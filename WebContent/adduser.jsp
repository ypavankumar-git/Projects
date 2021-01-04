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
 
    <h2>Add User</h2>
  
    <form:form method="POST" modelAttribute="user" action="adduser">
        
        <table>
            <tr>
                <td><label for="uname">UserName: </label> </td>
                <td><form:input path="uname" id="uname"/></td>
                <td><form:errors path="uname" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="upass">PassWord: </label> </td>
                <td><form:input path="upass" id="upass"/></td>
                <td><form:errors path="upass" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for="power">Power: </label> </td>
                <td><form:input path="power" id="power"/></td>
                <td><form:errors path="power" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="location">Location: </label> </td>
                <td><form:input path="location" id="location"/></td>
                <td><form:errors path="location" cssClass="error"/></td>
            </tr>
             
            <tr>
            <td>
               
               <input type="submit" value="adduser">
            </td>
            </tr>
            
            
        </table>
    </form:form>
    
    <br/>
    <br/>
    
    
</body>
</html>
