<%-- 
    Document   : login
    Created on : 20/11/2017, 12:18:09 AM
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
        <form name="login" action="j_security_check" method="POST">
            User: <br><input type="text" name="j_username"><br>
            Password:<br><input type="password" name="j_password"><br>
            <input type="submit" name="submit" value="acceder">
        </form>
    </body>
</html>
