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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Crear Evento</title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
    <!-- Google Fonts -->
    <!--<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">-->
    <link rel="stylesheet" href="../../fonts/material-design-icons-master/material-icons.css">
    <link href="../../plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

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
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                    <div class="demo-google-material-icon"> <i class="material-icons">person</i> <span class="icon-name">Alumnos Registrados</span> </div>
                                </h2>
                            <!--
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
                            -->
                        </div>
                        <div class="body">
                            
                            <button type="button" class="btn btn-primary waves-effect
                                                        btn-large" data-toggle="modal" data-target="#insertarAlumno">
                                                    <i class="material-icons left">group_add</i> Agregar Pais</button> 
                                          
                                                    
               <div class="modal fade" id="insertarAlumno" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="largeModalLabel">Agregar Pais</h4>
                        </div>
                        <form id="form_advanced_validation" action="Pais" method="GET">
                        <div class="modal-body">
                             <div class="demo-masked-input">
                                <div class="row clearfix">
                                    <input name="accion" value="IP" hidden> 

                                    <div class="col-md-6">
                                        <b>Nombre</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">person</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" class="form-control " placeholder="Nombre del pais" name="nombrepais" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <b>Region</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">person</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" class="form-control " placeholder="Region" name="region" required>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                                    
                                    
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-link waves-effect">GUARDAR</button>
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">CLOSE</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
                                                    
                           
                                         
                                         <div>${msj.mensaje}</div>
                                    <div>${msj.id}</div>
                                         
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
   
 <section class="content">
        <div class="container-fluid">
            <div class="block-header">
                <h2>
                    Paises
                </h2>
            </div><div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                EXPORTABLE TABLE
                            </h2>
                            <!--
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
                            -->
                        </div>
                        <div class="body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                    <thead>
                                        <tr>
                                            <!--<th>Elimniar</th>-->
                                            <th>Modificar</th>
                                            <th>Id</th>
                                            <th>Pais</th>
                                            <th>Region</th>
                                            
                                            
                                        </tr>
                                    </thead>
                                   
                                    <tbody>
                                         <c:forEach var="pais" items="${datosPais}">
                                        <tr>
                                            <!--<td>$320,800</td>-->
                                             <td><button type="button" class="btn btn-warning waves-effect
                                                        btn-large" data-toggle="modal" data-target="#largeModal${pais.idpais}">
                                                    <i class="material-icons left">update</i> MODIFICAR</button> 
                                            </td>
                                            <td>${pais.idpais}</td>
                                            <td>${pais.nombrepais} </td>
                                            <td>${pais.region}</td>
                                            
                                           
                                            
                                        </tr>
                                        
                                         <div class="modal fade" id="largeModal${pais.idpais}" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="largeModalLabel">Modificar Pais</h4>
                        </div>
                        <form id="form_advanced_validation" action="Pais" method="POST">
                        <div class="modal-body">
                            
                                        <input type="hidden" name="accion" value="MP">
                                    <div class="col-md-6">
                                        <b>Nombre</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">person</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" class="form-control " placeholder="Nombre del Pais" name="nombrep" value="${pais.nombrepais}">
                                            </div>
                                        </div>
                                    </div>
                                            <div class="col-md-6">
                                        <b>Region</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">person</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" class="form-control " placeholder="Region" name="region" value="${pais.region}">
                                                <input type="number" name="idpais" value="${pais.idpais}" hidden>

                                            </div>
                                        </div>
                                    </div>
                                    
                        </div>
                        <div class="modal-footer">
                            <div class="col-md-12">
                            <button type="submit" class="btn btn-link waves-effect">MODIFICAR</button>
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">CLOSE</button>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
                                         </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
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
<script src="../../plugins/jquery-datatable/jquery.dataTables.js"></script>
    <script src="../../plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
    <script src="../../plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
    <script src="../../plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
    <script src="../../plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
    <script src="../../plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
    <script src="../../plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
    <script src="../../plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
    <script src="../../plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>
    <script src="../../js/pages/tables/jquery-datatable.js"></script>

    <!-- Custom Js -->
    <script src="../../js/admin.js"></script>
    <script src="../../js/pages/forms/advanced-form-elements.js"></script>

    <!-- Demo Js -->
    <script src="../../js/demo.js"></script>
     <script src="../../js/pages/ui/modals.js"></script>

     
    </body>
</html>

