<%-- 
    Document   : perfilInteresado
    Created on : 20/11/2017, 03:09:19 PM
    Author     : JorgeLuna
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
 <!-- Bootstrap Tagsinput Css -->
    <link href="../../plugins/bootstrap-tagsinput/bootstrap-tagsinput.css" rel="stylesheet">
<!-- noUISlider Css -->
    <link href="../../plugins/nouislider/nouislider.min.css" rel="stylesheet" />


    <!-- Bootstrap Core Css -->
    <link href="../../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="../../plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="../../plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Colorpicker Css -->
    <link href="../../plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" rel="stylesheet" />

    <!-- Dropzone Css -->
    <link href="../../plugins/dropzone/dropzone.css" rel="stylesheet">

    <!-- Multi Select Css -->
    <link href="../../plugins/multi-select/css/multi-select.css" rel="stylesheet">

    <!-- Bootstrap Spinner Css -->
    <link href="../../plugins/jquery-spinner/css/bootstrap-spinner.css" rel="stylesheet">

    <!-- Bootstrap Tagsinput Css -->
    <link href="../../plugins/bootstrap-tagsinput/bootstrap-tagsinput.css" rel="stylesheet">

    <!-- Bootstrap Select Css -->
    <link href="../../plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />

    <!-- noUISlider Css -->
    <link href="../../plugins/nouislider/nouislider.min.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="../../css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="../../css/themes/all-themes.css" rel="stylesheet" />
</head>

<body class="theme-red">
   <jsp:include page="menuadmin.jsp" flush="true" /> 
   <section class="content">
        <div class="container-fluid">
       
<div class="row clearfix">
                <div class="block-header">
                <h2>Cursos a los que estas Inscrito</h2>
            </div>
            <div class="row clearfix">
                  <c:forEach var="cu" items="${cursosalumnos}">
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <div class="info-box hover-zoom-effect">
                        <div class="icon bg-blue">
                            <i class="material-icons">event_note</i>
                        </div>
                        <div class="content">
                            <div class="text">${cu.nombre}</div>
                          
                            <div class="number">${cu.fecha}</div>
                        </div>
                    </div>
                        <button type="button" data-color="blue" class="btn bg-blue waves-effect" data-toggle="modal" data-target="#defaultModal${cu.id}"><i class="material-icons">info</i>
                                    <span>Mas Informaci&oacute;n</span></button>
                </div>
                
                 <div class="modal fade" id="defaultModal${cu.id}" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="defaultModalLabel">Modal title</h4>
                        </div>
                        <div class="modal-body">
                            <div class="col-md-12">
                                <b>Nombre del Curso</b>
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">
                                        <i class="material-icons">event</i>
                                    </span>
                                    <div class="form-line">
                                        <input type="text" class="form-control" placeholder="Username" value="${cu.nombre}">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <b>Fecha del Curso</b>
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">
                                        <i class="material-icons">date_range</i>
                                    </span>
                                    <div class="form-line">
                                        <input type="text" class="form-control" placeholder="Username" value="${cu.fecha}">
                                    </div>
                                </div>
                            </div>
                                        <div class="col-md-12">
                                            <b>Templete del Curso</b>
                                            <div class="input-group input-group-lg">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">line_style</i>
                                                </span>
                                                <div class="form-line">
                                                    <input type="text" class="form-control" placeholder="Username" value="${cu.descripcion}">
                                                </div>
                                            </div>
                                        </div>
                                                <div class="col-md-12">
                                            <b>Programa del Curso</b>
                                            <div class="input-group input-group-lg">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">featured_play_list</i>
                                                </span>
                                                <div class="form-line">
                                                    <input type="text" class="form-control" placeholder="Username" value="${cu.programa}">
                                                </div>
                                            </div>
                                        </div>
                                                   <div class="col-md-12">
                                            <b>Instructor del Curso</b>
                                            <div class="input-group input-group-lg">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">person</i>
                                                </span>
                                                <div class="form-line">
                                                    <input type="text" class="form-control" placeholder="Username" value="${cu.instructor}">
                                                </div>
                                            </div>
                                        </div> 
                                                   <div class="col-md-12">
                                            <b>Lugar del Curso</b>
                                            <div class="input-group input-group-lg">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">add_location</i>
                                                </span>
                                                <div class="form-line">
                                                    <input type="text" class="form-control" placeholder="Username" value="${cu.lugar}">
                                                </div>
                                            </div>
                                        </div> 
                                                 <div class="col-md-12">
                                            <b>Ciudad</b>
                                            <div class="input-group input-group-lg">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">location_city</i>
                                                </span>
                                                <div class="form-line">
                                                    <input type="text" class="form-control" placeholder="Username" value="${cu.ciudad}">
                                                </div>
                                            </div>
                                        </div> 
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-link waves-effect">SAVE CHANGES</button>
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">CLOSE</button>
                        </div>
                    </div>
                </div>
            </div>       
                        
                  </c:forEach>
                <!--
                <div>${msj.mensaje}</div>
                                    <div>${msj.id}</div>-->
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

    <!-- Bootstrap Colorpicker Js -->
    <script src="../../plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>

    <!-- Dropzone Plugin Js -->
    <script src="../../plugins/dropzone/dropzone.js"></script>

    <!-- Input Mask Plugin Js -->
    <script src="../../plugins/jquery-inputmask/jquery.inputmask.bundle.js"></script>

    <!-- Multi Select Plugin Js -->
    <script src="../../plugins/multi-select/js/jquery.multi-select.js"></script>

    <!-- Jquery Spinner Plugin Js -->
    <script src="../../plugins/jquery-spinner/js/jquery.spinner.js"></script>

    <!-- Bootstrap Tags Input Plugin Js -->
    <script src="../../plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

    <!-- noUISlider Plugin Js -->
    <script src="../../plugins/nouislider/nouislider.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="../../plugins/node-waves/waves.js"></script>

    <!-- Custom Js -->
    <script src="../../js/admin.js"></script>
    <script src="../../js/pages/forms/advanced-form-elements.js"></script>
 

    <!-- Demo Js -->
    <script src="../../js/demo.js"></script>
     <script src="../../js/pages/ui/modals.js"></script>

    </body>
</html>

