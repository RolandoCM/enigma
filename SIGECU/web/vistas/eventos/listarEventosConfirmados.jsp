<%-- 
    Document   : listarEventos
    Created on : 2/11/2017, 05:38:11 PM
    Author     : rolando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos</title>
    </head>
    <body>
        <h1>Listo</h1>

				 
         <table id="example" class="display table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th style="text-align: center"><u>Nombres</u></th>

                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="n" items="${listaEvento}">
                                    <tr>                                    
                                        <td style="text-align: center">${n.nombre}</td>                             
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                 ${msj.id}<br/>
				 ${msj.mensaje}<br/>		
                                 
                                 <div>${msj2}</div>
    </body>
</html>
