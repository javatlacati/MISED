<%@include file="../../template/tags.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <sec:csrfMetaTags/>
        <title>MISED :: Administraci&oacute;n de Usuarios</title>
        <link rel="icon" href="../../favicon.ico" type="image/x-icon">
        <spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" var="fontRoboto" />
        <spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons" />
        <spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
        <spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss" />
        <spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss" />
        <spring:url value="/resources/plugins/material-design-preloader/md-preloader.min.css" var="mdPreloaderCss" />
        <spring:url value="/resources/plugins/sweetalert/sweetalert.css" var="sweetAlertCss" />
        <spring:url value="/resources/css/style.min.css" var="styleCss" />
        <spring:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.min.css" var="bootstrapSelectCss" />
        <spring:url value="/resources/css/themes/all-themes.min.css" var="allThemesCss" /> 
        <spring:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.min.css" var="bootstrapSelectCss"/>
        <spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.min.css" var="dataTablesBootstrapCss" />
        <spring:url value="/resources/plugins/jquery-datatable/responsive.dataTables.min.css" var="responsiveDataTableCss"/>
        <link href="${fontRoboto}" rel="stylesheet" type="text/css"/>
        <link href="${materialIcons}" rel="stylesheet" type="text/css"/>
        <link href="${bootstrapCss}" rel="stylesheet" />
        <link href="${wavesCss}" rel="stylesheet" />
        <link href="${animateCss}" rel="stylesheet" />
        <link href="${mdPreloaderCss}" rel="stylesheet" />
        <link href="${sweetAlertCss}" rel="stylesheet" />
        <link href="${styleCss}" rel="stylesheet" />
        <link href="${bootstrapSelectCss}" rel="stylesheet" />
        <link href="${allThemesCss}" rel="stylesheet" />
        <link href="${bootstrapSelectCss}" rel="stylesheet" />
        <link href="${dataTablesBootstrapCss}" rel="stylesheet" />
        <link href="${responsiveDataTableCss}" rel="stylesheet" />
    </head>
    <body class="theme-black">
        <div class="page-loader-wrapper">
            <div class="loader">
                <div class="md-preloader pl-size-md">
                    <svg viewbox="0 0 75 75">
                    <circle cx="37.5" cy="37.5" r="33.5" class="pl-black" stroke-width="4" />
                    </svg>
                </div>
                <p><spring:message code="mensaje.espere" /></p>
            </div>
        </div>
        <div class="overlay"></div>
        
        <%@include file="../../template/menu-template.jsp" %>
        
        <section class="content">
            <div class="container-fluid">
                
                <div class="row clearfix">  
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">             
                        <ol class="breadcrumb breadcrumb-bg-black">
                            <li>
                                <i class="material-icons">build</i> Administraci&oacute;n del Sistema
                            </li>
                            <li>
                                <i class="material-icons">people</i> Usuarios
                            </li>
                            <li class="active">
                                <a href="/MISED/administrador/usuario/administracion-usuarios.htm">
                                    Administraci&oacute;n de Usuarios
                                </a>
                            </li>
                        </ol>
                    </div>
                </div>
                
                <div class="row clearfix"> 
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="header">
                                <ol class="breadcrumb breadcrumb-bg-black">
                                    <li class="active"><h3>Administraci&oacute;n de Usuarios</h3></li>
                                </ol>
                            </div>
                            <div class="body">
                            
                            <div class="row clearfix"> 
                    			
                    			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    				<div id="grafica-usuarios-activos" style="width: 100%;"></div>
                    			</div>
                    			
                    		</div>
<!--                     		<div class="row clearfix">  -->
<!-- 	                   			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12"> -->
<!-- 				                    <div class="info-box hover-zoom-effect"> -->
<!-- 				                        <div class="icon bg-red"> -->
<!-- 				                            <i class="material-icons">account_box</i> -->
<!-- 				                        </div> -->
<!-- 				                        <div class="content"> -->
<!-- 				                            <div class="text">Usuarios no activados</div> -->
<!-- 				                            <div class="number">15</div> -->
<!-- 				                        </div> -->
<!-- 				                    </div> -->
<!-- 				                </div> -->
<!--                    			</div> -->
                            <table id="tabla-usuarios" 
                               class="table table-striped display responsive nowrap text-justify" 
                               width="100%" cellspacing="0" style="color: black;">
                            <thead>
                                <tr>
                                	<th>Clave Programa Institucional</th>
                                	<th>Programa Institucional</th>
                                    <th>&Oacute;rgano de Direcci&oacute;n Estrat&eacute;gica</th>
                                    <th>Unidad de Apoyo</th>
                                    <th>Nombre de Usuario</th>
                                    <th>Nombre</th>
                                    <th>Apellido Paterno</th>
                                    <th>Apellido Materno</th>
                                    <th>Puesto</th>
                                    <th>Extensi&oacute;n</th>
                                    <th>Correo Electronico</th>
                                    <th>Rol</th>
                                    <th>Tipo de Usuario</th>
                                    <th>Fecha de Registro</th>
                                    <th>Hora de Registro</th>
                                    <th>Puede consultar</th>
                                    <th>Puede actualizar</th>
                                    <th>Puede agregar</th>
                                    <th>Puede borrar</th>
                                    <th>Puede autenticarse</th>
                                    <th>Acciones Permitidas</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                	<th>Clave Programa Institucional</th>
                                	<th>Programa Institucional</th>
                                    <th>&Oacute;rgano de Direcci&oacute;n Estrat&eacute;gica</th>
                                    <th>Unidad de Apoyo</th>
                                    <th>Nombre de Usuario</th>
                                    <th>Nombre</th>
                                    <th>Apellido Paterno</th>
                                    <th>Apellido Materno</th>
                                    <th>Puesto</th>
                                    <th>Extensi&oacute;n</th>
                                    <th>Correo Electronico</th>
                                    <th>Rol</th>
                                    <th>Tipo de Usuario</th>
                                    <th>Fecha de Registro</th>
                                    <th>Hora de Registro</th>
                                    <th>Puede consultar</th>
                                    <th>Puede actualizar</th>
                                    <th>Puede agregar</th>
                                    <th>Puede borrar</th>
                                    <th>Puede autenticarse</th>
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
    </section>
    
    <spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs" />
    <spring:url value="/resources/plugins/highcharts-js/highcharts.js" var="highchartsJs" />
    <spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs" />
    <spring:url value="/resources/plugins/sweetalert/sweetalert.min.js" var="sweetAlertJs" />
    <spring:url value="/resources/plugins/jquery-datatable/jquery.dataTables.js" var="jQueryDataTableJs" />
    <spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.min.js" var="dataTablesBoostrapJs" />
    <spring:url value="/resources/plugins/jquery-datatable/dataTables.responsive.min.js" var="responsiveDataTableJs" />
    <spring:url value="/resources/plugins/jquery-datatable/responsive.bootstrap.min.js" var="responsiveBootstrap" />
    <spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs" />
    <spring:url value="/resources/js/admin.js" var="adminJs" />
    <spring:url value="/resources/js/funciones/constantes.js" var="constantes" />
    <spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>
    
    <spring:url value="/resources/js/funciones/usuario/fx-administracion-usuario.js" var="fxAdministracionUsuario" />
    <spring:url value="/resources/js/funciones/prototipos/usuario.js" var="usuario" />
    
    <spring:url value="/resources/js/funciones/fx-login.js" var="fxLogin" />
    
    <script src="${jQueryJs}"></script>
    <script src="${highchartsJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${bootstrapSelectJs}"></script>
    <script src="${sweetAlertJs}"></script>
    <script src="${jQueryDataTableJs}"></script>
    <script src="${dataTablesBoostrapJs}"></script>
    <script src="${responsiveDataTableJs}"></script>
    <script src="${responsiveBootstrap}"></script>
    <script src="${wavesJs}"></script>
    <script src="${adminJs}"></script>
    <script src="${constantes}"></script>
    <script src="${bootstrapSelectJs}"></script>
    <script src="${fxLogin}"></script>
    <script src="${usuario}"></script> 
    <script src="${fxAdministracionUsuario}"></script>
    
</body>
</html>
