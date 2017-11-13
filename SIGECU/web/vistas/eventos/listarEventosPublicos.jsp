<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
﻿<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Eventos publicos</title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <!--<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">-->
    <link rel="stylesheet" href="../../fonts/material-design-icons-master/material-icons.css">

    <!-- Bootstrap Core Css -->
    <link href="../../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="../../plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="../../plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="../../css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="../../css/themes/all-themes.css" rel="stylesheet" />
</head>

<body class="theme-red">
   <jsp:include page="menu1.jsp" flush="true" />
    <section class="content">
        <div class="container-fluid">
            <div class="block-header">
                <h2>Eventos publicos</h2>
            </div>
                          

            <div class="row clearfix">
                <c:forEach var="data" items="${listarPublicos}">
                    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <div class="card">
                            <div class="header">
                                <h2>
                                    ${data.nombre}
                                    <small>Fecha: ${data.fecha}</small>
                                </h2>
                            </div>
                            <div class="body">
                                <label data-toggle="modal" data-target="#largeModal${data.id}">Ver mas...</label>
                            </div>
                        </div>
                    </div>
                            
                    <div class="modal fade" id="largeModal${data.id}" tabindex="-1" role="dialog">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <blockquote class="m-b-25">
                                        <h3>${data.nombre}</h3>
                                        <h4>${data.fecha}</h4>
                                    </blockquote>
                                </div>
                                <div class="modal-body">
                                    <p>
                                        <b>Descripcion: </b>
                                        ${data.descripcion}
                                    </p>
                                    <p>
                                        <b>Programa: </b>
                                        ${data.programa}
                                    </p>
                                    <p>
                                        <b>Instructor: </b>
                                        ${data.instructor.nombre}
                                    </p>
                                    <p>
                                        <b>Lugar: </b>
                                        ${data.lugar}
                                    </p>
                                    <p>
                                        <b>Ciudad: </b>
                                        ${data.ciudad}
                                    </p>
                                    <p>
                                        <b>Precios: </b>
                                        ${data.costo}
                                    </p>  
                                    <p>
                                        <b>Promocion: </b>
                                        ${data.promocion}
                                    </p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>
               </c:forEach>

                <div class="block-header">
                    <h2>${msj.mensaje}</h2>
                </div>
            </div>
                 
        </div>
    </section>
                

    <!-- Jquery Core Js -->
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
</body>

</html>