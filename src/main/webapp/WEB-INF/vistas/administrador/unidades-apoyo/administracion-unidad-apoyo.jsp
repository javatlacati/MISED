<%@include file="../../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <sec:csrfMetaTags/>
    <title>MISED :: Administraci&oacute;n de Unidades de Apoyo </title>
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
    <spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
                var="fontRoboto"/>
    <spring:url value="/resources/plugins/font-awesome/css/font-awesome.min.css"
                var="fontAwesome"/>
    <spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons"/>
    <%--<spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />--%>
    <%--<spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss" />--%>
    <%--<spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss" />--%>
    <%--<spring:url value="/resources/plugins/material-design-preloader/md-preloader.min.css" var="mdPreloaderCss" />--%>
    <spring:url value="/resources/plugins/sweetalert/sweetalert.css" var="sweetAlertCss"/>
    <%--<spring:url value="/resources/css/style.min.css" var="styleCss" />--%>
    <%--<spring:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.min.css" var="bootstrapSelectCss" />--%>
    <%--<spring:url value="/resources/css/themes/all-themes.min.css" var="allThemesCss" /> --%>
    <%--<spring:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.min.css" var="bootstrapSelectCss"/>--%>
    <%--<spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.min.css" var="dataTablesBootstrapCss" />--%>
    <spring:url value="/resources/plugins/materialize/css/materialize.min.css" var="materializeCss"/>
    <spring:url value="/resources/plugins/datatables/css/dataTables.material.min.css"
                var="dataTablesBootstrapCss"/>
    <%--<spring:url value="/resources/plugins/jquery-datatable/responsive.dataTables.min.css" var="responsiveDataTableCss"/>--%>
    <link href="${fontRoboto}" rel="stylesheet" type="text/css"/>
    <link href="${fontAwesome}" rel="stylesheet" type="text/css">
    <link href="${materialIcons}" rel="stylesheet" type="text/css"/>
    <%--<link href="${bootstrapCss}" rel="stylesheet" />--%>
    <%--<link href="${wavesCss}" rel="stylesheet" />--%>
    <%--<link href="${animateCss}" rel="stylesheet" />--%>
    <%--<link href="${mdPreloaderCss}" rel="stylesheet" />--%>
    <link href="${sweetAlertCss}" rel="stylesheet"/>
    <%--<link href="${styleCss}" rel="stylesheet" />--%>
    <%--<link href="${bootstrapSelectCss}" rel="stylesheet" />--%>
    <%--<link href="${allThemesCss}" rel="stylesheet" />--%>
    <%--<link href="${bootstrapSelectCss}" rel="stylesheet" />--%>
    <link href="${dataTablesBootstrapCss}" rel="stylesheet"/>
    <%--<link href="${responsiveDataTableCss}" rel="stylesheet" />--%>
    <link href="${materializeCss}" rel="stylesheet"/>
    <spring:url value="/resources/css/custom.min.css" var="custom"/>
    <link href="${custom}" rel="stylesheet">
    <spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs"/>
    <spring:url value="/resources/plugins/materialize/js/materialize.min.js" var="materializeJS"/>
    <!-- Jquery Core Js -->
    <script src="${jQueryJs}"></script>
    <script src="${materializeJS}"></script>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function () {
            $('.preloader-background').delay(1700).fadeOut('slow');

            $('.preloader-wrapper')
                .delay(1700)
                .fadeOut();
        });
    </script>
    <style>
        .preloader-background {
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #fff;

            position: fixed;
            z-index: 100;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
    </style>
</head>
<body>
<div class="preloader-background">
    <spring:url value="/resources/images/logo senado 100x100 animado.svg" var="senadoAnimado"/>
    <img src="${senadoAnimado}" width="250" height="250">
    <p><spring:message code="mensaje.espere"/></p>
</div>

<%@include file="../../template/menu-template.jsp" %>

<section class="content">
    <div class="container-fluid">
        <div class="section hide-on-small-only"></div>
        <div class="section hide-on-small-only"></div>

        <nav class="container grey darken-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="<c:url value='#' />" class="breadcrumb">
                        Administraci&oacute;n del Sistema
                    </a>
                    <a href="<c:url value='#' />" class="breadcrumb">
                        <i class="material-icons">view_agenda</i> Unidades de Apoyo
                    </a>
                    <a href="<c:url value='/administrador/unidad-apoyo/administracion-unidades-apoyo.htm' />"
                       class="breadcrumb">
                        Administraci&oacute;n de Unidades de Apoyo
                    </a>

                </div>
            </div>
        </nav>
        <div class="section hide-on-small-only"></div>

        <div class="row clearfix">
            <div class="col l12 m12 cols12 xs12">
                <div class="card">
                    <div class="header">
                        <div class="card-title grey darken-1 white-text">
                            <h3>Captura de Unidad de Apoyo</h3>
                        </div>
                    </div>
                    <div class="body">
                        <form method="POST" id="frm-registro-unidad-apoyo">
                            <fieldset>
                                <div class="col s12 m12 l12">
                                    <p>
                                        <b>Seleccione el &Oacute;rgano de direcci&oacute;n estrat&eacute;gico para esta
                                            nueva unidad de apoyo:</b>
                                    </p>
                                    <select class="form-control show-tick" name="idOrganoDireccionEstrategica"
                                            id="selector-id-organoDireccionEstrategica" data-size="5"
                                            data-live-search="true">
                                    </select>
                                </div>
                                <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="nombre" id="nuevo-nombre"
                                                   class="form-control" autocomplete="off" maxlength="100"/>
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
                                                onclick="capturaUnidadApoyo();">Guardar unidad de apoyo
                                        </button>
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
                                    <form:form methodParam="POST" commandName="unidadApoyo"
                                               id="frm-actualizar-unidad-apoyo" htmlEscape="true">
                                        <fieldset>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <p>
                                                    <b>Seleccione el &oacute;rgano de direcci&oacute;n estrat&eacute;gico
                                                        para esta nueva unidad de apoyo:</b>
                                                </p>
                                                <select class="form-control show-tick"
                                                        name="idOrganoDireccionEstrategica"
                                                        id="selector-actualizacion-id-organo-direccion-estrategica"
                                                        data-size="5" data-live-search="true">
                                                </select>
                                            </div>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <form:input type="hidden" path="idUnidadApoyo"
                                                                    id="idUnidadApoyo"/>
                                                        <form:input type="text" path="nombre" id="nombre"
                                                                    cssClass="form-control" autocomplete="off"
                                                                    maxlength="100"/>
                                                        <label class="form-label">Nombre de la Unidad de Apoyo</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <form:textarea path="proposito" id="proposito" maxlength="1200"
                                                                       cssClass="form-control"></form:textarea>
                                                        <label class="form-label">Prop&oacute;sito de esta Unidad de
                                                            Apoyo</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                    </form:form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-success waves-effect"
                                            onclick="realizarActualizacionUnidadApoyo();">Guardar cambios
                                    </button>
                                    <button type="button" class="btn bg-red waves-effect" data-dismiss="modal">
                                        Cancelar
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

<spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs"/>
<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>
<%--<spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>--%>
<spring:url value="/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js" var="jQuerySlimScrollJs"/>
<spring:url value="/resources/plugins/sweetalert/sweetalert.min.js" var="sweetAlertJs"/>
<spring:url value="/resources/plugins/datatables/js/jquery.dataTables.min.js" var="jQueryDataTableJs"/>
<spring:url value="/resources/plugins/datatables/js/dataTables.material.min.js"
            var="dataTablesMaterialJs"/>
<%--<spring:url value="/resources/plugins/datatables/dataTables.responsive.min.js" var="responsiveDataTableJs"/>--%>
<%--<spring:url value="/resources/plugins/datatables/js/responsive.bootstrap.min.js" var="responsiveBootstrap"/>--%>
<%--<spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs"/>--%>
<spring:url value="/resources/js/admin.js" var="adminJs"/>
<spring:url value="/resources/js/funciones/constantes.js" var="constantes"/>
<%--<spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>--%>

<spring:url value="/resources/js/funciones/administracion-unidad-apoyo/fx-administracion-unidad-apoyo.js"
            var="fxAdministracionUnidadApoyo"/>
<spring:url value="/resources/js/funciones/prototipos/unidad-apoyo.js" var="prototypeUnidadApoyo"/>

<spring:url value="/resources/js/funciones/fx-login.js" var="fxLogin"/>
<spring:url value="/resources/plugins/datatables/extensions/export/buttons.html5.min.js" var="buttonsHtml5Js"/>
<spring:url value="/resources/plugins/datatables/extensions/export/buttons.print.min.js" var="buttonsPrintJs"/>
<spring:url value="/resources/plugins/datatables/extensions/export/dataTables.buttons.min.js"
            var="dataTablesButtonsJs"/>
<%--<spring:url value="/resources/plugins/jquery-datatable/extensions/export/jszip.min.js" var="jszipJs"/>--%>
<%--<spring:url value="/resources/plugins/jquery-datatable/extensions/export/pdfmake.min.js" var="pdfmakeJs"/>--%>
<%--<spring:url value="/resources/plugins/jquery-datatable/extensions/export/vfs_fonts.js" var="vfs_fontsJs"/>--%>

<%--<script src="${jQueryJs}"></script>--%>
<%--<script src="${bootstrapJs}"></script>--%>
<%--<script src="${bootstrapSelectJs}"></script>--%>
<%--<script src="${jQuerySlimScrollJs}"></script>--%>
<script src="${sweetAlertJs}"></script>
<script src="${jQueryDataTableJs}"></script>
<script src="${dataTablesMaterialJs}"></script>
<%--<script src="${responsiveDataTableJs}"></script>--%>
<%--<script src="${responsiveBootstrap}"></script>--%>
<%--<script src="${wavesJs}"></script>--%>
<script src="${adminJs}"></script>
<script src="${constantes}"></script>
<%--<script src="${bootstrapSelectJs}"></script>--%>
<script src="${fxLogin}"></script>
<script>
    var pathws = "${pageContext.request.serverName}";//contextPath
    var appName = "${pageContext.servletContext.contextPath}";
    var portNumber = "${pageContext.request.serverPort}";
    console.log("pathws:" + pathws);
    console.log("appName:" + appName);
    console.log("portNumber:" + portNumber);
</script>
<script src="${prototypeUnidadApoyo}"></script>
<script src="${fxAdministracionUnidadApoyo}"></script>
<script src="${buttonsHtml5Js}"></script>
<script src="${buttonsPrintJs}"></script>
<script src="${dataTablesButtonsJs}"></script>
<%--<script src="${jszipJs}"></script>--%>
<%--<script src="${pdfmakeJs}"></script>--%>
<%--<script src="${vfs_fontsJs}"></script>--%>
<script>
    $(".button-collapsable").sideNav({
        menuWidth: 450, // Default is 300
        edge: 'left', // Choose the horizontal origin
        closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
        draggable: true // Choose whether you can drag to open on touch screens
    });
</script>
</body>
</html>
