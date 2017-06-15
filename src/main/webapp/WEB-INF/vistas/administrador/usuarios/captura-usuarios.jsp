<%@include file="../../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <sec:csrfMetaTags/>
    <title>MISED :: Captura de usuario </title>
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
    <spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
                var="fontRoboto"/>
    <spring:url value="/resources/plugins/font-awesome/css/font-awesome.min.css"
                var="fontAwesome"/>
    <spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons"/>
    <%--<spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>--%>
    <%--<spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss" />--%>
    <%--<spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss" />--%>
    <%--<spring:url value="/resources/plugins/material-design-preloader/md-preloader.min.css" var="mdPreloaderCss" />--%>
    <spring:url value="/resources/plugins/sweetalert/sweetalert.min.css" var="sweetAlertCss"/>
    <%--<spring:url value="/resources/css/style.min.css" var="styleCss" />--%>
    <%--<spring:url value="/resources/css/themes/all-themes.min.css" var="allThemesCss" /> --%>
    <%--<spring:url value="/resources/plugins/remodal/remodal-default-theme.css" var="remodalDefaultThemeCss" />--%>
    <%--<spring:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.min.css" var="bootstrapSelectCss"/>--%>
    <spring:url value="/resources/plugins/materialize/css/materialize.min.css" var="materializeCss"/>
    <spring:url value="/resources/plugins/datatables/css/dataTables.material.min.css"
                var="dataTablesBootstrapCss"/>
    <%--<spring:url value="/resources/plugins/jquery-datatable/responsive.dataTables.min.css" var="responsiveDataTableCss"/>--%>
    <link href="${fontRoboto}" rel="stylesheet" type="text/css">
    <link href="${fontAwesome}" rel="stylesheet" type="text/css">
    <link href="${materialIcons}" rel="stylesheet" type="text/css">
    <%--<link href="${bootstrapCss}" rel="stylesheet">--%>
    <%--<link href="${wavesCss}" rel="stylesheet" />--%>
    <%--<link href="${animateCss}" rel="stylesheet" />--%>
    <%--<link href="${mdPreloaderCss}" rel="stylesheet" />--%>
    <link href="${sweetAlertCss}" rel="stylesheet">
    <%--<link href="${styleCss}" rel="stylesheet">--%>
    <%--<link href="${allThemesCss}" rel="stylesheet" />--%>
    <%--<link href="${bootstrapSelectCss}" rel="stylesheet" />--%>
    <link href="${dataTablesBootstrapCss}" rel="stylesheet"/>
    <%--<link href="${responsiveDataTableCss}" rel="stylesheet"/>--%>
    <%--<link href="${remodalDefaultThemeCss}" rel="stylesheet" />--%>
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

        <nav class="container grey darken-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="<c:url value='#' />" class="breadcrumb">
                        Administraci&oacute;n del Sistema
                    </a>
                    <a href="<c:url value='#' />" class="breadcrumb">
                        <i class="material-icons">people</i> Usuarios
                    </a>
                    <a href="<c:url value='/administrador/usuario/captura-usuarios.htm' />"
                       class="breadcrumb">
                        Captura de Usuarios
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
                            <h3>Captura de Usuario</h3>
                        </div>
                    </div>
                    <div class="body" style="padding: 32px;">
                        <form method="POST" id="frm-registro-usuario">
                            <fieldset>
                                <div class="col l12 m12 cols12">
                                    <p>
                                        <b>Seleccione la Unidad de Apoyo para este Usuario:</b>
                                    </p>
                                    <select class="form-control" name="idUnidadApoyo" id="selector-id-unidadApoyo"
                                            data-size="5" data-live-search="true">
                                    </select>
                                </div>

                                <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="identidad" id="identidad"
                                                   class="form-control" autocomplete="off" maxlength="18"/>
                                            <label class="form-label">Nombre de usuario</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-12 col-md-6 col-lg-6">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="clave-acceso" id="clave-acceso"
                                                   class="form-control" autocomplete="off" maxlength="20"/>
                                            <label class="form-label">Contrase&ntilde;a</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-6 col-lg-6">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="verificacion-claveAcceso"
                                                   id="verificacion-claveAcceso"
                                                   class="form-control" autocomplete="off" maxlength="20"/>
                                            <label class="form-label">Repita la contrase&ntilde;a</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="nombre" id="nombre"
                                                   class="form-control" autocomplete="off" maxlength="50"/>
                                            <label class="form-label">Nombre</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="apellido-paterno" id="apellido-paterno"
                                                   class="form-control" autocomplete="off" maxlength="50"/>
                                            <label class="form-label">Apellido Paterno</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="apellido-materno" id="apellido-materno"
                                                   class="form-control" autocomplete="off" maxlength="50"/>
                                            <label class="form-label">Apellido Materno</label>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="puesto-laboral" id="puesto-laboral"
                                                   class="form-control" autocomplete="off" maxlength="120"/>
                                            <label class="form-label">Puesto Laboral</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="correo-electronico" id="correo-electronico"
                                                   class="form-control" autocomplete="off" maxlength="120"/>
                                            <label class="form-label">E-mail</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="extension-telefonica" id="extension-telefonica"
                                                   class="form-control" autocomplete="off" maxlength="14"/>
                                            <label class="form-label">Extensi&oacute;n telefonica</label>
                                        </div>
                                    </div>
                                </div>


                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <p>
                                        <b>Seleccione un rol para este usuario:</b>
                                    </p>
                                    <select class="form-control show-tick" name="selector-rol-usuario"
                                            id="selector-rol-usuario"
                                            data-size="5" data-live-search="true">
                                        <option value="ROLE_USUARIO" selected="selected">Rol de Usuario</option>
                                        <option value="ROLE_ADMINISTRADOR">Rol de Administrador</option>
                                    </select>
                                </div>

                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <p>
                                        <b>Permisos de usuario:</b>
                                    </p>
                                    <select class="form-control show-tick" multiple
                                            title="Seleccione los permisos de usuario"
                                            name="selector-permisos-usuario" id="selector-permisos-usuario"
                                            data-size="5" data-live-search="true">
                                        <option value="CONSULTAR">Consultar registros</option>
                                        <option value="ACTUALIZAR">Actualizar registros</option>
                                        <option value="AGREGAR">Agregar registros</option>
                                        <option value="BORRAR">Borrar registros</option>
                                    </select>
                                </div>

                                <div class="col-sm-12 col-md-4 col-lg-4">
                                    <p>
                                        <b>Tipo de usuario:</b>
                                    </p>
                                    <select class="form-control show-tick" name="selector-tipo-usuario"
                                            id="selector-tipo-usuario" data-size="5" data-live-search="true">
                                        <option value="ENLACE" selected="selected">Enlace</option>
                                        <option value="TITULAR">Titular</option>
                                    </select>
                                </div>

                                <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="form-group form-float">
                                        <button type="button" class="btn btn-success waves-effect"
                                                onclick="capturarUsuario();">Guardar usuario
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
</section>

<%--<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>--%>
<%--<spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>--%>
<%--<spring:url value="/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js" var="jQuerySlimScrollJs"/>--%>
<spring:url value="/resources/plugins/sweetalert/sweetalert.min.js" var="sweetAlertJs"/>
<spring:url value="/resources/plugins/datatables/js/jquery.dataTables.js" var="jQueryDataTableJs"/>
<spring:url value="/resources/plugins/datatables/js/dataTables.material.js"
            var="dataTablesBoostrapJs"/>
<%--skin/bootstrap/js/dataTables.bootstrap.min.js--%>
<%--<spring:url value="/resources/plugins/jquery-datatable/dataTables.responsive.min.js" var="responsiveDataTableJs"/>--%>
<%--<spring:url value="/resources/plugins/jquery-datatable/responsive.bootstrap.min.js" var="responsiveBootstrap"/>--%>
<%--<spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs"/>--%>
<spring:url value="/resources/js/admin.js" var="adminJs"/>
<spring:url value="/resources/js/funciones/constantes.js" var="constantes"/>
<spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>

<spring:url value="/resources/js/funciones/usuario/fx-captura-usuario.js" var="fxCapturaUsuario"/>
<spring:url value="/resources/js/funciones/prototipos/usuario.js" var="usuario"/>


<spring:url value="/resources/js/funciones/fx-login.js" var="fxLogin"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.html5.min.js" var="buttonsHtml5Js"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.print.min.js" var="buttonsPrintJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"
            var="dataTablesButtonsJs"/>
<%--<spring:url value="/resources/plugins/jquery-datatable/extensions/export/jszip.min.js" var="jszipJs"/>--%>
<%--<spring:url value="/resources/plugins/jquery-datatable/extensions/export/pdfmake.min.js" var="pdfmakeJs"/>--%>
<%--<spring:url value="/resources/plugins/jquery-datatable/extensions/export/vfs_fonts.js" var="vfs_fontsJs"/>--%>

<%--<script src="${jQueryJs}"></script>--%>
<%--<script src="${bootstrapJs}"></script>--%>
<script src="${bootstrapSelectJs}"></script>
<%--<script src="${jQuerySlimScrollJs}"></script>--%>
<script src="${sweetAlertJs}"></script>
<script src="${jQueryDataTableJs}"></script>
<script src="${dataTablesBoostrapJs}"></script>
<%--<script src="${responsiveDataTableJs}"></script>--%>
<%--<script src="${responsiveBootstrap}"></script>--%>
<%--<script src="${wavesJs}"></script>--%>
<script src="${adminJs}"></script>
<script src="${constantes}"></script>
<script src="${bootstrapSelectJs}"></script>
<script src="${fxLogin}"></script>
<script src="${usuario}"></script>
<script src="${fxCapturaUsuario}"></script>
<script src="${buttonsHtml5Js}"></script>
<script src="${buttonsPrintJs}"></script>
<script src="${dataTablesButtonsJs}"></script>
<%--<script src="${jszipJs}"></script>--%>
<%--<script src="${pdfmakeJs}"></script>--%>
<%--<script src="${vfs_fontsJs}"></script>--%>
</body>
</html>
