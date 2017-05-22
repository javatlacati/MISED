let token = $("meta[name='_csrf']").attr("content");
let titulo = 'UNIDADES DE APOYO ' + (new Date().getFullYear());
let columnas = [0, 1, 2, 3, 4];
let orientacion = 'portrait';
let tamanioPagina = 'A4';
let tablaUnidadesApoyo = null;

const webSocketUnidadesApoyo = new WebSocket('ws://localhost:8080/MISED/actualizacion-unidad-apoyo');
const webSocketUsuarios = new WebSocket('ws://localhost:8080/MISED/actualizacion-usuario');

(function() {
    cargarOrganosDireccionEstrategica();
    tablaUnidadesApoyo = $('#tabla-unidades-apoyo')
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
                orientation: orientacion
            }, {
                extend: 'csv',
                text: 'Texto separado por comas',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion
            }, {
                extend: 'excel',
                text: 'Exportar a excel',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion
            }, {
                extend: 'pdf',
                text: 'Exportar a PDF',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion,
                customize: function(doc) {
                    doc.defaultStyle.fontSize = 8;
                },
                pageSize: tamanioPagina
            }, {
                extend: 'print',
                text: 'Imprimir',
                header: true,
                exportOptions: {
                    columns: columnas
                },
                title: titulo,
                orientation: orientacion
            }],
            "pagingType": "full_numbers",
            "lengthMenu": [
                [5, 15, 25, 50],
                [5, 15, 25, 50]
            ],
            "sAjaxDataProp": "",
            "bProcessing": true,
            "aoColumns": [{
                "mData": "claveProgramaInstitucional",
                "sDefaultContent": ''
            }, {
                "mData": "nombreProgramaInstitucional",
                "sDefaultContent": ''
            }, {
                "mData": "nombreOrganoDireccionEstrategica",
                "sDefaultContent": ''
            }, {
                "mData": "nombre",
                "sDefaultContent": ''
            }, {
                "mData": "totalUsuariosAdscritosUnidadApoyo",
                "sDefaultContent": ''
            }, {
                "mData": "idUnidadApoyo",
                "sDefaultContent": ''
            }],
            "columnDefs": [{
                "targets": 5,
                "data": "acciones",
                "render": function(data, type, row) {
                    return `<a onclick='actualizacionUnidadApoyo(${data})' class='btn bg-deep-orange waves-effect' style='margin-right: 7px;'>Actualizar</a><a class='btn bg-red waves-effect' style='margin-right: 7px;' onclick='bajaUnidadApoyo(${data})'>Eliminar</a>`;
                }
            }],
            "ajax": {
                url: `unidades-apoyo.json?_csrf=${token}`,
                type: "POST"
            }
        });

    webSocketUnidadesApoyo.onmessage = function(mensaje) {
        if (mensaje.data === 'actualizacion') {
            tablaUnidadesApoyo.clear().draw();
            tablaUnidadesApoyo.ajax.reload(null, false);
        }
    };

})();

function cargarOrganosDireccionEstrategica() {
    $.ajax({
        url: `../organo-direccion-estrategica/organos-direccion-estrategica.json?_csrf=${token}`,
        type: 'POST',
        success: function(organosDireccionEstrategica) {
            let opciones = "";
            organosDireccionEstrategica.forEach(function(ode) {
                opciones += `<option value='${ode.idOrganoDireccionEstrategica}'>${ode.nombre}</option>`;
            });
            $("#selector-id-organoDireccionEstrategica").html(opciones);
            $("#selector-id-organoDireccionEstrategica").selectpicker('refresh');
        },
        error: function() {
            swal("ERROR", "Se ha perdido la comunicacion con el servidor " +
                "o el recurso que busca ya no existe!, intentelo mas tarde.");
        }
    });
}

function actualizacionUnidadApoyo(idUnidadApoyo) {
    obtenerUnidadApoyo(idUnidadApoyo);
    $('#modal-actualizacion-unidad-apoyo').modal('show');
}

function obtenerUnidadApoyo(idUnidadApoyo) {
    $.ajax({
        url: `buscar-unidad-apoyo/${idUnidadApoyo}?_csrf=${token}`,
        type: 'POST',
        data: {
            'idUnidadApoyo': idUnidadApoyo
        },
        success: function(ua) {
            $.ajax({
                url: `../organo-direccion-estrategica/organos-direccion-estrategica.json?_csrf=${token}`,
                type: 'POST',
                success: function(organosDireccionEstrategica) {
                    let opciones = "";
                    organosDireccionEstrategica.forEach(function(ode) {
                        if (ode.idOrganoDireccionEstrategica == ua.idOrganoDireccionEstrategica) {
                            opciones += `<option value='${ode.idOrganoDireccionEstrategica}' selected>${ode.nombre}</option>`;
                        } else {
                            opciones += `<option value='${ode.idOrganoDireccionEstrategica}'>${ode.nombre}</option>`;
                        }
                    });
                    $("#selector-actualizacion-id-organo-direccion-estrategica").html(opciones);
                    $("#selector-actualizacion-id-organo-direccion-estrategica").selectpicker('refresh');
                },
                error: function() {
                    swal("ERROR", "Se ha perdido la comunicacion con el servidor \n\
                            o el recurso que busca ya no existe!, intentelo mas tarde.");
                }
            });
            $("#idUnidadApoyo").val(ua.idUnidadApoyo);
            $("#nombre").val(ua.nombre);
            $("#proposito").val(ua.proposito);
        },
        error: function() {
            swal("ERROR", "Se ha perdido la comunicación con el servidor ó el recurso que busca ya no existe!, intentelo mas tarde.");
        }
    });
}


function realizarActualizacionUnidadApoyo() {
    let unidadApoyo = new UnidadApoyo(
        $("#idUnidadApoyo").val(),
        $("#selector-actualizacion-id-organo-direccion-estrategica").val(),
        $("#nombre").val(), $("#proposito").val());
    if (validarCamposUnidadApoyo(unidadApoyo)) {
        $.ajax({
            url: `actualizar-unidad-apoyo?_csrf=${token}`,
            type: 'POST',
            data: {
                'idUnidadApoyo': unidadApoyo.idUnidadApoyo,
                'idOrganoDireccionEstrategica': unidadApoyo.idOrganoDireccionEstrategica,
                'nombre': unidadApoyo.nombre,
                'proposito': unidadApoyo.proposito
            },
            success: function(ode) {
                $('#modal-actualizacion-unidad-apoyo').modal('hide');
                swal("TAREA EXITOSA!", `Se ha actualizado el órgano de dirección estratégica : ${ode.nombre}`);
                webSocketUnidadesApoyo.send('actualizacion');
            },
            error: function(data) {
                swal("ERROR", "Se ha perdido la comunicación con el servidor ó el recurso que busca ya no existe" +
                    " ó el nombre del órgano de dirección estratégica encontro un duplicado y se evito la actualización, intentelo mas tarde.");
            }
        });
    }
}




function capturaUnidadApoyo() {
    let unidadApoyo = new UnidadApoyo("",
        $("#selector-id-organoDireccionEstrategica").val(),
        $("#nuevo-nombre").val(), $("#nuevo-proposito").val());
    if (validarCamposUnidadApoyo(unidadApoyo)) {
        $.ajax({
            url: `registro-unidad-apoyo?_csrf=${token}`,
            type: 'POST',
            data: {
                'idOrganoDireccionEstrategica': unidadApoyo.idOrganoDireccionEstrategica,
                'nombre': unidadApoyo.nombre,
                'proposito': unidadApoyo.proposito
            },
            success: function(ua) {
                swal("TAREA EXITOSA!", `Se ha registrado la unidad de apoyo : ${ua.nombre}`);
                $("#nuevo-nombre").val('');
                $("#nuevo-proposito").val('');
                webSocketUnidadesApoyo.send('actualizacion');
            },
            error: function() {
                swal("ERROR", "Se ha perdido la comunicación con el servidor ó el recurso que busca ya no existe" +
                    " ó el nombre de la Unidad de Apoyo encontro un duplicado y se evito la actualización!, intentelo mas tarde.");
            }
        });
    }
}

function validarCamposUnidadApoyo({
                                      idOrganoDireccionEstrategica = "",
                                      nombre = "",
                                      proposito = ""
                                  }) {
    if (idOrganoDireccionEstrategica === '') {
        swal("ERROR", "El recurso que busca ya no existe!");
        return false;
    } else if (idOrganoDireccionEstrategica === '' || idOrganoDireccionEstrategica.length === 0) {
        swal("ERROR", "Debe seleccionar un órgano de dirección estratégica al que pertenecera esta unidad de apoyo");
        return false;
    } else if (nombre === '' || nombre.length === 0) {
        swal("ERROR", "El nombre de la unidad de apoyo no puede estar vacio");
        return false;
    } else if (nombre.length > 250) {
        swal("ERROR", "El nombre del órgano de dirección estratégica no puede superar los 250 caracteres");
        return false;
    } else if (proposito.length > 1200) {
        swal("ERROR", "La descripción del órgano de dirección estratégica no puede superar los 1200 caracteres");
        return false;
    } else {
        return true;
    }
}


function bajaUnidadApoyo(idUnidadApoyo) {
    swal({
        title: "¿Estás realmente seguro de borrar esta unidad de apoyo?",
        text: "Se borrara esta unidad de apoyo con todos los usuarios asociados a esta!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Si, borrar esta Unidad de Apoyo!",
        closeOnConfirm: false
    }, function() {
        $.ajax({
            url: `baja-unidad-apoyo/${idUnidadApoyo}?_csrf=${token}`,
            type: 'POST',
            data: {
                'idUnidadApoyo': idUnidadApoyo
            },
            success: function(ua) {
                swal("TAREA EXITOSA!", `Se ha correctamente dado de baja la Unidad de Apoyo: ${ua.nombre}`);
                webSocketUnidadesApoyo.send('actualizacion');
                webSocketUsuarios.send('actualizacion');
            },
            error: function() {
                swal("ERROR", "Se ha perdido la comunicación con el servidor ó el recurso que busca ya no existe!, intentelo mas tarde.");
            }
        });
    });
}