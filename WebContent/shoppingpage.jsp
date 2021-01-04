<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset="utf-8">
    <title>Shopping page</title>
 
    <style>
    body{
       background-color:#c6c5c3;
    }
       section{
          
          display:grid;
          justify-content: center;
          align-content: center;
          justify-content:space-evenly;
          grid-template-columns:200px 200px 200px;
          grid-auto-rows:200px; 
          grid-gap:10px;
          background-color:#c6c5c3;
          
          
        }
         div {
           background-color:#85827f;
           
           align-items: center;
           justify-items: center;
         }
         option1 {
         background-color: #ffffff;
         }
         option2 {
         background-color: #008080;
         }
         h1{
         background-color:#c6c5c3;
         color:black;
         }
    </style>
 
</head>
 
 
<body>
 <center>
    <form method="post" action="list">
    
        
        <section>
        
           <c:forEach items="${list}" var="item">
            
            <div id="option1" center>
            
             <h1> ${item.item_name} </h1>
             <h1> ₹${item.prize} </h1>
             <img src="${item.image}" width="80" height="80"/></br>  
             <script>
             
             var c=0;
             function change() {
                 if(c%2==0)
                     {
                	 var div = document.getElementById("option1");
                     div.setAttribute("id","option2");
                     }
                 else{
                	 var div = document.getElementById("option2");
                	 div.setAttribute("id","option1");
                     }
                 c=c+1;
             }
             </script>
            <input align="bottom" type="checkbox" onchange="change()" name="ids[]" id="ids[]" value="${item.item_no}" />
            
            </div>
           
           </c:forEach>
       </section>
        
      
     </br>
     <input align="center" type="submit" value="Go to cart"> 
    </form>
    <br/>
    
    
    
 <!--   <a href="<c:url value='/list' />">Add New Employee</a>    -->
 </center>   
</body>
</html>