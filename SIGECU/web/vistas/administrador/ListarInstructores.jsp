<%-- 
    Document   : ListarInstructores
    Created on : nov 23, 2017, 2:03:21 a.m.
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
                                    LISTA DE INSTRUCTORES
                                </h2>
                                <ul class="header-dropdown m-r--5">
                                    <li class="dropdown">
                                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                            <i class="material-icons">more_vert</i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                                            <li><a href="Eventos?accion=NEC">Enviar Lista</a></li>
                                            <li><a href="javascript:void(0);">Another action</a></li>
                                            <li><a href="javascript:void(0);">Something else here</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Apellido Paterno</th>
                                                <th>Apellido Materno</th>
                                                <th>Carrera</th>
                                                <th>Especialidad</th>
                                                <th>Email</th>
                                                <th>Telefono</th>
                                                <th>Dirección</th>
                                                <th>Modificar</th>
                                                <th>Baja</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Apellido Paterno</th>
                                                <th>Apellido Materno</th>
                                                <th>Carrera</th>
                                                <th>Especialidad</th>
                                                <th>Email</th>
                                                <th>Telefono</th>
                                                <th>Dirección</th>
                                                 <th>Modificar</th>
                                                <th>Baja</th>

                                            </tr>
                                        </tfoot>
                                        <tbody>

                                            <c:forEach var="data" items="${listaInstructor}">
                                                <tr>
                                                    <td>${data.iNombre}</td>
                                                    <td>${data.iPaterno}</td>
                                                    <td>${data.iMaterno}</td>
                                                    <td>${data.carrera}</td>
                                                    <td>${data.especialidad}</td>
                                                    <td>${data.iEmail}</td>
                                                    <td>${data.iTelefono}</td>
                                                    <td>${data.iDireccion}</td>
                                                    <td>
                                                        <a href="Eventos?accion=BE&idEvento=${data.idinstructor}"<button type="button" class="btn btn-primary waves-effect m-r-20" data-toggle="modal" data-target="">Modificar</button>
                                                    </td><td>
                                                        <div class="button-demo js-modal-buttons">
                                                            <button type="button" data-color="red" class="btn bg-red waves-effect" >Dar de Baja</button></a>
                                                        </div>
                                                    </td>
                                                </tr>


                                            <div class="modal fade" id="mdModal" tabindex="-1" role="dialog">
                                                <div class="modal-dialog modal-sm" role="document">
                                                    <div class="modal-content">

                                                        <div class="modal-header">
                                                            <h4 class="modal-title" id="smallModalLabel">¿SEGURO QUE DESEA ELIMINAR EL INSTRUCTO?</h4>
                                                        </div>

                                                        <div class="modal-body">

                                                        </div>
                                                        <div class="modal-footer">
                                                            <a href="Eventos?accion=CAE&idEvento=${data.idinstructor}"<button type="button" class="btn btn-link waves-effect">SI</button></a>
                                                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">CLOSE</button>
                                                        </div>

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


                <div class="modal fade" id="largeModal" tabindex="-1" role="dialog">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header bg-blue">
                                <h4 class="modal-title  " id="largeModalLabel">Modificar Instructor</h4>
                            </div>
                            <div class="modal-body">

                                <div class="body">
                                    <br><br>
                                    <form id="form_advanced_validation" action="Eventos" method="post">
                                        <input type="hidden" name="accion" value="MI"/>
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
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="iPaterno"  minlength="3" required>
                                                        <label class="form-label"> Apellido Paterno</label>
                                                    </div>
                                                    <div class="help-info">Solo texto</div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="iMaterno"  minlength="3" required>
                                                        <label class="form-label"> Apellido Materno</label>
                                                    </div>
                                                    <div class="help-info">Solo texto</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-md-6">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="Texto" class="form-control" name="carrera" required>
                                                        <label class="form-label">Carrera</label>
                                                    </div>
                                                    <div class="help-info">Carrera</div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="especialidad" required>
                                                        <label class="form-label">Especialidad</label>
                                                    </div>
                                                    <div class="help-info">Especialidad</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-md-6">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="iEmail" required>
                                                        <label class="form-label">Email</label>
                                                    </div>
                                                    <div class="help-info">Email</div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="number" class="form-control" name="iTelefono" required>
                                                        <label class="form-label">Telefono</label>
                                                    </div>
                                                    <div class="help-info">Telefono</div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <input type="number" class="form-control" name="iDireccion" required>
                                                        <label class="form-label">Dirección</label>
                                                    </div>
                                                    <div class="help-info">Dirección</div>
                                                </div>
                                            </div>
                                        </div>    
                                    </form>
                                    <div>
                                        ${msj.mensaje}</div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary waves-effect">GUARDAR</button>
                                <button type="button" class="btn btn-danger waves-effect" data-dismiss="modal">CERRAR</button>
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
