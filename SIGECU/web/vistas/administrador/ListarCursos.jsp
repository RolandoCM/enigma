<%-- 
    Document   : ListarCursos
    Created on : nov 23, 2017, 3:19:44 a.m.
    Author     : Alma
--%>

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
        <title>Listado Cursos</title>
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
                                    EXPORTABLE TABLE
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
                                <div>${curso}</div>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Horario</th>
                                                <th>Fecha Inicio</th>
                                                <th>Fecha Fin</th>
                                                <th>Tipo</th>
                                                <th>Instructor</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Horario</th>
                                                <th>Fecha Inicio</th>
                                                <th>Fecha Fin</th>
                                                <th>Tipo</th>
                                                <th>Instructor</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <tr>
                                                <td> Java Avanzado </td>
                                                <td>9:00am - 6:00pm</td>
                                                <td>12/10/2017</td>
                                                <td>30/11/2017</td>
                                                <td>Publico</td>
                                                <td>Rolando</td>
                                            </tr>
                                              <tr>
                                                <td>Informatica </td>
                                                <td>9:00am - 6:00pm</td>
                                                <td>10/10/2018</td>
                                                <td>30/11/2018</td>
                                                <td>Privado</td>
                                                <td>Jorge Luis</td>
                                            </tr>

                                            <c:forEach var="data" items="${listaCurso}">
                                                <tr>
                                                    <td>${data.nombre}</td>
                                                    <td>${data.horario}</td>
                                                    <td>${data.fechaInicio}</td>
                                                    <td>${data.fechaFin}</td>
                                                    <td>${data.tipo}</td>
                                                    <td>${data.instructor}</td>
                                                    <td>
                                                        <a href="Eventos?accion=BE&idEvento=${data.id}"<button type="button" class="btn btn-primary waves-effect m-r-20" data-toggle="modal" data-target="">Modificar</button>
                                                    </td><td>
                                                        <div class="button-demo js-modal-buttons">
                                                            <button type="button" data-color="red" class="btn bg-red waves-effect" >Eliminar Instructor</button></a>
                                                        </div>
                                                    </td>
                                                </tr>


                                            <div class="modal fade" id="mdModal" tabindex="-1" role="dialog">
                                                <div class="modal-dialog modal-sm" role="document">
                                                    <div class="modal-content">

                                                        <div class="modal-header">
                                                            <h4 class="modal-title" id="smallModalLabel">¿SEGURO QUE DESEA ELIMINAR EL CURSO?</h4>
                                                        </div>

                                                        <div class="modal-body">

                                                        </div>
                                                        <div class="modal-footer">
                                                            <a href="Eventos?accion=CAE&idEvento=${data.id}"<button type="button" class="btn btn-link waves-effect">SI</button></a>
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
                                <h4 class="modal-title  " id="largeModalLabel">Modificar Curso</h4>
                            </div>
                            <div class="modal-body">

                                <div class="body">
                                    <br><br>
                                    <form id="form_advanced_validation" action="Eventos" method="post">
                                        <input type="hidden" name="accion" value="MC">
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
                                                        <input name="fechaInicio" type="text" id="date" class="form-control"  maxlength="10" placeholder="Elige la fecha Inicio">
                                                        <div class="help-info">Fecha de Inicio en el formato de AAAA-MM-DD</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input name="fechaFin" type="text" id="date" class="form-control" placeholder="Elige la fecha Fin">
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
                                    </form>
                                    <div>
                                        ${mensaje.mensaje}</div>
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
