<%-- 
    Document   : graficaCursos1
    Created on : 9/11/2017, 04:28:23 PM
    Author     : Dell
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
          <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Crear Evento</title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
    <!-- Google Fonts -->
    <!--<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">-->
    <link rel="stylesheet" href="../../fonts/material-design-icons-master/material-icons.css">

    <!-- Bootstrap Core Css -->
    <link href="../../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!--WaitMe Css-->
    <link href="../../plugins/waitme/waitMe.css" rel="stylesheet" />
    <!-- Waves Effect Css -->
    <link href="../../plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="../../plugins/animate-css/animate.css" rel="stylesheet" />
    <!-- Bootstrap Select Css -->
    <link href="../../plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />
 <link href="../../plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="../../css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="../../css/themes/all-themes.css" rel="stylesheet" />
    
   
    <!-- Demo Js -->
    </head>
    <body class="theme-red">
     <jsp:include page="menu1.jsp" flush="true" />

    <section class="content">
        <div class="container-fluid">
            
            <!-- Basic Example -->
            
            <!-- #END# Basic Example -->
            <!-- Rounded Corners -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <%
                        String color = "#000000";
                        int progreso = 20;     
                    %>
                    <c:forEach var="dash" items="${dashEvento}"> 
                        <c:if test ="${dash.progreso<50}">
                            <%=color="red"%>
                        </c:if>
                        
                        <c:if test ="${dash.progreso>=50 && dash.progreso<=75}">
                            <%=color="orage"%>
                        </c:if>
                        <c:if test ="${dash.progreso>75 && dash.progreso<=90}">
                            <%=color="yellow"%>
                        </c:if>
                        <c:if test ="${dash.progreso>90 && dash.progreso<=100}">
                            <%=color="green"%>
                        </c:if>
                        
                        <div class="card">
                        <div class="header">
                            <h2>${dash.nombre}</h2>
                            <p>Fecha programada: ${dash.fecha} al ${dash.fechaTermino}</p>
                           
                        </div>
                        <div class="body">
                            <div class="row clearfix">
                                <div class="col-md-2">
                                    <input type="text" class="knob" value="${dash.progreso}" data-linecap="round"  data-width="70 " data-height="70" data-thickness="0"
                                           data-fgColor="<%=color%>" >
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    
                                
                </div>
                <div>${msj.mensaje}</div>
            </div>
                               
            
            
           
           
            <!-- #END# Tron Style -->
        </div>
    </section>

    <script src="../../plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="../../plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->
    <script src="../../plugins/bootstrap-select/js/bootstrap-select.js"></script>


    <!-- Slimscroll Plugin Js -->
    <script src="../../plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="../../plugins/node-waves/waves.js"></script>

    <!-- Custom Js -->
    <script src="../../js/admin.js"></script>

    <!-- Demo Js -->
    <script src="../../js/demo.js"></script>


    <!-- Jquery Knob Plugin Js -->
    <script src="../../plugins/jquery-knob/jquery.knob.min.js"></script>

    
    <script src="../../js/pages/charts/jquery-knob.js"></script>

        
    </body>
</html>
