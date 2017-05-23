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
            background-color: #fff;

            position: fixed;
            z-index: 150;
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
    <img src="${senadoAnimado}" >
</div>


<%@include file="../template/menu-template.jsp" %>
<section class="content">
    <div class="container-fluid">
        <div class="section hide-on-small-only"></div>
        <div class="section hide-on-small-only"></div>
        <div class="section hide-on-small-only"></div>
        <nav class="container grey darken-1">
            <div class="nav-wrapper">
                <div class="col s12">
                    <a href="<c:url value='/inicio.htm' />" class="breadcrumb">
                        <i class="material-icons">home</i> <spring:message code="mensaje.inicio"/>
                    </a>
                </div>
            </div>
        </nav>


        <div class="row clearfix container">
            <div class="col-m-12">
                <div class="card">
                    <div class="card-title grey darken-1 white-text">
                        <h2>
                            <spring:message code="mensaje.bienvenida"/>
                        </h2>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-m10 col-sm10 col-xs10" style="color: #6f7376;">

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
                                    <a class="btn verdepalma waves-effect" href="?lang=en">English</a>
                                    <a class="btn verdepalma waves-effect" href="?lang=es">Español</a>
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
<spring:url value="resources/js/funciones/fx-login.js" var="fxLogin"/>
<%--<script src="${jQueryJs}"></script>--%>
<%--<script src="${bootstrapJs}"></script>--%>
<%--<script src="${sweetAlertJs}"></script>--%>
<%--<script src="${wavesJs}"></script>--%>
<%--<script src="${adminJs}"></script>--%>
<script src="${fxLogin}"></script>
<%--<script src="${materializecssJs}"></script>--%>
<script>
    $(document).ready(function () {
        $('.parallax').parallax();
        $(".button-collapsable").sideNav({
            menuWidth: 450, // Default is 300
            edge: 'left', // Choose the horizontal origin
            closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
            draggable: true // Choose whether you can drag to open on touch screens
        });
    });
</script>
</body>
</html>