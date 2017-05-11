<%@include file="../template/tags.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <sec:csrfMetaTags/>
        <title><spring:message code="mensaje.tab-inicio"/></title>
        <link rel="icon" href="../../favicon.ico" type="image/x-icon">
        <spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
                    var="fontRoboto"/>
        <spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons"/>
        <%--<spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>--%>
        <%--<spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss"/>--%>
        <%--<spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss"/>--%>
        <%--<spring:url value="/resources/plugins/material-design-preloader/md-preloader.min.css" var="mdPreloaderCss"/>--%>
        <%--<spring:url value="/resources/plugins/sweetalert/sweetalert.css" var="sweetAlertCss"/>--%>
        <%--<spring:url value="/resources/css/style.min.css" var="styleCss"/>--%>
        <%--<spring:url value="/resources/css/themes/all-themes.min.css" var="allThemesCss"/>--%>
        <%--<spring:url value="/resources/css/mytheme-black.min.css" var="temaNegro"/>--%>
        <spring:url value="/resources/plugins/materialize-css/css/materialize.css" var="materializeCss"/>

        <link href="${fontRoboto}" rel="stylesheet" type="text/css">
        <link href="${materialIcons}" rel="stylesheet" type="text/css">
        <%--<link href="${bootstrapCss}" rel="stylesheet">--%>
        <%--<link href="${wavesCss}" rel="stylesheet"/>--%>
        <%--<link href="${animateCss}" rel="stylesheet"/>--%>
        <%--<link href="${mdPreloaderCss}" rel="stylesheet"/>--%>
        <%--<link href="${sweetAlertCss}" rel="stylesheet">--%>
        <%--<link href="${styleCss}" rel="stylesheet">--%>
        <%--<link href="${allThemesCss}" rel="stylesheet"/>--%>
        <%--<link href="${temaNegro}" rel="stylesheet"/>--%>
        <link href="${materializeCss}" rel="stylesheet"/>
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


        <%@include file="../template/menu-template.jsp" %>
        <section class="content">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <ol class="breadcrumb breadcrumb-bg-grey">
                            <li>
                                <a href="/MISED/inicio.htm">
                                    <i class="material-icons">home</i> <spring:message code="mensaje.inicio"/>
                                </a>
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="row clearfix">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="card">
                            <div class="header bg-grey">
                                <h2>
                                    <spring:message code="mensaje.bienvenida"/>
                                </h2>
                            </div>
                            <div class="body">
                                <div class="row">
                                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10" style="color: #6f7376;">
                                        
                                        <h3 class="pull-left" style="color: #a17f1a;"><spring:message
                                                code="mensaje.institucion"/></h3>
                                        <br/><br/><br/>
                                        <h4>${programaInstitucional}</h4>
                                        <h4>${organoDireccionEstrategica}</h4>
                                        <h5>${unidadApoyo}</h5>
                                        <span>${fechaActual}</span>
                                        <br/>
                                        <span>
                                            ${nombreCompleto}
                                        </span>
                                        <br/><br/>
                                        <p class="text-justify">
                                            <spring:message code="mensaje.lenguaje"/>
                                            <a class="btn bg-grey waves-effect" href="?lang=en">English</a>
                                            <a class="btn bg-grey waves-effect" href="?lang=es">Español</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="parallax-container">
                <div class="parallax"><img src="../../../resources/images/image-gallery/1.jpg"></div>
                </div>
            </div>
        </section>
            
        <%--<spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs"/>--%>
        <%--<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>--%>
        <%--<spring:url value="/resources/plugins/materialize-css/js/materialize.js" var="materializecssJs"/>--%>
        <%--<spring:url value="/resources/plugins/sweetalert/sweetalert.min.js" var="sweetAlertJs"/>--%>
        <%--<spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs"/>--%>
        <%--<spring:url value="/resources/js/admin.js" var="adminJs"/>--%>
        <%--<spring:url value="resources/js/funciones/fx-login.js" var="fxLogin"/>--%>
        <%--<script src="${jQueryJs}"></script>--%>
        <%--<script src="${bootstrapJs}"></script>--%>
        <%--<script src="${sweetAlertJs}"></script>--%>
        <%--<script src="${wavesJs}"></script>--%>
        <%--<script src="${adminJs}"></script>--%>
        <%--<script src="${fxLogin}"></script>--%>
        <%--<script src="${materializecssJs}"></script>--%>
        <script>
            $(document).ready(function () {
                $('.parallax').parallax();
                $(".button-collapsable").sideNav();
//                $('.button-collapse').sideNav('show');
            });

        </script>
    </body>
</html>