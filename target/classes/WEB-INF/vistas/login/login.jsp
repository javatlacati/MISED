<%@include file="../template/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>MISED - Iniciar Sesi&oacute;n</title>
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">
	<spring:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" var="fontRoboto" />
    <spring:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="materialIcons" />
    <spring:url value="/resources/plugins/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/plugins/node-waves/waves.min.css" var="wavesCss" />
    <spring:url value="/resources/plugins/animate-css/animate.min.css" var="animateCss" />
    <spring:url value="/resources/css/style.min.css" var="styleCss" />
    <spring:url value="/resources/css/themes/materialize.css" var="materializeCss" />
    <link href="${fontRoboto}">
    <link href="${materialIcons}" type="text/css">
    <link href="${bootstrapCss}" rel="stylesheet">
    <link href="${wavesCss}" rel="stylesheet" />
    <link href="${animateCss}" rel="stylesheet" />
    <link href="${styleCss}" rel="stylesheet">
    <style>
	.error {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #a94442;
		background-color: #f2dede;
		border-color: #ebccd1;
	}
	
	.msg {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #000;
		background-color: #9e9e9e;
		border-color: #000;
	}
	</style>
</head>

<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <a><b>MISED</b></a>
            <small>Módulo Informático del Sistema de Evaluación del Desempeño</small>
        </div>
        <div class="card">
            <div class="body"> 
            <c:if test="${not empty error}">
				<div class="error" id="msg-error">${error}</div>
			</c:if>
			<c:if test="${not empty message}">
				<div class="msg" id="msg-cs">${message}</div>
			</c:if>
                <form name='login' action="<c:url value='/inicio-sesion' />" method='POST'>
                    <div class="msg">Ingrese su usuario y contraseña para iniciar sesión.</div>
                    <div class="input-group">
                        <div class="form-line">
                            <input type="text" class="form-control" name="username" id="username" placeholder="Nombre de usuario" autocomplete="off" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" id="password" placeholder="Contraseña" required>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-grey waves-effect" type="submit">Acceder</button>
                        </div>
                    </div>
                    <div class="row m-t-15 m-b--20">
                        <div class="col-xs-6 align-right">
                            <a href="forgot-password.html">Olvide mi contraseña</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <spring:url value="/resources/plugins/jquery/jquery.min.js" var="jQueryJs" />
    <spring:url value="/resources/plugins/bootstrap/js/bootstrap.min.js" var="bootstrapJs" />
	<spring:url value="/resources/plugins/node-waves/waves.min.js" var="wavesJs" />
    <spring:url value="/resources/js/admin.js" var="adminJs" />
    <script src="${jQueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${wavesJs}"></script>
    <script src="${adminJs}"></script>
    <script type="text/javascript">
    $(function(){
    	setTimeout(function() {
            $('#msg-cs').fadeOut('fast');
        }, 2000);
    	setTimeout(function() {
            $('#msg-error').fadeOut('fast');
        }, 3000);
    });
    </script>
</body>

</html>