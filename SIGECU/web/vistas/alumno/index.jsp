<%-- 
    Document   : index.jsp
    Created on : 20/11/2017, 02:58:00 PM
    Author     : zoro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${!pageContext.request.userPrincipal.password}">
            <h1>${pageContext.request.userPrincipal.name}</h1>
        </c:if>

        
        
    </body>
</html>
