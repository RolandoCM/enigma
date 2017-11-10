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
            
            <!-- Input -->
            <div class="row clearfix">
                <div class="col-lg-11 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                                <div class="header">
                                    <h2>CREAR EVENTO</h2>
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
                                        <input type="hidden" name="accion" value="AE">
                                        <div class="row clearfix">
                                            <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" class="form-control" value="${eventoBuscado.id}" name="idEvento" readonly="readonly" maxlength="10" minlength="3" required>
                                                    <label class="form-label"> ID</label>
                                                </div>
                                                <div class="help-info">Solo texto</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" class="form-control" value="${eventoBuscado.nombre}" name="nombreEvento" maxlength="40" minlength="3" required>
                                                    <label class="form-label"> Nombre</label>
                                                </div>
                                                <div class="help-info">Solo texto</div>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input name="fechaEvento" type="text" id="date" value="${eventoBuscado.fecha}" class="form-control" placeholder="Elige la fecha Inicio">
                                                    <div class="help-info">Fecha del Inicio</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input name="fechaTermino" type="text" id="date" value="${eventoBuscado.fechaTermino}" class="form-control" placeholder="Elige la fecha Termino">
                                                    <div class="help-info">Fecha de Termino</div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="Texto" value="${eventoBuscado.descripcion}" class="form-control" name="descripcionEvento" required>
                                                    <label class="form-label">Descripcion</label>
                                                </div>
                                                <div class="help-info">Definicion de el evento</div>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" value="programa" class="form-control" name="programaEvento" required>
                                                    <label class="form-label">Programa</label>
                                                </div>
                                                <div class="help-info">Detalles del programa</div>
                                            </div>
                                        </div>
                                        </div>
                                        <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line ">
                                                    <select class=" form-control show-tick" name="instructorEvento"  required>
                                                        <c:forEach var="ins" items="${datosParaEvento.get(0)}">
                                                            <option  value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="help-info">Seleccione el Instructor</div>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" value="${eventoBuscado.lugar}" class="form-control" name="lugarEvento" required>
                                                    <label class="form-label">Lugar</label>
                                                </div>
                                                <div class="help-info">Direccion</div>
                                            </div>
                                        </div>
                                        </div>
                                        <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <label class="">Ciudad</label>
                                                    <select class="form-control show-tick"  name="ciudadEvento" required>
                                                        <c:forEach var="ins" items="${datosParaEvento.get(1)}">
                                                            <option value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="help-info">Ciudad</div>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <label class="">Pais</label>
                                                     <select name="templateEvento" class="form-control show-tick"  required >
                                                        <c:forEach var="ins" items="${datosParaEvento.get(4)}">
                                                            <option value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select> 
                                                    
                                                </div>
                                                <div class="help-info">Pais</div>
                                            </div>
                                        </div>
                                        </div>
                                        <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="number" value="${eventoBuscado.capacidad}" class="form-control" name="capacidadEvento" required>
                                                    <label class="form-label">Capacidad</label>
                                                </div>
                                                <div class="help-info">Numero de posibles alumnos</div>
                                            </div>
                                        </div>
                                       
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="number" value="${eventoBuscado.costo}" class="form-control" name="costoEvento" required>
                                                    <label class="form-label">Precio</label>
                                                </div>
                                                <div class="help-info">Costo de entrada</div>
                                            </div>
                                        </div>
                                        </div>
                                        <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="demo-radio-button">
                                                <input name="tipoEvento" type="radio" id="radio_1" checked value="privado" />
                                                <label for="radio_1">Privado</label>
                                                <input name="tipoEvento" type="radio" id="radio_2" value="publico"/>
                                                <label for="radio_2">Público</label>
                                                <br>
                                                <br>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <label class="">Templates</label>
                                                    <select name="templateEvento" class="form-control show-tick"  required >
                                                        <c:forEach var="ins" items="${datosParaEvento.get(2)}">
                                                            <option value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>          
                                                </div>
                                            </div>
                                        </div>
                                        </div>
                                        <div class="row clearfix">
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <label class="">Promoción</label>
                                                    <select name="promocionEvento" class="form-control show-tick" required >
                                                        <c:forEach var="ins" items="${datosParaEvento.get(3)}">
                                                            <option value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>                
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <div class="demo-switch-title">Confirmacion</div>
                                                    <div class="switch">
                                                        <label><input name="statusEvento" type="checkbox" checked><span class="lever switch-col-red"></span></label>
                                                    </div>
                                                </div>
                                            </div>      
                                        </div>
                                        </div>
                                        <div class="row clearfix">
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-primary waves-effect">GUARDAR</button>
                                            <a href="Eventos?accion=LEC"<button type="button" class="btn btn-danger waves-effect" data-dismiss="modal">CERRAR</button>></a>
                                        </div>
                                        </div>
                                    </form>
                                    <div>${msj.mensaje}</div>
                                    <div>${msj.id}</div>
                                  
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
