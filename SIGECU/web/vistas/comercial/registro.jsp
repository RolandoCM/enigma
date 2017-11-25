
<%-- 
    Document   : crearEvento
    Created on : 31/10/2017, 06:48:41 AM
    Author     : rolando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Blank Page | Bootstrap Based Admin Template - Material Design</title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <!--<link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">-->
   <link rel="stylesheet" href="../../fonts/material-design-icons-master/material-icons.css">
<!--WaitMe Css-->
    <link href="../../plugins/waitme/waitMe.css" rel="stylesheet" />
     <link href="../../plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />
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
                <h2></h2>
            </div>
            <!-- Input -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                               Pre-Inscripción
                                
                            </h2>
 
                        </div>
                        <div class="body">
                            
                            
                              <form action="preInscripcion" method="POST"  class="form-horizontal">
                                    <input type="hidden" name="accion" value="INS"/>  
                            <div class="row clearfix">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" name="nombre" class="form-control" placeholder="Nombre:" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" name="apellido" class="form-control" placeholder="Apellido:" required />
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="tel" name="telefono" class="form-control" placeholder="Telefono:" required/>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="email" name="email" class="form-control" placeholder="Email:" required >
                                        </div>
                                    </div>
                                </div>
                                
                                        <div class="col-sm-12">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <label class="">Empresa</label>
                                                    <select class="form-control show-tick" name="empresa" id="empresa" required>
                                                        <c:forEach var="ins" items="${datoPre}">
                                                            <option value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                               
                                            </div>
                                        </div>
                                        
                                        
                                        
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <div class="form-line">
                                            <input type="text" name="carrera"  class="form-control" placeholder="Carrera" >
                                        </div>
                                    </div>
                                </div>

                          
                                    <div class="col-sm-6">
                            <p>Note book</p>
                            <div class="demo-radio-button">
                                
                                <input name="confirmar" type="radio" value="si" id="radio_1" class="with-gap radio-col-black" >
                                <label for="radio_1">Si</label>

                                <input name="confirmar" type="radio" value="no" id="radio_2" class="with-gap radio-col-black" >
                                <label for="radio_2">No</label>

                            </div>

                                    </div>
                            <div class="footer">
                            <div class="row clearfix demo-button-sizes">
                                <div class="col-xs-6 col-sm-3 col-md-2 col-lg-2">
                                    <button type="submit" class="btn bg-red btn-block btn-lg waves-effect">Enviar</button>

                        </div>
                    </div>
                </div>
            </div>
                              </form>
                                      


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

    <!-- Waves Effect Plugin Js -->
    <script src="../../plugins/node-waves/waves.js"></script>

    <!-- Custom Js -->
    <script src="../../js/admin.js"></script>

    <!-- Demo Js -->
    <script src="../../js/demo.js"></script>


   
</body>

</html>