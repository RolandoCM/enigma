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
        <!-- Page Loader -->
        <div class="page-loader-wrapper">
            <div class="loader">
                <div class="preloader">
                    <div class="spinner-layer pl-red">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                </div>
                <p>Please wait...</p>
            </div>
        </div>
        <!-- #END# Page Loader -->
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Search Bar -->
        <div class="search-bar">
            <div class="search-icon">
                <i class="material-icons">search</i>
            </div>
            <input type="text" placeholder="¿Que deseas buscar?">
            <div class="close-search">
                <i class="material-icons">close</i>
            </div>
        </div>
        <!-- #END# Search Bar -->
        <!-- Top Bar -->
        <nav class="navbar">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                    <a href="javascript:void(0);" class="bars"></a>
                    <a class="navbar-brand" href="../../index.html">SIGECU</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <!-- Call Search -->
                        <li>
                            <a href="javascript:void(0);" class="js-search" data-close="true">
                                <i class="material-icons">search</i></a></li>
                        <!-- #END# Call Search -->
                        <!-- Notifications -->

                        <!-- #END# Notifications -->
                        <!-- Tasks -->
                        <!-- #END# Tasks -->
                        <li class="pull-right"><a href="javascript:void(0);" class="js-right-sidebar" data-close="true"><i class="material-icons">more_vert</i></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- #Top Bar -->
        <section>
            <!-- Left Sidebar -->
            <aside id="leftsidebar" class="sidebar">
                <!-- User Info -->
                <div class="user-info">
                    <div class="image">
                        <img src="../images/user.png" width="48" height="48" alt="User" />
                    </div>
                    <div class="info-container">
                        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">John Doe</div>
                        <div class="email">john.doe@example.com</div>
                        <div class="btn-group user-helper-dropdown">
                            <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                            <ul class="dropdown-menu pull-right">
                                <li><a href="javascript:void(0);"><i class="material-icons">person</i>Profile</a></li>
                                <li role="seperator" class="divider"></li>
                                <li><a href="javascript:void(0);"><i class="material-icons">group</i>Followers</a></li>
                                <li><a href="javascript:void(0);"><i class="material-icons">shopping_cart</i>Sales</a></li>
                                <li><a href="javascript:void(0);"><i class="material-icons">favorite</i>Likes</a></li>
                                <li role="seperator" class="divider"></li>
                                <li><a href="javascript:void(0);"><i class="material-icons">input</i>Sign Out</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- #User Info -->
                <!-- Menu -->
                <div class="menu">
                    <ul class="list">
                        <li class="header">MAIN NAVIGATION</li>
                        <li>
                            <a href="../../index.html">
                                <i class="material-icons">home</i>
                                <span>Home</span>
                            </a>
                        </li>
                        <li>
                            <a href="listaEventos.jsp">
                                <i class="material-icons">view_list</i>
                                <span>Lista de Eventos</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../pages/typography.html">
                                <i class="material-icons">text_fields</i>
                                <span>Typography</span>
                            </a>
                        </li>
                        <li>
                            <a href="../../pages/helper-classes.html">
                                <i class="material-icons">layers</i>
                                <span>Helper Classes</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">widgets</i>
                                <span>Widgets</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="javascript:void(0);" class="menu-toggle">
                                        <span>Cards</span>
                                    </a>
                                    <ul class="ml-menu">
                                        <li>
                                            <a href="../../pages/widgets/cards/basic.html">Basic</a>
                                        </li>
                                        <li>
                                            <a href="../../pages/widgets/cards/colored.html">Colored</a>
                                        </li>
                                        <li>
                                            <a href="../../pages/widgets/cards/no-header.html">No Header</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="menu-toggle">
                                        <span>Infobox</span>
                                    </a>
                                    <ul class="ml-menu">
                                        <li>
                                            <a href="../../pages/widgets/infobox/infobox-1.html">Infobox-1</a>
                                        </li>
                                        <li>
                                            <a href="../../pages/widgets/infobox/infobox-2.html">Infobox-2</a>
                                        </li>
                                        <li>
                                            <a href="../../pages/widgets/infobox/infobox-3.html">Infobox-3</a>
                                        </li>
                                        <li>
                                            <a href="../../pages/widgets/infobox/infobox-4.html">Infobox-4</a>
                                        </li>
                                        <li>
                                            <a href="../../pages/widgets/infobox/infobox-5.html">Infobox-5</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">swap_calls</i>
                                <span>User Interface (UI)</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../../pages/ui/alerts.html">Alerts</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/animations.html">Animations</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/badges.html">Badges</a>
                                </li>

                                <li>
                                    <a href="../../pages/ui/breadcrumbs.html">Breadcrumbs</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/buttons.html">Buttons</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/collapse.html">Collapse</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/colors.html">Colors</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/dialogs.html">Dialogs</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/icons.html">Icons</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/labels.html">Labels</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/list-group.html">List Group</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/media-object.html">Media Object</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/modals.html">Modals</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/notifications.html">Notifications</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/pagination.html">Pagination</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/preloaders.html">Preloaders</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/progressbars.html">Progress Bars</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/range-sliders.html">Range Sliders</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/sortable-nestable.html">Sortable & Nestable</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/tabs.html">Tabs</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/thumbnails.html">Thumbnails</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/tooltips-popovers.html">Tooltips & Popovers</a>
                                </li>
                                <li>
                                    <a href="../../pages/ui/waves.html">Waves</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">assignment</i>
                                <span>Forms</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../../pages/forms/basic-form-elements.html">Basic Form Elements</a>
                                </li>
                                <li>
                                    <a href="../../pages/forms/advanced-form-elements.html">Advanced Form Elements</a>
                                </li>
                                <li>
                                    <a href="../../pages/forms/form-examples.html">Form Examples</a>
                                </li>
                                <li>
                                    <a href="../../pages/forms/form-validation.html">Form Validation</a>
                                </li>
                                <li>
                                    <a href="../../pages/forms/form-wizard.html">Form Wizard</a>
                                </li>
                                <li>
                                    <a href="../../pages/forms/editors.html">Editors</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">view_list</i>
                                <span>Tables</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../../pages/tables/normal-tables.html">Normal Tables</a>
                                </li>
                                <li>
                                    <a href="../../pages/tables/jquery-datatable.html">Jquery Datatables</a>
                                </li>
                                <li>
                                    <a href="../../pages/tables/editable-table.html">Editable Tables</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">perm_media</i>
                                <span>Medias</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../../pages/medias/image-gallery.html">Image Gallery</a>
                                </li>
                                <li>
                                    <a href="../../pages/medias/carousel.html">Carousel</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">pie_chart</i>
                                <span>Charts</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../../pages/charts/morris.html">Morris</a>
                                </li>
                                <li>
                                    <a href="../../pages/charts/flot.html">Flot</a>
                                </li>
                                <li>
                                    <a href="../../pages/charts/chartjs.html">ChartJS</a>
                                </li>
                                <li>
                                    <a href="../../pages/charts/sparkline.html">Sparkline</a>
                                </li>
                                <li>
                                    <a href="../../pages/charts/jquery-knob.html">Jquery Knob</a>
                                </li>
                            </ul>
                        </li>
                        <li class="active">
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">content_copy</i>
                                <span>Example Pages</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../../pages/examples/sign-in.html">Sign In</a>
                                </li>
                                <li>
                                    <a href="../../pages/examples/sign-up.html">Sign Up</a>
                                </li>
                                <li>
                                    <a href="../../pages/examples/forgot-password.html">Forgot Password</a>
                                </li>
                                <li class="active">
                                    <a href="../../pages/examples/blank.html">Blank Page</a>
                                </li>
                                <li>
                                    <a href="../../pages/examples/404.html">404 - Not Found</a>
                                </li>
                                <li>
                                    <a href="../../pages/examples/500.html">500 - Server Error</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">map</i>
                                <span>Maps</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="../../pages/maps/google.html">Google Map</a>
                                </li>
                                <li>
                                    <a href="../../pages/maps/yandex.html">YandexMap</a>
                                </li>
                                <li>
                                    <a href="../../pages/maps/jvectormap.html">jVectorMap</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">trending_down</i>
                                <span>Multi Level Menu</span>
                            </a>
                            <ul class="ml-menu">
                                <li>
                                    <a href="javascript:void(0);">
                                        <span>Menu Item</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);">
                                        <span>Menu Item - 2</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);" class="menu-toggle">
                                        <span>Level - 2</span>
                                    </a>
                                    <ul class="ml-menu">
                                        <li>
                                            <a href="javascript:void(0);">
                                                <span>Menu Item</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);" class="menu-toggle">
                                                <span>Level - 3</span>
                                            </a>
                                            <ul class="ml-menu">
                                                <li>
                                                    <a href="javascript:void(0);">
                                                        <span>Level - 4</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="../changelogs.html">
                                <i class="material-icons">update</i>
                                <span>Changelogs</span>
                            </a>
                        </li>
                        <li class="header">LABELS</li>
                        <li>
                            <a href="javascript:void(0);">
                                <i class="material-icons col-red">donut_large</i>
                                <span>Important</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);">
                                <i class="material-icons col-amber">donut_large</i>
                                <span>Warning</span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);">
                                <i class="material-icons col-light-blue">donut_large</i>
                                <span>Information</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- #Menu -->
                <!-- Footer -->
                <div class="legal">
                    <div class="copyright">
                        &copy; 2016 - 2017 <a href="javascript:void(0);">SOFAC</a>.
                    </div>
                    <div class="version">
                        <b>Version: </b> 1.0.5
                    </div>
                </div>
                <!-- #Footer -->
            </aside>
            <!-- #END# Left Sidebar -->
            <!-- Right Sidebar -->
            <aside id="rightsidebar" class="right-sidebar">
                <ul class="nav nav-tabs tab-nav-right" role="tablist">
                    <li role="presentation" class="active"><a href="#skins" data-toggle="tab">SKINS</a></li>
                    <li role="presentation"><a href="#settings" data-toggle="tab">SETTINGS</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active in active" id="skins">
                        <ul class="demo-choose-skin">
                            <li data-theme="red" class="active">
                                <div class="red"></div>
                                <span>Red</span>
                            </li>
                            <li data-theme="pink">
                                <div class="pink"></div>
                                <span>Pink</span>
                            </li>
                            <li data-theme="purple">
                                <div class="purple"></div>
                                <span>Purple</span>
                            </li>
                            <li data-theme="deep-purple">
                                <div class="deep-purple"></div>
                                <span>Deep Purple</span>
                            </li>
                            <li data-theme="indigo">
                                <div class="indigo"></div>
                                <span>Indigo</span>
                            </li>
                            <li data-theme="blue">
                                <div class="blue"></div>
                                <span>Blue</span>
                            </li>
                            <li data-theme="light-blue">
                                <div class="light-blue"></div>
                                <span>Light Blue</span>
                            </li>
                            <li data-theme="cyan">
                                <div class="cyan"></div>
                                <span>Cyan</span>
                            </li>
                            <li data-theme="teal">
                                <div class="teal"></div>
                                <span>Teal</span>
                            </li>
                            <li data-theme="green">
                                <div class="green"></div>
                                <span>Green</span>
                            </li>
                            <li data-theme="light-green">
                                <div class="light-green"></div>
                                <span>Light Green</span>
                            </li>
                            <li data-theme="lime">
                                <div class="lime"></div>
                                <span>Lime</span>
                            </li>
                            <li data-theme="yellow">
                                <div class="yellow"></div>
                                <span>Yellow</span>
                            </li>
                            <li data-theme="amber">
                                <div class="amber"></div>
                                <span>Amber</span>
                            </li>
                            <li data-theme="orange">
                                <div class="orange"></div>
                                <span>Orange</span>
                            </li>
                            <li data-theme="deep-orange">
                                <div class="deep-orange"></div>
                                <span>Deep Orange</span>
                            </li>
                            <li data-theme="brown">
                                <div class="brown"></div>
                                <span>Brown</span>
                            </li>
                            <li data-theme="grey">
                                <div class="grey"></div>
                                <span>Grey</span>
                            </li>
                            <li data-theme="blue-grey">
                                <div class="blue-grey"></div>
                                <span>Blue Grey</span>
                            </li>
                            <li data-theme="black">
                                <div class="black"></div>
                                <span>Black</span>
                            </li>
                        </ul>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="settings">
                        <div class="demo-settings">
                            <p>GENERAL SETTINGS</p>
                            <ul class="setting-list">
                                <li>
                                    <span>Report Panel Usage</span>
                                    <div class="switch">
                                        <label><input type="checkbox" checked><span class="lever"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Email Redirect</span>
                                    <div class="switch">
                                        <label><input type="checkbox"><span class="lever"></span></label>
                                    </div>
                                </li>
                            </ul>
                            <p>SYSTEM SETTINGS</p>
                            <ul class="setting-list">
                                <li>
                                    <span>Notifications</span>
                                    <div class="switch">
                                        <label><input type="checkbox" checked><span class="lever"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Auto Updates</span>
                                    <div class="switch">
                                        <label><input type="checkbox" checked><span class="lever"></span></label>
                                    </div>
                                </li>
                            </ul>
                            <p>ACCOUNT SETTINGS</p>
                            <ul class="setting-list">
                                <li>
                                    <span>Offline</span>
                                    <div class="switch">
                                        <label><input type="checkbox"><span class="lever"></span></label>
                                    </div>
                                </li>
                                <li>
                                    <span>Location Permission</span>
                                    <div class="switch">
                                        <label><input type="checkbox" checked><span class="lever"></span></label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </aside>
            <!-- #END# Right Sidebar -->
        </section>

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
                                            <li><a href="javascript:void(0);">Action</a></li>
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
                                                <th>Ciudad</th>
                                                <th>Pais</th>
                                                <th>Fecha</th>
                                                <th>Modificar</th>
                                                <th>Cancelar</th>

                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Ciudad</th>
                                                <th>Pais</th>
                                                <th>Fecha</th>
                                                 <th>Modificar</th>
                                                <th>Cancelar</th>

                                            </tr>
                                        </tfoot>
                                        <tbody>

                                            <c:forEach var="data" items="${listaEvento}">
                                                <tr>
                                                <td>${data.nombre}</td>
                                                <td>${data.nombreCiudad}</td>
                                                <td>${data.nombrePais}</td>
                                                <td>${data.fecha}</td>
                                                <td>
                                                    <a href="Eventos?accion=BE&idEvento=${data.id}"<button type="button" class="btn btn-primary waves-effect m-r-20" data-toggle="modal" data-target="">Modificar</button>></a>
                                                </td><td>
                                                     <div class="button-demo js-modal-buttons">
                                                         <a href="Eventos?accion=CAE&idEvento=${data.id}"<button type="button" data-color="red" class="btn bg-red waves-effect" >Cancelar Evento</button>></a>
                                                     </div>
                                                </td>
                                            </tr>
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
                                <h4 class="modal-title  " id="largeModalLabel">Modificar Evento</h4>
                            </div>
                            <div class="modal-body">

                                <div class="body">
                                    <br><br>
                                    <form id="form_advanced_validation" action="Eventos" method="POST">
                                        <input type="hidden" name="accion" value="CE"/>
                                        <div class="col-md-6 ">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" class="form-control" name="nombreEvento" maxlength="10" minlength="3" required>
                                                    <label class="form-label"> Nombre</label>
                                                </div>
                                                <div class="help-info">Solo texto</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input name="fechaEvento" type="text" id="date" class="form-control" placeholder="Elige la fecha">

                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="Texto" class="form-control" name="descripcionEvento" required>
                                                    <label class="form-label">Descripcion</label>
                                                </div>
                                                <div class="help-info">Definicion de el evento</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" class="form-control" name="programaEvento" required>
                                                    <label class="form-label">Programa</label>
                                                </div>
                                                <div class="help-info">Detalles del programa</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

                                            <div class="form-group form-float">
                                                <div class="form-line ">
                                                    <select class=" form-control show-tick" name="instructorEvento"  required>
                                                        <option value="">Ninguno</option>
                                                        <c:forEach var="ins" items="${datosParaEvento.get(0)}">
                                                            <option  value="${ins.id}">${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="help-info">Seleccione el Instructor</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" class="form-control" name="lugarEvento" required>
                                                    <label class="form-label">Lugar</label>
                                                </div>
                                                <div class="help-info">Direccion</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <label class="">Ciudad</label>
                                                    <select class="form-control show-tick" name="ciudadEvento" required>
                                                        <c:forEach var="ins" items="${eventoBuscado}">
                                                            <option>${ins.nombre}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="help-info">Ciudad</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" class="form-control" name="paisEvento" required>
                                                    <label class="form-label">Pais</label>
                                                </div>
                                                <div class="help-info">Pais</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="number" class="form-control" name="capacidadEvento" required>
                                                    <label class="form-label">Capacidad</label>
                                                </div>
                                                <div class="help-info">Numero de posibles alumnos</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="number" class="form-control" name="costoEvento" required>
                                                    <label class="form-label">Precio</label>
                                                </div>
                                                <div class="help-info">Costo de entrada</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

                                            <div class="demo-radio-button">
                                                <input name="tipoEvento" type="radio" id="radio_1" checked value="privado" />
                                                <label for="radio_1">Privado</label>
                                                <input name="tipoEvento" type="radio" id="radio_2" value="publico"/>
                                                <label for="radio_2">Público</label>
                                                <br>
                                                <br>
                                            </div>
                                        </div>
                                        <div class="col-md-6 ">

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
                                        <div class="col-md-6 ">

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
                                        <div class="col-md-6 ">

                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <div class="demo-switch-title">Confirmacion</div>
                                                    <div class="switch">
                                                        <label><input name="statusEvento" type="checkbox" checked><span class="lever switch-col-red"></span></label>
                                                    </div>
                                                </div>
                                            </div> 
                                             <br>
                                <br>
                                        </div>      
                                    </form>
                                    <div>hola
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
                                
                                
 <div class="modal fade" id="mdModal" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="smallModalLabel">SEGURO QUE DESEA CANCELAR EL EVENTO?</h4>
                        </div>
                        <div class="modal-body">
                         
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-link waves-effect">SI</button>
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">CLOSE</button>
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
