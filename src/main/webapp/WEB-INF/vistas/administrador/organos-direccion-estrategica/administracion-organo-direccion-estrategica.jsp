<%@include file="../../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <sec:csrfMetaTags/>
    <title><spring:message code="mensaje.administracion.organos"/></title>
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

        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <ol class="breadcrumb breadcrumb-bg-grey">
                    <li>
                        <i class="material-icons">build</i> Administraci&oacute;n del Sistema
                    </li>
                    <li>
                        Programas Institucionales
                    </li>
                    <li class="active">
                        <a href="<c:url value='/administrador/organo-direccion-estrategica/administracion-organos-direccion-estrategica.htm' />">
                            <i class="material-icons">view_agenda</i> Administraci&oacute;n de &Oacute;rganos de Direcci&oacute;n
                            Estrat&eacute;gica
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
                            <li class="active"><h3>Captura de &Oacute;rgano de Direcci&oacute;n Estrat&eacute;gica</h3>
                            </li>
                        </ol>
                    </div>
                    <div class="body">
                        <form method="POST" id="frm-Registro-Organo-Direccion-Estrategica">
                            <fieldset>
                                <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <p>
                                                <b>Seleccione el Programa Institucional para esta nuevo órgano de
                                                    dirección estratégico:</b>
                                            </p>
                                            <select class="form-control" name="idProgramaInstitucional"
                                                    id="selector-id-programaInstitucional">
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                            <input type="text" name="nombre" id="nuevo-nombre"
                                                   css="form-control" autocomplete="off" maxlength="100"/>
                                            <label class="form-label">Nombre del órgano de dirección estratégica</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="form-group form-float">
                                        <div class="form-line">
                                                    <textarea name="descripcion" id="nueva-descripcion"
                                                              maxlength="1200" class="form-control"></textarea>
                                            <label class="form-label">Descripci&oacute;n del &oacute;rgano de direcci&oacute;n
                                                estrat&eacute;gica</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-12 col-lg-12">
                                    <div class="form-group form-float">
                                        <button type="button" class="btn btn-success waves-effect"
                                                onclick="capturaOrganoDireccionEstrategica();">Guardar &oacute;rgano de
                                            direcci&oacute;n estrat&eacute;gica
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
                    <ol class="breadcrumb breadcrumb-bg-grey">
                        <li class="active"><h3>Busqueda y Actualizaci&oacute;n de &Oacute;rganos de Direcci&oacute;n
                            Estrat&eacute;gica</h3></li>
                    </ol>
                </div>

                <div class="body">
                    <table id="tabla-organos-direccion-estrategica"
                           class="table table-striped display responsive nowrap text-justify"
                           width="100%" cellspacing="0" style="color: black;">
                        <thead>
                        <tr>
                            <th>Nombre del Órgano de Dirección Estratégica</th>
                            <th>Descripci&oacute;n del Órgano de Dirección Estrategica</th>
                            <th>Acciones Permitidas</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nombre del Órgano de Dirección Estratégica</th>
                            <th>Descripci&oacute;n del Órgano de Dirección Estrategica</th>
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
                                    <form:form methodParam="POST" commandName="organoDireccionEstrategica"
                                               id="frm-Actualizar-Programa-Institucional" htmlEscape="true">
                                        <fieldset>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <form:input type="hidden" path="idOrganoDireccionEstrategica"
                                                                    id="idOrganoDireccionEstrategica"/>
                                                        <form:input type="text" path="nombre" id="nombre"
                                                                    cssClass="form-control" autocomplete="off"
                                                                    maxlength="100"/>
                                                        <label class="form-label">Nombre del &oacute;rgano de direcci&oacute;n
                                                            estrat&eacute;gica</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-12 col-md-12 col-lg-12">
                                                <div class="form-group form-float">
                                                    <div class="form-line">
                                                        <form:textarea path="descripcion" id="descripcion"
                                                                       maxlength="1200"
                                                                       cssClass="form-control"></form:textarea>
                                                        <label class="form-label">Descripci&oacute;n del &oacute;rgano
                                                            de direcci&oacute;n estrat&eacute;gica</label>
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
    </div>
</section>

<spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs"/>
<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>
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
<spring:url value="/resources/plugins/bootstrap-select/js/bootstrap-select.min.js" var="bootstrapSelectJs"/>

<spring:url
        value="/resources/js/funciones/administracion-organo-direccion-estrategica/fx-administracion-organo-direccion-estrategica.js"
        var="fxAdministracionOrganoDireccionEstrategica"/>
<spring:url value="/resources/js/funciones/prototipos/programa-institucional.js" var="prototypeProgramaInstitucional"/>


<spring:url value="/resources/js/funciones/fx-login.js" var="fxLogin"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.html5.min.js" var="buttonsHtml5Js"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/buttons.print.min.js" var="buttonsPrintJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"
            var="dataTablesButtonsJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/jszip.min.js" var="jszipJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/pdfmake.min.js" var="pdfmakeJs"/>
<spring:url value="/resources/plugins/jquery-datatable/extensions/export/vfs_fonts.js" var="vfs_fontsJs"/>

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
<!--    <script src="${prototypeProgramaInstitucional}"></script>-->
<script src="${fxAdministracionOrganoDireccionEstrategica}"></script>
<script src="${buttonsHtml5Js}"></script>
<script src="${buttonsPrintJs}"></script>
<script src="${dataTablesButtonsJs}"></script>
<script src="${jszipJs}"></script>
<script src="${pdfmakeJs}"></script>
<script src="${vfs_fontsJs}"></script>
</body>
</html>
