<%-- 
    Document   : index.jsp
    Created on : 20/11/2017, 02:58:00 PM
    Author     : zoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>${pageContext.request.userPrincipal.name}</h2>
        
    </body>
</html>
