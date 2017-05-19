<%@include file="../../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <sec:csrfMetaTags/>
    <title>MISED :: Administración de Programas Institucionales</title>
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
    <spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
                var="fontRoboto"/>
    <spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons"/>
    <spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
    <%--<spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss" />--%>
    <%--<spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss" />--%>
    <%--<spring:url value="/resources/plugins/material-design-preloader/md-preloader.min.css" var="mdPreloaderCss" />--%>
    <spring:url value="/resources/plugins/sweetalert/sweetalert.css" var="sweetAlertCss"/>
    <%--<spring:url value="/resources/css/style.min.css" var="styleCss" />--%>
    <%--<spring:url value="/resources/css/themes/all-themes.min.css" var="allThemesCss" /> --%>
    <%--<spring:url value="/resources/plugins/remodal/remodal-default-theme.css" var="remodalDefaultThemeCss" />--%>
    <%--<spring:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.min.css" var="bootstrapSelectCss"/>--%>
    <spring:url value="/resources/plugins/materialize-css/css/materialize.css" var="materializeCss"/>
    <spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.min.css"
                var="dataTablesBootstrapCss"/>
    <spring:url value="/resources/plugins/jquery-datatable/responsive.dataTables.min.css" var="responsiveDataTableCss"/>
    <link href="${fontRoboto}" rel="stylesheet" type="text/css">
    <link href="${materialIcons}" rel="stylesheet" type="text/css">
    <link href="${bootstrapCss}" rel="stylesheet">
    <%--<link href="${wavesCss}" rel="stylesheet" />--%>
    <%--<link href="${animateCss}" rel="stylesheet" />--%>
    <%--<link href="${mdPreloaderCss}" rel="stylesheet" />--%>
    <link href="${sweetAlertCss}" rel="stylesheet">
    <%--<link href="${styleCss}" rel="stylesheet">--%>
    <%--<link href="${allThemesCss}" rel="stylesheet" />--%>
    <%--<link href="${bootstrapSelectCss}" rel="stylesheet" />--%>
    <link href="${dataTablesBootstrapCss}" rel="stylesheet"/>
    <link href="${responsiveDataTableCss}" rel="stylesheet"/>
    <%--<link href="${remodalDefaultThemeCss}" rel="stylesheet" />--%>
    <link href="${materializeCss}" rel="stylesheet"/>
    <spring:url value="/resources/css/custom.min.css" var="custom"/>
    <link href="${custom}" rel="stylesheet">
    <spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs"/>
    <spring:url value="/resources/plugins/materialize-css/js/materialize.js" var="materializeJS"/>
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
            background-color: #aee;

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
    <div class="preloader-wrapper active">
        <div class="spinner-layer spinner-red-only">
            <div class="circle-clipper left">
                <div class="circle"></div>
            </div>
            <div class="gap-patch">
                <div class="circle"></div>
            </div>
            <div class="circle-clipper right">
                <div class="circle"></div>
            </div>
        </div>
    </div>
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
                        Programas Institucionales
                    </a>
                    <a href="<c:url value='/administrador/programa-institucional/administracion-programas-institucionales.htm' />"
                       class="breadcrumb">
                        Administraci&oacute;n de Programas Institucionales
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
                            <h3>Captura de Programa Institucional</h3>
                        </div>
                    </div>
                    <div class="body" style="padding: 32px;">
                        <form:form methodParam="POST" commandName="programaInstitucional"
                                   id="frm-Registro-Programa-Institucional" htmlEscape="true">
                            <fieldset>
                                <div class="col s12 m12 l12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <form:input type="text" path="clave" id="nueva-clave"
                                                        cssClass="form-control" autocomplete="off" maxlength="100"/>
                                            <label class="form-label">Clave del programa institucional</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col s12 m12 l12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <form:input type="text" path="nombre" id="nuevo-nombre"
                                                        cssClass="form-control" autocomplete="off" maxlength="250"/>
                                            <label class="form-label">Nombre del programa institucional</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col s12 m12 l12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <form:textarea path="descripcion" id="nueva-descripcion"
                                                           maxlength="1200" cssClass="form-control"></form:textarea>
                                            <label class="form-label">Descripci&oacute;n del programa
                                                institucional</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col s12 m12 l12">
                                    <div class="form-group form-float">
                                        <button type="button" class="btn btn-success waves-effect"
                                                onclick="capturaProgramaInstitucional();">Guardar programa institucional
                                        </button>
                                    </div>
                                </div>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col l12 m12 s12 xs12">
            <div class="card">
                <div class="header">
                    <div class="card-title grey darken-1 white-text">
                        <h3>Busqueda y Actualización de Programas Institucionales</h3>
                    </div>
                </div>
                <div class="body">

                    <table id="tabla-programas-institucionales"
                           class="table table-striped display responsive nowrap text-justify"
                           width="100%" cellspacing="0" style="color: black;">
                        <thead>
                        <tr>
                            <th>Clave de Programa Institucional</th>
                            <th>Nombre de Programa Institucional</th>
                            <th>Descripci&oacute;n de Programa Institucional</th>
                            <th>Acciones Permitidas</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Clave de Programa Institucional</th>
                            <th>Nombre de Programa Institucional</th>
                            <th>Descripci&oacute;n de Programa Institucional</th>
                            <th>Acciones Permitidas</th>
                        </tr>
                        </tfoot>
                        <tbody></tbody>
                    </table>


                    <div class="modal fade" id="modal-actualizacion-programa-institucional" tabindex="-1" role="dialog">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="defaultModalLabel">Editar Programa Institucional</h4>
                                </div>
                                <div class="modal-body">
                                    <form:form methodParam="POST" commandName="programaInstitucional"
                                               id="frm-Actualizar-Programa-Institucional" htmlEscape="true">
                                        <fieldset>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <form:input type="hidden" path="idProgramaInstitucional"
                                                                    id="idProgramaInstitucional"/>
                                                        <form:input type="text" path="clave" id="clave"
                                                                    cssClass="form-control" autocomplete="off"
                                                                    maxlength="100"/>
                                                        <label class="form-label">Clave del programa
                                                            institucional</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <form:input type="text" path="nombre" id="nombre"
                                                                    cssClass="form-control"
                                                                    autocomplete="off" maxlength="250"/>
                                                        <label class="form-label">Nombre del programa
                                                            institucional</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <form:textarea path="descripcion" id="descripcion"
                                                                       maxlength="1200"
                                                                       cssClass="form-control"></form:textarea>
                                                        <label class="form-label">Descripci&oacute;n del programa
                                                            institucional</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </fieldset>
                                    </form:form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-success waves-effect"
                                            onclick="realizarActualizacionProgramaInstitucional();">Guardar cambios
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

<%--<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>--%>
<spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>
<spring:url value="/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js" var="jQuerySlimScrollJs"/>
<spring:url value="/resources/plugins/sweetalert/sweetalert.min.js" var="sweetAlertJs"/>
<spring:url value="/resources/plugins/jquery-datatable/jquery.dataTables.js" var="jQueryDataTableJs"/>
<spring:url value="/resources/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.min.js"
            var="dataTablesBoostrapJs"/>
<spring:url value="/resources/plugins/jquery-datatable/dataTables.responsive.min.js" var="responsiveDataTableJs"/>
<spring:url value="/resources/plugins/jquery-datatable/responsive.bootstrap.min.js" var="responsiveBootstrap"/>
<spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs"/>
<spring:url value="/resources/js/admin.js" var="adminJs"/>
<spring:url value="/resources/js/funciones/constantes.js" var="constantes"/>
<spring:url value="/resources/js/funciones/fx-administracion-programa-institucional.js"
            var="fxAdministracionProgramaInstitucional"/>
<spring:url value="/resources/js/funciones/prototipos/programa-institucional.js" var="prototypeProgramaInstitucional"/>
<spring:url value="/resources/js/funciones/fx-login.js" var="fxLogin"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.html5.min.js" var="buttonsHtml5Js"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.print.min.js" var="buttonsPrintJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"
            var="dataTablesButtonsJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/jszip.min.js" var="jszipJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/pdfmake.min.js" var="pdfmakeJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/vfs_fonts.js" var="vfs_fontsJs"/>

<%--<script src="${jQueryJs}"></script>--%>
<%--<script src="${bootstrapJs}"></script>--%>
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
<script src="${fxLogin}"></script>
<script src="${prototypeProgramaInstitucional}"></script>
<script src="${fxAdministracionProgramaInstitucional}"></script>
<script src="${buttonsHtml5Js}"></script>
<script src="${buttonsPrintJs}"></script>
<script src="${dataTablesButtonsJs}"></script>
<script src="${jszipJs}"></script>
<script src="${pdfmakeJs}"></script>
<script src="${vfs_fontsJs}"></script>
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
