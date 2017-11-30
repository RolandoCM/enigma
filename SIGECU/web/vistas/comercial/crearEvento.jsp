<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>﻿<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Registrar Evento</title>
    <!-- Favicon-->
    <!--link rel="icon" href="../../favicon.ico" type="image/x-icon"-->

    <!-- Google Fonts -->
    <!--<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">-->
    <link rel="stylesheet" href="../../fonts/material-design-icons-master/material-icons.css">

    <!-- Bootstrap Core Css -->
    <link href="../../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="../../plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Bootstrap Select Css -->
    <!--link href="../../plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" /-->

    <!-- Animation Css -->
    <link href="../../plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Bootstrap Material Datetime Picker Css -->
    <link href="../../plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet" />

    <!-- Wait Me Css -->
    <link href="../../plugins/waitme/waitMe.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="../../css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="../../css/themes/all-themes.css" rel="stylesheet" />

    <style>

        @-webkit-keyframes spin {
          0% { -webkit-transform: rotate(0deg); }
          100% { -webkit-transform: rotate(360deg); }
        }

        .ispin{
            -webkit-animation: spin 1s linear infinite;
            animation: spin 1s linear infinite;
            /*display: none;*/
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
</head>

<body class="theme-red">
    
    <jsp:include page="menu1.jsp" flush="true" />

    <section class="content">
        <div class="container-fluid">

            <!-- -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>CREAR EVENTO</h2>
                        </div>
                        <div class="body">
                            <form id="crearEvento" method="POST" novalidate="novalidate" action="Eventos">
                                <div class="row clearfix">
                                    <div class="col-sm-6">
                                        <p>
                                            <b>Curso</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">school</i>
                                                </span>
                                                <select name="curso" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value="">-- Seleccionar Curso --</option>
                                                    <c:forEach var="cur" items="${datosParaEvento.get(5)}">
                                                        <option  value="${cur.id}">${cur.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <p>
                                            <b>Instructor</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">supervisor_account</i>
                                                </span>
                                                <select name="instructor" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value="">-- Seleccionar Instructor --</option>
                                                    <c:forEach var="ins" items="${datosParaEvento.get(0)}">
                                                        <option  value="${ins.id}">${ins.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row clearfix">
                                    <div class="col-sm-6">
                                        <p>
                                            <b>Descripción de evento</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">textsms</i>
                                                </span>
                                                <div class="form-line">
                                                    <textarea name="descripcion" rows="2" class="form-control no-resize auto-growth" placeholder="Descripción de evento..." required="" aria-required="true" style="overflow: hidden; overflow-wrap: break-word; height: 32px;"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-sm-6">
                                        <p>
                                            <b>Programa</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">edit</i>
                                                </span>
                                                <div class="form-line">
                                                    <textarea name="programa" rows="2" class="form-control no-resize auto-growth" placeholder="Programa del evento..." required="" aria-required="true" style="overflow: hidden; overflow-wrap: break-word; height: 32px;"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                                                   
                                <div class="row clearfix">
                                    <div class="col-sm-6">
                                        <b>Fecha de inicio</b>
                                        <div class="input-group form-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">date_range</i>
                                            </span>
                                            <div class="form-line">
                                                <input class="datepicker form-control" name="fechaI" placeholder="Fecha de Inicio YYYY-MM-DD" data-dtp="dtp_y2TTW" type="text" required="" aria-required="true">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <b>Fecha de termino</b>
                                        <div class="input-group form-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">date_range</i>
                                            </span>
                                            <div class="form-line">
                                                <input class="datepicker form-control" name="fechaT" placeholder="Fecha de Termino YYYY-MM-DD" data-dtp="dtp_y2TTW" type="text" required="" aria-required="true">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row clearfix">
                                    <div class="col-md-4 col-sm-6 col-xs-12">
                                        <p>
                                            <b>Pais</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">public</i>
                                                </span>
                                                <select name="selectPais" id="selectPais" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value=""> >--Seleccionar un País--< </option>
                                                    <c:forEach var="pais" items="${datosParaEvento.get(4)}">
                                                        <option  value="${pais.id}">${pais.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-4 col-sm-6 col-xs-12">
                                        <p>
                                            <b>Ciudad</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons reloadCiudad">location_city</i>
                                                </span>
                                                <select name="selectCiudad"  id="selectCiudad" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value=""> >--Seleccionar una Ciudad--< </option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-4 col-sm-6 col-xs-12">
                                        <p>
                                            <b>Lugar</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons reloadLugar">place</i>
                                                </span>
                                                <select name="selectLugar" id="selectLugar" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value=""> >--Seleccionar un Lugar--< </option>
                                                    
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <p>
                                            <b>Templete</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">label</i>
                                                </span>
                                                <select name="selectTemplete" id="selectTemplete" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value=""> >--Seleccionar un Templete--< </option>
                                                   <c:forEach var="temp" items="${datosParaEvento.get(2)}">
                                                        <option  value="${temp.id}">${temp.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <p>
                                            <b>Destinarario</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">person</i>
                                                </span>
                                                <select name="selectDestinatario" id="selectDestinatario" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value=""> >--Seleccionar un destinatario--< </option>
                                                   <c:forEach var="des" items="${datosParaEvento.get(8)}">
                                                        <option  value="${des.id}">${des.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    


                                </div>

                                <div class="row clearfix">
                                    <div class="col-sm-4">
                                        <b>Horario</b>
                                        <div class="input-group form-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">access_time</i>
                                            </span>
                                            <div class="form-line ">
                                                <input class="form-control" name="horario" required="" aria-required="true" type="text">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <b>Capacidad</b>
                                        <div class="input-group form-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">people</i>
                                            </span>
                                            <div class="form-line ">
                                                <input class="form-control" name="capacidad" required="" aria-required="true" type="number">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <b>Tipo evento</b>
                                        <div class="input-group form-group">
                                                <input type="radio" name="tipoEvento" id="radio_1" class="with-gap" required="" aria-required="true">
                                                <label for="radio_1">Privado</label>

                                                <input type="radio" name="tipoEvento" id="radio_2" class="with-gap">
                                                <label for="radio_2" class="m-l-20">Publico</label>
                                        </div>
                                    </div>
                                    
                                </div>

                                <div class="row clearfix">
                                    
                                    <div class="col-sm-4">
                                        <p>
                                            <b>Precios</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">attach_money</i>
                                                </span>
                                                <select name="precio" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value=""> --Seleccionar un Precio-- </option>
                                                   <c:forEach var="precio" items="${datosParaEvento.get(7)}">
                                                        <option  value="${precio.id}">${precio.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="col-sm-4">
                                        <p>
                                            <b>Promociones</b>
                                        </p>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="material-icons">local_offery</i>
                                                </span>
                                                <select name="promocion" class="form-control show-tick" tabindex="-98" required class="required validate">
                                                    <option selected="" disabled value=""> --Seleccionar una Promocion-- </option>
                                                   <c:forEach var="promo" items="${datosParaEvento.get(3)}">
                                                        <option  value="${promo.id}">${promo.nombre}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <b>Confirmación</b>
                                        <div class="form-group form-float">
                                            <div class="switch">
                                                <label>OFF<input name="statusEvento" checked="" type="checkbox" ><span class="lever switch-col-red"></span>ON</label>
                                            </div>
                                        </div>      
                                    </div>
                                    
                                    
                                    <div class="col-md-12">
                                        <button type="submit" class="btn btn-block btn-lg btn-primary waves-effect">
                                            <i class="material-icons">send</i>
                                            <span>CREAR EVENTO</span>
                                        </button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- -->

        </div>
    </section>

    <!-- Jquery Core Js -->
    <script src="../../plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="../../plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->
    <!--script src="../../plugins/bootstrap-select/js/bootstrap-select.js"></script-->

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

    <!-- Jquery Validation Plugin Css -->
    <script src="../../plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Custom Js -->
    <script src="../../js/admin.js"></script>

    <!-- Demo Js -->
    <script src="../../js/demo.js"></script>

    <script type="text/javascript" >
        var opcion;
        var id;

        $(function () {

            $('#selectPais').change(actualizarCiudades);
            $('#selectCiudad').change(actualizarLugares);

            function actualizarCiudades(){
                $('#selectLugar').empty();
                $('#selectLugar').html('<option selected="" disabled value=""> >--Seleccionar un Lugar--< </option>');

                $(".reloadCiudad").addClass('ispin');
                idPais = $("#selectPais").val();
                opcion="CC";
                $.post('DatosDinamicos', {
                    accion : opcion,
                    id: idPais,
                }, function(responseText) {
                    $('#selectCiudad').html(responseText);
                }).done(function (){
                    setTimeout(function() {
                        $(".reloadCiudad").removeClass('ispin');
                    }, 1000);
                });                
            }

            function actualizarLugares(){
                $(".reloadLugar").addClass('ispin');
                idCiudad = $("#selectCiudad").val();
                opcion="CL";
                $.post('DatosDinamicos', {
                    accion : opcion,
                    id: idCiudad,
                }, function(responseText) {
                    $('#selectLugar').html(responseText);
                }).done(function (){
                    setTimeout(function() {
                        $(".reloadLugar").removeClass('ispin');
                    }, 1000);
                });
            }


            //Textare auto growth
            autosize($('textarea.auto-growth'));

            $('.datepicker').bootstrapMaterialDatePicker({
                format: 'YYYY-MM-DD',
                clearButton: true,
                weekStart: 1,
                time: false
            });

            $('.timepicker').bootstrapMaterialDatePicker({
                format: 'HH:mm',
                clearButton: true,
                date: false
            });



            $('#crearEvento').validate({
                rules: {
                    'checkbox': {
                        required: true
                    },
                    'gender': {
                        required: true
                    }
                },
                highlight: function (input) {
                    $(input).parents('.form-line').addClass('error');
                },
                unhighlight: function (input) {
                    $(input).parents('.form-line').removeClass('error');
                },
                errorPlacement: function (error, element) {
                    $(element).parents('.form-group').append(error);
                }
            });
        });
        
    </script>
</body>

</html>