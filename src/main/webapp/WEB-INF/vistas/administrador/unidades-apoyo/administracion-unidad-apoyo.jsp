<%@include file="../../template/tags.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <sec:csrfMetaTags/>
        <title>MISED :: Administraci&oacute;n de Unidades de Apoyo </title>
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
                                <i class="material-icons">view_agenda</i> Unidades de Apoyo
                            </li>
                            <li class="active">
                                <a href="/MISED/administrador/unidad-apoyo/administracion-unidades-apoyo.htm">
                                    Administraci&oacute;n de Unidades de Apoyo
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
                                    <li class="active"><h3>Captura de Unidad de Apoyo</h3></li>
                                </ol>
                            </div>
                            <div class="body">																		
                                <form method="POST" id="frm-registro-unidad-apoyo">
                                    <fieldset>
                                        <div class="col-sm-12 col-md-12 col-lg-12">
                                            <p>
                                                <b>Seleccione el &Oacute;rgano de direcci&oacute;n estrat&eacute;gico para esta nueva unidad de apoyo:</b>
                                            </p>
                                            <select class="form-control show-tick" name="idOrganoDireccionEstrategica" 
                                            id="selector-id-organoDireccionEstrategica" data-size="5" data-live-search="true">
                                            </select>
                                        </div>
                                        <div class="col-sm-12 col-md-12 col-lg-12">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <input type="text" name="nombre" id="nuevo-nombre" 
                                                           class="form-control" autocomplete="off" maxlength="100" />
                                                    <label class="form-label">Nombre de la unidad de apoyo</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-12 col-lg-12">
                                            <div class="form-group form-float">
                                                <div class="form-line">
                                                    <textarea name="proposito" id="nuevo-proposito"
                                                                   maxlength="1200" class="form-control"></textarea>
                                                        <label class="form-label">Proposito de la Unidad de Apoyo</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <button type="button" class="btn btn-success waves-effect" 
                                                            onclick="capturaUnidadApoyo();">Guardar unidad de apoyo</button>
                                                </div>
                                            </div>
                                        </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
            
            <div class="row clearfix"> 
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <ol class="breadcrumb breadcrumb-bg-black">
                                <li class="active"><h3>Busqueda y Actualizaci&oacute;n de Unidades de Apoyo</h3></li>
                            </ol>
                        </div>
                        
                        <div class="body">
                            <table id="tabla-unidades-apoyo" 
                                   class="table table-striped display responsive nowrap text-justify" 
                                   width="100%" cellspacing="0" style="color: black;">
                                <thead>
                                    <tr>
                                    	<th>Clave Programa Institucional</th>
                                    	<th>Programa Institucional</th>
                                        <th>&Oacute;rgano de Direcci&oacute;n Estrat&eacute;gica</th>
                                        <th>Unidad de Apoyo</th>
                                        <th>Total de usuarios adscritos</th>
                                        <th>Acciones Permitidas</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                    	<th>Clave Programa Institucional</th>
                                    	<th>Programa Institucional</th>
                                        <th>&Oacute;rgano de Direcci&oacute;n Estrat&eacute;gica</th>
                                        <th>Unidad de Apoyo</th>
                                        <th>Total de usuarios adscritos</th>
                                        <th>Acciones Permitidas</th>
                                    </tr>
                                </tfoot>
                                <tbody></tbody>
                            </table>
                            <div class="modal fade" id="modal-actualizacion-unidad-apoyo" tabindex="-1" role="dialog">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title" id="defaultModalLabel">Editar Unidad de Apoyo</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form:form methodParam="POST" commandName="unidadApoyo" id="frm-actualizar-unidad-apoyo" htmlEscape="true">
                                                <fieldset>
	                                                <div class="col-sm-12 col-md-12 col-lg-12">
			                                            <p>
			                                                <b>Seleccione el &oacute;rgano de direcci&oacute;n estrat&eacute;gico para esta nueva unidad de apoyo:</b>
			                                            </p>
			                                            <select class="form-control show-tick" name="idOrganoDireccionEstrategica" 
			                                            id="selector-actualizacion-id-organo-direccion-estrategica" data-size="5" data-live-search="true">
			                                            </select>
			                                        </div>
                                                    <div class="col-sm-12 col-md-12 col-lg-12">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <form:input type="hidden" path="idUnidadApoyo" id="idUnidadApoyo" />
                                                                <form:input type="text" path="nombre" id="nombre" cssClass="form-control" autocomplete="off" maxlength="100" /> 
                                                                <label class="form-label">Nombre de la Unidad de Apoyo</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-12 col-md-12 col-lg-12">
                                                        <div class="form-group form-float">
                                                            <div class="form-line">
                                                                <form:textarea path="proposito" id="proposito" maxlength="1200" cssClass="form-control"></form:textarea>
                                                                    <label class="form-label">Prop&oacute;sito de esta Unidad de Apoyo</label>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </fieldset>
                                            </form:form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-success waves-effect" 
                                                    onclick="realizarActualizacionUnidadApoyo();">Guardar cambios</button>
                                            <button type="button" class="btn bg-red waves-effect" data-dismiss="modal">Cancelar</button>
                                        </div>
                                    </div>
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
    <spring:url value="/resources/plugins/jquery-datatable/jquery.dataTables.js" var="jQueryDataTableJs" />
    <spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.min.js" var="dataTablesBoostrapJs" />
    <spring:url value="/resources/plugins/jquery-datatable/dataTables.responsive.min.js" var="responsiveDataTableJs" />
    <spring:url value="/resources/plugins/jquery-datatable/responsive.bootstrap.min.js" var="responsiveBootstrap" />
    <spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs" />
    <spring:url value="/resources/js/admin.js" var="adminJs" />
    <spring:url value="/resources/js/funciones/constantes.js" var="constantes" />
    <spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>
    
    <spring:url value="/resources/js/funciones/administracion-unidad-apoyo/fx-administracion-unidad-apoyo.js" var="fxAdministracionUnidadApoyo" />
    <spring:url value="/resources/js/funciones/prototipos/unidad-apoyo.js" var="prototypeUnidadApoyo" />
    
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
    <script src="${jQueryDataTableJs}"></script>
    <script src="${dataTablesBoostrapJs}"></script>
    <script src="${responsiveDataTableJs}"></script>
    <script src="${responsiveBootstrap}"></script>
    <script src="${wavesJs}"></script>
    <script src="${adminJs}"></script>
    <script src="${constantes}"></script>
    <script src="${bootstrapSelectJs}"></script>
    <script src="${fxLogin}"></script>
    <script src="${prototypeUnidadApoyo}"></script> 
    <script src="${fxAdministracionUnidadApoyo}"></script>
    <script src="${buttonsHtml5Js}"></script>
    <script src="${buttonsPrintJs}"></script>
    <script src="${dataTablesButtonsJs}"></script>
    <script src="${jszipJs}"></script>
    <script src="${pdfmakeJs}"></script>
    <script src="${vfs_fontsJs}"></script>
</body>
</html>
