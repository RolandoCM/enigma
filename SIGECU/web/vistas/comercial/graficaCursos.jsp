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
    <title>Grafica Cursos</title>
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
                    <%
                        String color = "000000";
                        int progreso = 0;     
                    %>
                    <c:forEach var="dash" items="${dashEvento}"> 
                        <c:if test ="${dash.progreso<50}">  
                            
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="card">
                                    <div class="header">
                                        <h2>${dash.nombre}</h2>
                                        <p>Fecha programada: ${dash.fecha} al ${dash.fechaTermino}</p>
                                    </div>
                                    <div class="body">
                                        <div class="row clearfix">
                                            <div class="col-xs-6">
                                                <input class="knob" value="${dash.progreso}" data-width="100" data-height="100" data-thickness="0.20" data-fgcolor="<%=color="red"%>" data-skin="tron" readonly="readonly" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px none; font: normal normal bold normal 28px Arial; text-align: center; padding: 0px;" type="text">
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons">local_library</i>
                                                    <span class="icon-name">Alumnos Inscritos</span>
                                                    <h2>${dash.inscritos}</h2>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test ="${dash.progreso>=50 && dash.progreso<=75}">
                            
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="card">
                                    <div class="header">
                                        <h2>${dash.nombre}</h2>
                                        <p>Fecha programada: ${dash.fecha} al ${dash.fechaTermino}</p>
                                    </div>
                                    <div class="body">
                                        <div class="row clearfix">
                                            <div class="col-xs-6">
                                                <input class="knob" value="${dash.progreso}" data-width="100" data-height="100" data-thickness="0.20" data-fgcolor="<%=color="orange"%>" data-skin="tron" readonly="readonly" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px none; font: normal normal bold normal 28px Arial; text-align: center; padding: 0px;" type="text">
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons">local_library</i>
                                                    <span class="icon-name">Alumnos Inscritos</span>
                                                    <h2>${dash.inscritos}</h2>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test ="${dash.progreso>75 && dash.progreso<=90}">
                            
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="card">
                                    <div class="header">
                                        <h2>${dash.nombre}</h2>
                                        <p>Fecha programada: ${dash.fecha} al ${dash.fechaTermino}</p>
                                    </div>
                                    <div class="body">
                                        <div class="row clearfix">
                                            <div class="col-xs-6">
                                                <input class="knob" value="${dash.progreso}" data-width="100" data-height="100" data-thickness="0.20" data-fgcolor="<%=color="yellow"%>" data-skin="tron" readonly="readonly" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px none; font: normal normal bold normal 28px Arial; text-align: center; padding: 0px;" type="text">
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons">local_library</i>
                                                    <span class="icon-name">Alumnos Inscritos</span>
                                                    <h2>${dash.inscritos}</h2>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test ="${dash.progreso>90 && dash.progreso<=100}">
                            
                             <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="card">
                                    <div class="header">
                                        <h2>${dash.nombre}</h2>
                                        <p>Fecha programada: ${dash.fecha} al ${dash.fechaTermino}</p>
                                    </div>
                                    <div class="body">
                                        <div class="row clearfix">
                                            <div class="col-xs-6">
                                                <input class="knob" value="${dash.progreso}" data-width="100" data-height="100" data-thickness="0.20" data-fgcolor="<%=color="green"%>" data-skin="tron" readonly="readonly" style="width: 74px; height: 46px; position: absolute; vertical-align: middle; margin-top: 46px; margin-left: -107px; border: 0px none; font: normal normal bold normal 28px Arial; text-align: center; padding: 0px;" type="text">
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons">local_library</i>
                                                    <span class="icon-name">Alumnos Inscritos</span>
                                                    <h2>${dash.inscritos}</h2>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    
                    
                                    
                    </c:forEach>
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
