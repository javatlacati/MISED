/**URL del servidor*/
declare var pathws: string;
/**Nombre de el WAR*/
declare var appName: string;
var token = $("meta[name='_csrf']").attr("content");
var webSocketUsuarios = null;
(function () {
    cargarUnidadesApoyo();
    webSocketUsuarios = new WebSocket(`ws://${pathws}:${portNumber}${appName}/actualizacion-usuario`);
})();
function cargarUnidadesApoyo() {
    $.ajax({
        url: '../unidad-apoyo/unidades-apoyo.json?_csrf=' + token,
        type: 'POST',
        success: function (unidadesApoyo) {
            var opciones = "";
            unidadesApoyo.forEach(function (ua) {
                opciones += "<option data-subtext='" + ua.nombreOrganoDireccionEstrategica +
                    "' value='" + ua.idUnidadApoyo + "'>" + ua.nombre + "</option>";
            });
            $("#selector-id-unidadApoyo").html(opciones);
            $("#selector-id-unidadApoyo").selectpicker('refresh');
        },
        error: function () {
            swal("ERROR", "Se ha perdido la comunicacion con el servidor " +
                "o el recurso que busca ya no existe!, intentelo mas tarde.");
        }
    });
}
function capturarUsuario() {
    var idUnidadApoyo = $("#selector-id-unidadApoyo").val();
    var identidad = $("#identidad").val();
    var claveAcceso = $("#clave-acceso").val();
    var verificacionClaveAcceso = $("#verificacion-claveAcceso").val();
    var nombre = $("#nombre").val();
    var apellidoPaterno = $("#apellido-paterno").val();
    var apellidoMaterno = $("#apellido-materno").val();
    var puestoLaboral = $("#puesto-laboral").val();
    var correoElectronico = $("#correo-electronico").val();
    var extensionTelefonica = $("#extension-telefonica").val();
    var rol = $("#selector-rol-usuario").val();
    var permisos = $("#selector-permisos-usuario").val();
    var tipo = $("#selector-tipo-usuario").val();
    var usuario = new Usuario(0, idUnidadApoyo, identidad, claveAcceso, nombre, apellidoPaterno, apellidoMaterno, puestoLaboral, correoElectronico, extensionTelefonica, rol, tipo, false, false, false, false);
    computarPermisosUsuario(permisos, usuario);
    if (validarCamposUsuario(usuario, verificacionClaveAcceso)) {
        $.ajax({
            url: 'registro-usuario?_csrf=' + token,
            type: 'POST',
            data: {
                'idUnidadApoyo': usuario.idUnidadApoyo,
                'identidad': usuario.identidad,
                'claveAcceso': usuario.claveAcceso,
                'nombre': usuario.nombre,
                'apellidoPaterno': usuario.apellidoPaterno,
                'apellidoMaterno': usuario.apellidoMaterno,
                'puestoLaboral': usuario.puestoLaboral,
                'correoElectronico': usuario.correoElectronico,
                'extensionTelefonica': usuario.extensionTelefonica,
                'rolDesignado': usuario.rolDesignado,
                'tipoUsuario': usuario.tipoUsuario,
                'puedeConsultar': usuario.puedeConsultar,
                'puedeActualizar': usuario.puedeActualizar,
                'puedeAgregar': usuario.puedeAgregar,
                'puedeBorrar': usuario.puedeBorrar
            },
            success: function (u) {
                swal("TAREA EXITOSA!", "Se ha registrado el usuario : " + u.identidad);
                $('#frm-registro-usuario').find('input[type="text"]').val('');
                webSocketUsuarios.send('actualizacion');
            },
            error: function () {
                swal("ERROR", "Se ha perdido la comunicación con el servidor ó el " +
                    "nombre de usuario esta duplicado y se evito la actualización!, intentelo mas tarde.");
            }
        });
    }
}
function computarPermisosUsuario(permisos, usuario) {
    if (permisos !== null) {
        for (var indice = 0; indice < permisos.length; indice++) {
            switch (permisos[indice]) {
                case 'CONSULTAR':
                    usuario.puedeConsultar = true;
                    break;
                case 'ACTUALIZAR':
                    usuario.puedeActualizar = true;
                    break;
                case 'AGREGAR':
                    usuario.puedeAgregar = true;
                    break;
                case 'BORRAR':
                    usuario.puedeBorrar = true;
                    break;
            }
        }
    }
}
function validarCamposUsuario(usuario, verificacionClaveAcceso) {
    let expresionEmailCorrecto = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    if (usuario.idUnidadApoyo === '' || usuario.idUnidadApoyo === 0) {
        swal("ERROR", "El recurso que busca ya no existe!");
        return false;
    }
    else if (usuario.identidad === '' || usuario.identidad.length === 0) {
        swal("ERROR", "Se requiere que el nombre de usuario no este en blanco!");
        return false;
    }
    else if (usuario.identidad > 18) {
        swal("ERROR", "Se requiere que el nombre de usuario no tenga mas de 18 caracteres!");
        return false;
    }
    else if (usuario.claveAcceso !== verificacionClaveAcceso) {
        swal("ERROR", "Es necesario de las contraseñas coincidan!");
        return false;
    }
    else if ((usuario.claveAcceso === '' || usuario.claveAcceso.length === 0)
        || (verificacionClaveAcceso === '' || verificacionClaveAcceso.length === 0)) {
        swal("ERROR", "Se requiere que las contraseñas no este en blanco!");
        return false;
    }
    else if (usuario.nombre === '' || usuario.nombre.length === 0) {
        swal("ERROR", "Se requiere que el nombre no este en blanco!");
        return false;
    }
    else if (usuario.nombre.length > 50) {
        swal("ERROR", "El nombre no puede sobrepasar los 50 caracteres!");
        return false;
    }
    else if (usuario.apellidoPaterno === '' || usuario.apellidoPaterno.length === 0) {
        swal("ERROR", "Se requiere que el apellido paterno no este en blanco!");
        return false;
    }
    else if (usuario.apellidoPaterno.length > 50) {
        swal("ERROR", "El apellido paterno no puede pasar de los 50 caracteres!");
        return false;
    }
    else if (usuario.apellidoMaterno === '' || usuario.apellidoMaterno.length === 0) {
        swal("ERROR", "Se requiere que el apellido materno no este en blanco!");
        return false;
    }
    else if (usuario.apellidoMaterno.length > 50) {
        swal("ERROR", "El apellido materno no puede pasar de los 50 caracteres!");
        return false;
    }
    else if (usuario.puestoLaboral === '' || usuario.puestoLaboral.length === 0) {
        swal("ERROR", "Se requiere que el puesto laboral no este en blanco!");
        return false;
    }
    else if (usuario.puestoLaboral.length > 120) {
        swal("ERROR", "El puesto laboral no puede pasar de los 120 caracteres!");
        return false;
    }
    else if (usuario.correoElectronico === '' || usuario.correoElectronico.length === 0) {
        swal("ERROR", "Se requiere que el E-mail no este en blanco!");
        return false;
    }
    else if (!(expresionEmailCorrecto.test(usuario.correoElectronico))) {
        swal("ERROR", "Se requiere que el E-mail este bien escrito!");
        return false;
    }
    else if (usuario.correoElectronico.length > 120) {
        swal("ERROR", "Se requiere que el E-mail no tenga mas de 120 caracteres!");
        return false;
    }
    else if (usuario.rolDesignado === '' || usuario.rolDesignado.length === 0) {
        swal("ERROR", "Se necesita que seleccione un rol de usuario!");
        return false;
    }
    else if (usuario.tipoUsuario === '' || usuario.tipoUsuario.length === 0) {
        swal("ERROR", "Se requiere que seleccion un tipo de usuario!");
        return false;
    }
    else {
        return true;
    }
}
