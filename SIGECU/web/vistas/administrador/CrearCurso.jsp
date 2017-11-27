<%-- 
    Document   : CrearCurso
    Created on : nov 23, 2017, 1:46:15 a.m.
    Author     : Alma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Crear Curso</title>
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
                <div class="row clearfix">
                    <div class="col-lg-11 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="header">
                                <h2>CREAR CURSO</h2>
                                <ul class="header-dropdown m-r--5">
                                    <li class="dropdown">
                                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                            <i class="material-icons">more_vert</i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                                            <li><a href="javascript:void(0);">Action</a></li>
                                            <li><a href="javascript:void(0);">Another action</a></li>
                                            <li><a href="javascript:void(0);">Something else here</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="body">
                                <form id="form_advanced_validation" action="Eventos" method="POST">
                                    <input type="hidden" name="accion" value="CC">
                                    <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" class="form-control" name="inombre"  minlength="3" required>
                                                    <label class="form-label"> Nombre</label>
                                                </div>
                                                <div class="help-info">Solo texto</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input name="horario" type="time" id="date" class="form-control" placeholder="Elige el horario del curso">
                                                    <div class="help-info">Horario del curso en el formato de HH-MM</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input name="fechaInicio" type="date" id="date" class="form-control"  maxlength="10" placeholder="Elige la fecha Inicio">
                                                    <div class="help-info">Fecha de Inicio en el formato de AAAA-MM-DD</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input name="fechaFin" type="date" id="date" class="form-control" placeholder="Elige la fecha Fin">
                                                    <div class="help-info">Fecha De Fin en el formato de AAAA-MM-DD</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="Texto" class="form-control" name="tipo" required>
                                                    <label class="form-label">tipo</label>
                                                </div>
                                                <div class="help-info">tipo</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line ">
                                                    <select class=" form-control show-tick" name="instructorCurso"  required>
                                                        <option value="">Ninguno</option>
                                                        <c:forEach var="ins" items="${datosParaCurso.get(0)}">
                                                            <option  value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="help-info">Seleccione el Instructor</div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row clearfix">
                                        <div class="col-md-12">
                                            <button class="btn btn-block btn-lg btn-primary waves-effect" type="submit">ENVIAR</button>              
                                        </div>
                                    </div>
                                </form>
                                <div>${msj.mensaje}</div>
                            </div>
                        </div>
                    </div>
                </div>
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

        <!-- Autosize Plugin Js -->
        <script src="../../plugins/autosize/autosize.js"></script>

        <!-- Moment Plugin Js -->
        <script src="../../plugins/momentjs/moment.js"></script>

        <!-- Bootstrap Material Datetime Picker Plugin Js -->
        <script src="../../plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>

        <!-- Custom Js -->
        <script src="../../js/admin.js"></script>
        <script src="../../js/pages/forms/basic-form-elements.js"></script>

        <!-- Demo Js -->
        <script src="../../js/demo.js"></script>

    </body>
</html>
