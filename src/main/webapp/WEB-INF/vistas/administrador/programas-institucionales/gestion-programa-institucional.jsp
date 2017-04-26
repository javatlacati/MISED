<%@include file="../../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <sec:csrfMetaTags/>
    <title>MISED :: Administración de Programas Institucionales</title>
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
    <spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" var="fontRoboto" />
    <spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons" />
    <spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss" />
    <spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss" />
    <spring:url value="/resources/plugins/material-design-preloader/md-preloader.min.css" var="mdPreloaderCss" />
    <spring:url value="/resources/plugins/sweetalert/sweetalert.css" var="sweetAlertCss" />
    <spring:url value="/resources/css/style.min.css" var="styleCss" />
    <spring:url value="/resources/css/themes/all-themes.min.css" var="allThemesCss" />
    <spring:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.min.css" var="bootstrapSelectCss"/>
    <spring:url value="/resources/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" var="datePickerCss" />
    <spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.min.css" var="dataTablesBootstrapCss" />
    <spring:url value="/resources/plugins/jquery-datatable/responsive.dataTables.min.css" var="responsiveDataTableCss"/>
    <link href="${fontRoboto}" rel="stylesheet" type="text/css">
    <link href="${materialIcons}" rel="stylesheet" type="text/css">
    <link href="${bootstrapCss}" rel="stylesheet">
    <link href="${wavesCss}" rel="stylesheet" />
    <link href="${animateCss}" rel="stylesheet" />
    <link href="${mdPreloaderCss}" rel="stylesheet" />
    <link href="${sweetAlertCss}" rel="stylesheet">
    <link href="${styleCss}" rel="stylesheet">
    <link href="${allThemesCss}" rel="stylesheet" />
    <link href="${bootstrapSelectCss}" rel="stylesheet" />
    <link href="${datePickerCss}" rel="stylesheet" />
    <link href="${dataTablesBootstrapCss}" rel="stylesheet" />
    <link href="${responsiveDataTableCss}" rel="stylesheet" />
</head>
<body class="theme-grey">
    <div class="page-loader-wrapper">
        <div class="loader">
            <div class="md-preloader pl-size-md">
                <svg viewbox="0 0 75 75">
                    <circle cx="37.5" cy="37.5" r="33.5" class="pl-red" stroke-width="4" />
                </svg>
            </div>
            <p><spring:message code="mensaje.espere" /></p>
        </div>
    </div>
    <div class="overlay"></div>
    <div class="search-bar">
        <div class="search-icon">
            <i class="material-icons">search</i>
        </div>
        <input type="text" placeholder="Comience a escribir.">
        <div class="close-search">
            <i class="material-icons">close</i>
        </div>
    </div>
	<%@include file="../../template/menu-template.jsp" %>
	
    <section class="content">
        <div class="container-fluid">
 			
 			<div class="row clearfix">  
              <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">             
                    <ol class="breadcrumb breadcrumb-bg-grey">
                        <li>
                           	<i class="material-icons">build</i> Administración del Sistema
                        </li>
                        <li>
                           Programas Institucionales
                        </li>
                        <li class="active">
                           <a href="/MISED/administrador/programa-institucional/administracion-programas-institucionales.htm">
                           		<i class="material-icons">view_agenda</i> Administración de Programas Institucionales 
                           </a>
                        </li>
                     </ol>
              </div>
             </div>
 			<div class="row clearfix"> 
 				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <ol class="breadcrumb breadcrumb-bg-grey">
                                <li class="active"><h3>Programas Institucionales del Sistema de Evaluación del Desempeño</h3></li>
                            </ol>
                        </div>
                        <div class="card">
                        <div class="body">
                            <table id="tabla-programas-institucionales" 
                            class="table table-striped display responsive nowrap" 
                            width="100%" cellspacing="0" style="color: black;">
                                <thead>
                                    <tr>
                                        <th>Clave de Programa Institucional</th>
                                        <th>Nombre de Programa Institucional</th>
                                        <th>Descripción de Programa Institucional</th>
                                        <th>Acciones Permitidas</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                              			<th>Clave de Programa Institucional</th>
                                        <th>Nombre de Programa Institucional</th>
                                        <th>Descripción de Programa Institucional</th>
                                        <th>Acciones Permitidas</th>
                                    </tr>
                                </tfoot>
                                <tbody></tbody>
                            </table>
                        </div>
                    </div>
                    </div>
                </div> 
 			</div>
        </div>
        
    
    </section>
    <spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs" />
    <spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs" />
    <spring:url value="/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js" var="jQuerySlimScrollJs" />
	<spring:url value="/resources/plugins/sweetalert/sweetalert.min.js" var="sweetAlertJs" />
	<spring:url value="/resources/plugins/bootstrap-notify/bootstrap-notify.min.js" var="bootstrapNotifyJs" />
	<spring:url value="/resources/plugins/jquery-datatable/jquery.dataTables.js" var="jQueryDataTableJs" />
	<spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.min.js" var="dataTablesBoostrapJs" />
    <spring:url value="/resources/plugins/jquery-datatable/dataTables.responsive.min.js" var="responsiveDataTableJs" />
    <spring:url value="/resources/plugins/jquery-datatable/responsive.bootstrap.min.js" var="responsiveBootstrap" />
	<spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs" />
    <spring:url value="/resources/js/admin.js" var="adminJs" />
    <spring:url value="/resources/js/funciones/constantes.js" var="constantes" />
    <spring:url value="/resources/js/funciones/fx-gestion-programa-institucional.js" var="fxGestionProgramaInstitucional" />
    <spring:url value="/resources/js/funciones/fx-login.js" var="fxLogin" />
    
   

    <spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.html5.min.js" var="buttonsHtml5Js" />
    <spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.print.min.js" var="buttonsPrintJs" />
    <spring:url value="/resources/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js" var="dataTablesButtonsJs" />
    <spring:url value="/resources/plugins/jquery-datatable/extensions/export/jszip.min.js" var="jszipJs" />
    <spring:url value="/resources/plugins/jquery-datatable/extensions/export/pdfmake.min.js" var="pdfmakeJs" />
    <spring:url value="/resources/plugins/jquery-datatable/extensions/export/vfs_fonts.js" var="vfs_fontsJs" />
    <script src="${jQueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${bootstrapSelectJs}"></script>
    <script src="${jQuerySlimScrollJs}"></script>
    <script src="${sweetAlertJs}"></script>
    <script src="${bootstrapNotifyJs}"></script>
    <script src="${jQueryDataTableJs}"></script>
    <script src="${dataTablesBoostrapJs}"></script>
	<script src="${responsiveDataTableJs}"></script>
	<script src="${responsiveBootstrap}"></script>
    <script src="${wavesJs}"></script>
    <script src="${adminJs}"></script>
    <script src="${constantes}"></script>
    <script src="${fxLogin}"></script>
    <script src="${fxGestionProgramaInstitucional}"></script>
    

    <script src="${buttonsHtml5Js}"></script>
    <script src="${buttonsPrintJs}"></script>
    <script src="${dataTablesButtonsJs}"></script>
    <script src="${jszipJs}"></script>
    <script src="${pdfmakeJs}"></script>
    <script src="${vfs_fontsJs}"></script>
</body>
</html>