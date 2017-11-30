<%-- 
    Document   : crearEvento
    Created on : 31/10/2017, 06:48:41 AM
    Author     : rolando
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
 <link rel="stylesheet" href="../../fonts/material-design-icons-master/material-icons.css">

        <!-- Google Fonts -->
        <!--<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">-->
        <!-- Bootstrap Core Css -->
        <link href="../../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Waves Effect Css -->
        <link href="../../plugins/node-waves/waves.css" rel="stylesheet" />

        <!-- Animation Css -->
        <link href="../../plugins/animate-css/animate.css" rel="stylesheet" />

        <!-- JQuery DataTable Css -->
        <link href="../../plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">

        <!-- Custom Css -->
        <link href="../../css/style.css" rel="stylesheet">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="../../css/themes/all-themes.css" rel="stylesheet" />
    </head>

    <body class="theme-red">
       <jsp:include page="menu1.jsp" flush="true" />
        
        <section class="content">
            <div class="container-fluid">

                <!-- Input -->
                <div class="row clearfix">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="header">
                                <h2>
                                    Seguimiento de Pagos
                                </h2>
                            </div>
                            <div class="body">
                                <form id="form_advanced_validation" action="" >
                                    <input type="hidden" name="accion" value="BE">
                                   <div class="row clearfix">
                                        <div class="col-md-6">
                                            <p>
                                                <b>Curso</b>
                                            </p>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <i class="material-icons">label</i>
                                                    </span>
                                                    <select name="idEvento" id="idEvento" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                        <option selected="" disabled value=""> Seleccionar Evento</option>
                                                        <c:forEach var="ins" items="${eventos}">
                                                            <option  value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                       <!--div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line ">
                                                    <select class=" form-control show-tick" name="idEvento"  required>
                                                        <option value="">Ninguno</option>
                                                        <c:forEach var="ins" items="${eventos}">
                                                            <option  value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="help-info">Seleccione el nombre</div>
                                            </div>
                                        </div-->
                                       <div class="col-md-6">
                                            <div class="col-md-12">
                                                <button class="btn btn-block btn-lg btn-primary waves-effect" type="submit">Buscar</button>              
                                            </div>
                                        </div>
                                   </div>
                                        
                                  
                                 
                                   
                               </form>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                        <thead>
                                            <tr>
                                                <th>Alumno</th>
                                                <th>Nombre Evento</th>
                                                <th>Fecha</th>
                                                <th>Estado de pago</th>
                                                
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Alumno</th>
                                                <th>Nombre Evento</th>
                                                <th>Fecha</th>
                                                <th>Estado de pago</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach var="data" items="${pagos}">
                                                <tr class="bg-teal">
                                                    <td>${data.quePago}</td>
                                                    <td>${data.fechaPago}</td>
                                                    <td>${data.nombreAlumno}</td>
                                                    <td>${data.precio}</td>
                                                    <td>${data.formaPago}</td>
                                                   <td>
                                                        <div class="button-demo js-modal-buttons">
                                                            <button data-toggle="modal" data-target="#ModalConfirmar${data.idHistorial}" data-color="red" class="btn bg-red waves-effect">Confirmar</button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                
                                                
                                                <!--Modal Confirmar-->
                                                <div class="modal fade" id="ModalConfirmar${data.idHistorial}" tabindex="-1" role="dialog">
                                                    <div class="modal-dialog modal-sm" role="document">
                                                        <div class="modal-content modal-col-red">

                                                            <div class="modal-header">
                                                                <h4 class="modal-title" id="smallModalLabel">SEGURO QUE DESEA CANCELAR EL EVENTO:
                                                                <br> ${data.quePago}, ${data.idHistorial}?</h4>
                                                            </div>

                                                            <div class="modal-body">

                                                            </div>
                                                            <div class="modal-footer">
                                                                <a role="button" class="btn btn-link waves-effect" href="ServletSeguimientoPagos?accion=CE&idHistorial=${data.idHistorial}&idUsuario=${data.idUsuario}">Si</a>
                                                                <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">CLOSE</button>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                        ${mensaje.mensaje}</div>
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
        <!--script src="../../plugins/bootstrap-select/js/bootstrap-select.js"></script-->

        <!-- Slimscroll Plugin Js -->
        <script src="../../plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

        <!-- Waves Effect Plugin Js -->
        <script src="../../plugins/node-waves/waves.js"></script>

        <!-- Jquery DataTable Plugin Js -->
        <script src="../../plugins/jquery-datatable/jquery.dataTables.js"></script>
        <script src="../../plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
        <script src="../../plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>
        <script src="../../js/pages/ui/modals.js"></script>

        <!-- Custom Js -->
        <script src="../../js/admin.js"></script>
        <script src="../../js/pages/tables/jquery-datatable.js"></script>

        <!-- Demo Js -->
        <script src="../../js/demo.js"></script>
    </body>



</html>
