<%@include file="../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>MISED - Iniciar Sesi&oacute;n</title>
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
    <spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
                var="fontRoboto"/>
    <%--<spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons" />--%>
    <%--<spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />--%>
    <%--<spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss" />--%>
    <%--<spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss" />--%>
    <%--<spring:url value="/resources/css/style.min.css" var="styleCss" />--%>
    <spring:url value="/resources/plugins/materialize-css/css/materialize.css" var="materializeCss"/>
    <link href="${fontRoboto}">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" type="text/css">
    <%--<link href="${bootstrapCss}" rel="stylesheet">--%>
    <%--<link href="${wavesCss}" rel="stylesheet" />--%>
    <%--<link href="${animateCss}" rel="stylesheet" />--%>
    <%--<link href="${styleCss}" rel="stylesheet">--%>
    <link href="${materializeCss}" rel="stylesheet">
    <spring:url value="/resources/css/custom.min.css" var="custom"/>
    <link href="${custom}" rel="stylesheet">
    <spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs"/>
    <spring:url value="/resources/plugins/materialize-css/js/materialize.js" var="materializeJS"/>
    <!-- Jquery Core Js -->
    <script src="${jQueryJs}"></script>
    <script src="${materializeJS}"></script>
</head>

<body class="login-page">


<div class="section hide-on-small-only"></div>
<div class="section hide-on-small-only"></div>
<div class="section hide-on-small-only"></div>
<div class="section hide-on-small-only"></div>
<div class="section hide-on-small-only"></div>
<div class="section hide-on-small-only"></div>
<div class="section hide-on-small-only"></div>
<div style="" class="row">
    <div style="" class="container col m4 s10 offset-m4 offset-s1">

        <center>
            <div class="card-panel container hoverable">
                <c:if test="${not empty error or not empty message}">
                    <div class="body">
                        <c:if test="${not empty error}">
                            <div class="error" id="msg-error">${error}</div>
                        </c:if>
                        <c:if test="${not empty message}">
                            <div class="msg" id="msg-cs">${message}</div>
                        </c:if>
                    </div>
                </c:if>
                <div class="row">
                    <div class="row">
                        <div class="col m12 logo">
                            <b>MISED</b>
                            <small>Módulo Informático del Sistema de Evaluación del Desempeño</small>
                        </div>
                    </div>
                    <div class="col m12">
                        <div class="body">


                            <form name="login" action="<c:url value='/inicio-sesion' />" method="POST">
                                <div class="msg">Ingrese su usuario y contraseña para iniciar sesión.</div>
                                <div class="input-group">
                                    <div class="form-line">
                                        <input class="form-control" name="username" id="username"
                                               placeholder="Nombre de usuario" autocomplete="off" required=""
                                               autofocus=""
                                               style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAAAXNSR0IArs4c6QAAAdpJREFUOBGlUr2LGnEQfbsuVmppEFbQQhAJHDZBQxCEEDg4sLP3ioMrky6FoDYB4VKFQA78E66yvEIIQQLqgcEuFuoeWnhqYyF+3ptfDrmsmzQOvGXe7Hz+ZoAjpFAo3OhHxEvoC4NZ3lG5InpEjvyBeE39CzF5st2XSqWT7XZ7Tb50uVzn+Xz+N3VIB5XdbveSOKP+QYyUr+Rx4i31vBgY/Jn8FfFms9l8EpvIsSNA1zTtnPhFVN1ut4wCXdcvye+IW8MwSmKjvCf/SXznCB//mI788q1+aPYcxWLxlHN+I4L2f885O7Ho0zeeG0Wn8Zow7XY7lwJMojklUMGhUAiBQACj0Qi9Xs8er7gUOkggf+LxODKZDLgu8MFQrVbRarVUUCQSwXQ6xWQiJ/KPNcZiMazXa5TLZcxmMyQSCeUsn1QqhXA4vOeOdzAej8H1IZ1Ow+PxwOfzIRqNIpfLwe/3I5lMKl18HEdoNpswTRPBYBCLxQLL5VK13Ol0VLLhcIjBYCDX6XyJq9UK9XodlmXB6/Wi2+1Cumo0GpjP5+j3+0qXBI4dSOVsNqsqt9tt1Gq1/cyVSmWvi3JwSLwui+s1edaq/b+8bYR+9wePSOMF92vJ7P8T+kmhi0cfQMw1uuwrvAAAAABJRU5ErkJggg==&quot;); background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%; cursor: auto;"
                                               type="text">
                                    </div>
                                </div>
                                <div class="input-group">
                                    <div class="form-line">
                                        <input class="form-control" name="password" id="password"
                                               placeholder="Contraseña" required=""
                                               style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAAAXNSR0IArs4c6QAAAdpJREFUOBGlUr2LGnEQfbsuVmppEFbQQhAJHDZBQxCEEDg4sLP3ioMrky6FoDYB4VKFQA78E66yvEIIQQLqgcEuFuoeWnhqYyF+3ptfDrmsmzQOvGXe7Hz+ZoAjpFAo3OhHxEvoC4NZ3lG5InpEjvyBeE39CzF5st2XSqWT7XZ7Tb50uVzn+Xz+N3VIB5XdbveSOKP+QYyUr+Rx4i31vBgY/Jn8FfFms9l8EpvIsSNA1zTtnPhFVN1ut4wCXdcvye+IW8MwSmKjvCf/SXznCB//mI788q1+aPYcxWLxlHN+I4L2f885O7Ho0zeeG0Wn8Zow7XY7lwJMojklUMGhUAiBQACj0Qi9Xs8er7gUOkggf+LxODKZDLgu8MFQrVbRarVUUCQSwXQ6xWQiJ/KPNcZiMazXa5TLZcxmMyQSCeUsn1QqhXA4vOeOdzAej8H1IZ1Ow+PxwOfzIRqNIpfLwe/3I5lMKl18HEdoNpswTRPBYBCLxQLL5VK13Ol0VLLhcIjBYCDX6XyJq9UK9XodlmXB6/Wi2+1Cumo0GpjP5+j3+0qXBI4dSOVsNqsqt9tt1Gq1/cyVSmWvi3JwSLwui+s1edaq/b+8bYR+9wePSOMF92vJ7P8T+kmhi0cfQMw1uuwrvAAAAABJRU5ErkJggg==&quot;); background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%; cursor: auto;"
                                               type="password">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-4">
                                        <button class="btn btn-block bg-grey verdepalma waves-effect" type="submit">Acceder
                                        </button>
                                    </div>
                                </div>
                                <div class="row m-t-15 m-b--20">
                                    <div class="col-xs-6 align-right">
                                        <a href="<c:url value='/forgot' />">Olvide mi contraseña</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </center>
    </div>
</div>
<!-- Bootstrap Core Js -->

<!-- Waves Effect Plugin Js -->

<!-- Custom Js -->
<%--<spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />--%>
<%--<spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs" />--%>
<%--<spring:url value="/resources/js/admin.js" var="adminJs" />--%>
<!-- Bootstrap Core Js -->
<%--<script src="${bootstrapJs}"></script>--%>
<!-- Waves Effect Plugin Js -->
<%--<script src="${wavesJs}"></script>--%>
<!-- Custom Js -->
<%--<script src="${adminJs}"></script>--%>
<script type="text/javascript">
    //hace que los mensajes desaparezcan tras cierto tiempo
    $(function () {
        setTimeout(function () {
            $('#msg-cs').fadeOut('fast');
        }, 2000);
        setTimeout(function () {
            $('#msg-error').fadeOut('fast');
        }, 3000);
    });
</script>

</body>

</html>