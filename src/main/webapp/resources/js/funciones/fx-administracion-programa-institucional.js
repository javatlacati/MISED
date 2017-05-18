var token = $("meta[name='_csrf']").attr("content");
var fechaActual = new Date();
var anio = fechaActual.getFullYear();
var titulo = 'PROGRAMAS INSTITUCIONALES ' + anio;
var columnas = [0, 1, 2];
var orientacion = 'portrait';
var tamanioPagina = 'A4';
var tablaProgramasInstitucionales = null;
var webSocket = null;
$(function () {
    tablaProgramasInstitucionales = $('#tabla-programas-institucionales')
        .DataTable({
        "language": LENGUAJE,
        dom: 'Bfrtilp',
        responsive: true,
        buttons: [{
                extend: 'copy',
                text: 'Copiar al portapapeles',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion,
                className: 'btn verdepalma'
            }, {
                extend: 'csv',
                text: 'Texto separado por comas',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion,
                className: 'btn verdepalma'
            }, {
                extend: 'excel',
                text: 'Exportar a excel',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion,
                className: 'btn verdepalma'
            }, {
                extend: 'pdf',
                text: 'Exportar a PDF',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion,
                customize: function (doc) {
                    doc.defaultStyle.fontSize = 8;
                },
                pageSize: tamanioPagina,
                className: 'btn verdepalma'
            }, {
                extend: 'print',
                text: 'Imprimir',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion,
                className: 'btn verdepalma'
            },],
        "pagingType": "full_numbers",
        "lengthMenu": [
            [5, 15, 25, 50],
            [5, 15, 25, 50]
        ],
        "sAjaxDataProp": "",
        "bProcessing": true,
        "aoColumns": [{
                "mData": "clave",
                "sDefaultContent": ''
            }, {
                "mData": "nombre",
                "sDefaultContent": ''
            }, {
                "mData": "descripcion",
                "sDefaultContent": ''
            }, {
                "mData": "idProgramaInstitucional",
                "sDefaultContent": ''
            }],
        "columnDefs": [{
                "targets": 3,
                "data": "acciones",
                "render": function (data, type, row) {
                    return "<a onclick='actualizacionProgramaInstitucional(" + data + ")' class='btn bg-deep-orange waves-effect' style='margin-right: 7px;'>Actualizar</a><a class='btn bg-red waves-effect' style='margin-right: 7px;' onclick='bajaProgramaInstitucional(" + data + ")'>Eliminar</a>";
                }
            }],
        "ajax": {
            url: "programas-institucionales.json?_csrf=" + token,
            type: "POST"
        }
    });
    webSocket = new WebSocket('ws://localhost:8080/MISED/actualizacion-programa-institucional');
    webSocket.onmessage = function (mensaje) {
        if (mensaje.data === 'actualizacion') {
            tablaProgramasInstitucionales.clear().draw();
            tablaProgramasInstitucionales.ajax.reload(null, false);
        }
    };
});
function actualizacionProgramaInstitucional(idProgramaInstitucional) {
    obtenerProgramaInstitucional(idProgramaInstitucional);
    $('#modal-actualizacion-programa-institucional').modal('show');
}
function obtenerProgramaInstitucional(idProgramaInstitucional) {
    $.ajax({
        url: 'buscar-programa-institucional/' + idProgramaInstitucional + '?_csrf=' + token,
        type: 'POST',
        data: {
            'idProgramaInstitucional': idProgramaInstitucional
        },
        success: function (pi) {
            $("#idProgramaInstitucional").val(pi.idProgramaInstitucional);
            $("#clave").val(pi.clave);
            $("#nombre").val(pi.nombre);
            $("#descripcion").val(pi.descripcion);
        },
        error: function () {
            swal("ERROR", "Se ha perdido la comunicación con el servidor ó el recurso que busca ya no existe!, intentelo mas tarde.");
        }
    });
}
function capturaProgramaInstitucional() {
    var programaInstitucional = new ProgramaInstitucional(null, $("#nueva-clave").val(), $("#nuevo-nombre").val(), $("#nueva-descripcion").val());
    if (validarCamposProgramaInstitucional(programaInstitucional)) {
        $.ajax({
            url: 'registro-programa-institucional?_csrf=' + token,
            type: 'POST',
            data: {
                'clave': programaInstitucional.clave,
                'nombre': programaInstitucional.nombre,
                'descripcion': programaInstitucional.descripcion
            },
            success: function (pi) {
                swal("TAREA EXITOSA!", "Se ha registrado el programa institucional : " + pi.nombre + " con clave: " + pi.clave);
                $("#nueva-clave").val('');
                $("#nuevo-nombre").val('');
                $("#nueva-descripcion").val('');
                webSocket.send('actualizacion');
            },
            error: function () {
                swal("ERROR", "Se ha perdido la comunicaciÃ³n con el servidor Ã³ el recurso que busca ya no existe" +
                    " Ã³ la CLAVE del programa institucional esta duplicada y se evito la actualizaciÃ³n!, intentelo mas tarde.");
            }
        });
    }
}
function realizarActualizacionProgramaInstitucional() {
    var programaInstitucional = new ProgramaInstitucional($("#idProgramaInstitucional").val(), $("#clave").val(), $("#nombre").val(), $("#descripcion").val());
    if (validarCamposProgramaInstitucional(programaInstitucional)) {
        $.ajax({
            url: 'actualizar-programa-institucional?_csrf=' + token,
            type: 'POST',
            data: {
                'idProgramaInstitucional': programaInstitucional.idProgramaInstitucional,
                'clave': programaInstitucional.clave,
                'nombre': programaInstitucional.nombre,
                'descripcion': programaInstitucional.descripcion
            },
            success: function (pi) {
                $('#modal-actualizacion-programa-institucional').modal('hide');
                swal("TAREA EXITOSA!", "Se ha actualizado el programa institucional : " + pi.nombre + " con clave: " + pi.clave);
                webSocket.send('actualizacion');
            },
            error: function (data) {
                swal("ERROR", "Se ha perdido la comunicaciÃ³n con el servidor Ã³ el recurso que busca ya no existe" +
                    " Ã³ la CLAVE del programa institucional esta duplicada y se evito la actualizaciÃ³n, intentelo mas tarde.");
            }
        });
    }
}
function validarCamposProgramaInstitucional(_a) {
    var _b = _a.idProgramaInstitucional, idProgramaInstitucional = _b === void 0 ? "" : _b, _c = _a.clave, clave = _c === void 0 ? "" : _c, _d = _a.nombre, nombre = _d === void 0 ? "" : _d, _e = _a.descripcion, descripcion = _e === void 0 ? "" : _e;
    if (idProgramaInstitucional === '') {
        swal("ERROR", "El recurso que busca ya no existe!");
        return false;
    }
    else if (clave === '' || clave.length === 0) {
        swal("ERROR", "La clave del programa institucional no puede estar vacia");
        return false;
    }
    else if (clave.length > 100) {
        swal("ERROR", "La clave del programa institucional no puede superar los 100 caracteres");
        return false;
    }
    else if (nombre === '' || nombre.length === 0) {
        swal("ERROR", "El nombre del programa institucional no puede estar vacio");
        return false;
    }
    else if (nombre.length > 250) {
        swal("ERROR", "El nombre del programa institucional no puede superar los 250 caracteres");
        return false;
    }
    else if (descripcion.length > 1200) {
        swal("ERROR", "La descripciÃ³n del programa institucional no puede superar los 1200 caracteres");
        return false;
    }
    else {
        return true;
    }
}
function bajaProgramaInstitucional(idProgramaInstitucional) {
    swal({
        title: "¿Estás realmente seguro de borrar este Programa Institucional?",
        text: "Se borrara este programa institucional permanentemente con todos sus Ã³rganos de direcciÃ³n estratÃ©gica y unidades de apoyo asociadas!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Si, borrar este programa institucional!",
        closeOnConfirm: false
    }, function () {
        $.ajax({
            url: 'baja-programa-institucional/' + idProgramaInstitucional + '?_csrf=' + token,
            type: 'POST',
            data: {
                'idProgramaInstitucional': idProgramaInstitucional
            },
            success: function (pi) {
                swal("TAREA EXITOSA!", "Se ha correctamente dado de baja el programa institucional: " + pi.nombre + " con clave: " + pi.clave);
                webSocket.send('actualizacion');
            },
            error: function () {
                swal("ERROR", "Se ha perdido la comunicaciÃ³n con el servidor Ã³ el recurso que busca ya no existe!, intentelo mas tarde.");
            }
        });
    });
}
