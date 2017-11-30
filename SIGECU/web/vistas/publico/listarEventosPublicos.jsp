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
    <link rel="stylesheet" href="fonts/material-design-icons-master/material-icons.css">

    <!-- Bootstrap Core Css -->
    <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="css/themes/all-themes.css" rel="stylesheet" />
</head>

<body class="theme-red">

    <section class="content">
        <div class="container-fluid">
            <div class="block-header">
                <h2>Eventos publicos</h2>
                <a href="vistas/comercial/Eventos?accion=LEC">Comercial</a>
                <a href="vistas/alumno/listadoPagos.jsp">alumno</a>
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
                                
                                 <button data-toggle="modal" data-target="#ModalPreInscripcion${data.id}">Inscribirme</button>
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
                                        ${data.instructor.iNombre}
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
                                    
                    <div class="modal fade in" id="ModalPreInscripcion${data.id}" tabindex="-1" role="dialog" >
                        <div class="modal-dialog" role="document">
                           
                            
                            <div class="modal-content">
                                <div class="modal-header">
                                    <blockquote class="m-b-25">
                                        <h3>Pre-Inscripción al evento ${data.nombre}</h3>
                                        <h4>Fecha de Inicio ${data.fecha}</h4>
                                    </blockquote>
                                </div>
                                <div class="modal-body">
                                   
                                    <form style="margin-left: 30px" action="ServletPreInscripcionEvento" method="POST"  class="form-horizontal">
                                    <input type="hidden" name="accion" value="INS"/> 
                                    <input type="hidden" name="idEvento" value="${data.id}"/> 
                                    <div class="row clearfix">
                                        <div class="form-line">
                                            <h4>Estimado ${data.id} confirma Pre-Inscripción</h4>
                                        </div>
                                        <div class="form-group">
                                                <div class="form-line">Nombre del curso<br>
                                                    <input name="nombreEvento" value="${data.nombre}"class="form-control"required readonly/>
                                                </div>
                                        </div>
                                        <div class="form-group">
                                                <div class="form-line">Fecha de Inicio<br>
                                                    <input name="fechaInicio" value="${data.fecha}"class="form-control"required readonly/>
                                                </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-line">Monto a pagar<br>
                                                <input name="montoEvento" value="${data.costo}"class="form-control"required readonly/>
                                            </div>
                                        </div>
                                        <br>
                                        <p>Cuenta con Netbook</p>
                                        <div class="demo-radio-button">
                                            <input name="confirmar" type="radio" value="si" id="radio_1" class="with-gap radio-col-black" checked >
                                            <label for="radio_1">Si</label>
                                            <input name="confirmar" type="radio" value="no" id="radio_2" class="with-gap radio-col-black" >
                                            <label for="radio_2">No</label>
                                            <br><br>
                                        </div>
                                        <div class="modal-footer">
                                            <div class="col-xs-6 col-sm-3 col-md-2 col-lg-2">
                                                <button type="submit" class="btn bg-red btn-block btn-lg waves-effect">Enviar</button>
                                            </div>
                                            <div class="col-xs-6 col-sm-3 col-md-2 col-lg-2">
                                                <button type="button" class="btn bg-red btn-block btn-lg waves-effect" data-dismiss="modal">Cancelar</button>
                                            </div>
                                        </div>
                                    </div>              
                                    </form>
                                </div>        
                            </div>
                        </div>
                    </div>
               </c:forEach>
                
                

                <div class="block-header">
                    <h2>${msj.mensaje}</h2>
                </div>
                    <h1> <%request.getSession().getAttribute("nameuser");%> </h1>
            </div>
                 
        </div>
    </section>
                

    <!-- Jquery Core Js -->
    <script src="plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->
    <script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>

    <!-- Slimscroll Plugin Js -->
    <script src="plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="plugins/node-waves/waves.js"></script>

    <!-- Custom Js -->
    <script src="js/admin.js"></script>

    <!-- Demo Js -->
    <script src="js/demo.js"></script>
</body>

</html>