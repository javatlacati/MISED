let token = $("meta[name='_csrf']").attr("content");
/**URL del servidor*/
declare var pathws: string;
/**Nombre de el WAR*/
declare var appName: string;
declare var portNumber:number;

const webSocketUsuarios = new WebSocket(`ws://${pathws}:${portNumber}${appName}/actualizacion-usuario`);
let graficaUsuariosActivos;

(function() {
    graficaUsuariosActivos = new Highcharts.Chart({
        chart: {
            renderTo: 'grafica-usuarios-activos',
            type: 'column'
        },
        title: {
            text: 'Número de Usuarios por Unidad de Apoyo'
        },
        subtitle: {
            text: 'Fuente: Módulo de estadística de MISED'
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '10px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            allowDecimals: false,
            title: {
                text: 'Número de usuarios'
            }
        },
        tooltip: {
            pointFormat: '{point.name} tiene <b>{point.y} usuarios.</b>'
        },
        series: [{
            name: 'Numero de usuarios por unidad de apoyo',
            data: [],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                format: '{series.name}',
                y: 10, // 10 pixels down from the top
                style: {
                    fontSize: '18px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        }],
        credits: {
            enabled: false
        },
        legend: {
            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            enabled: false
        }
    });


    cargarGraficaUsuariosActivos();

    tablaUsuarios = $('#tabla-usuarios')
        .DataTable({
            "language": LENGUAJE,
            dom: 'Bfrtilp',
            responsive: true,
            "pagingType": "full_numbers",
            "lengthMenu": [
                [5, 15, 25, 50],
                [5, 15, 25, 50]
            ],
            "sAjaxDataProp": "",
            "bProcessing": true,
            "aoColumns": [{
                "mData": "claveProgramaInstitucionalAdscrito",
                "sDefaultContent": ''
            }, {
                "mData": "nombreProgramaInstitucionalAdscrito",
                "sDefaultContent": ''
            }, {
                "mData": "nombreOrganoDireccionEstrategicaAdscrito",
                "sDefaultContent": ''
            }, {
                "mData": "nombreUnidadApoyoAdscrito",
                "sDefaultContent": ''
            }, {
                "mData": "identidad",
                "sDefaultContent": ''
            }, {
                "mData": "nombre",
                "sDefaultContent": ''
            }, {
                "mData": "apellidoPaterno",
                "sDefaultContent": ''
            }, {
                "mData": "apellidoMaterno",
                "sDefaultContent": ''
            }, {
                "mData": "puestoLaboral",
                "sDefaultContent": ''
            }, {
                "mData": "extensionTelefonica",
                "sDefaultContent": ''
            }, {
                "mData": "correoElectronico",
                "sDefaultContent": ''
            }, {
                "mData": "rolDesignado",
                "sDefaultContent": ''
            }, {
                "mData": "tipoUsuario",
                "sDefaultContent": ''
            }, {
                "mData": "fechaRegistro",
                "sDefaultContent": ''
            }, {
                "mData": "horaRegistro",
                "sDefaultContent": ''
            }, {
                "mData": "puedeConsultar",
                "sDefaultContent": ''
            }, {
                "mData": "puedeActualizar",
                "sDefaultContent": ''
            }, {
                "mData": "puedeAgregar",
                "sDefaultContent": ''
            }, {
                "mData": "puedeBorrar",
                "sDefaultContent": ''
            }, {
                "mData": "puedeAutenticarse",
                "sDefaultContent": ''
            }, {
                "mData": "idUsuario",
                "sDefaultContent": ''
            }],
            "columnDefs": [{
                "targets": [15, 16, 17, 18, 19],
                "searchable": false,
                "orderable": false,
                "data": "acciones",
                "render": function(data, type, row) {
                    return (data === "true" || data === true) ? "<i class='material-icons'>check_circle</i>" : "<i class='material-icons'>highlight_off</i>";
                }
            }, {
                "targets": [11],
                "searchable": false,
                "orderable": false,
                "data": "acciones",
                "render": function(data, type, row) {
                    switch (data) {
                        case 'ROLE_ADMINISTRADOR':
                            return "Administrador";
                        case 'ROLE_USUARIO':
                            return "Usuario";
                    }
                }
            },{
                "targets": 20,
                "data": "acciones",
                "render": function(data, type, row) {
                    return "<a class='btn bg-deep-orange waves-effect' style='margin-right: 7px;' onclick='actualizacionUsuario(" + data + ")'>Actualizar</a>"
                        + "<a class='btn bg-red waves-effect' style='margin-right: 7px;' onclick='bajaUsuario(" + data + ")'>Eliminar</a>"

                        + "<a id='btn-activacion-"+data+"' class='btn bg-deep-purple waves-effect' style='margin-right: 7px;' onclick='activarCuentaUsuario(" + data + ")'></a>"

                        + "<a class='btn bg-teal waves-effect' style='margin-right: 7px;' onclick='reestablecerCredencialesUsuario(" + data + ")'>Reestablecer credenciales</a>";
                }
            }],
            "rowCallback": function(row, data, index) {
                if(data.puedeAutenticarse === true || data.puedeAutenticarse === 'true'){
                    $("#btn-activacion-"+data.idUsuario).text("Activar");
                }else{
                    $("#btn-activacion-"+data.idUsuario).text("Desactivar");
                }

                if (data.puedeAutenticarse === false || data.puedeAutenticarse === 'false') {
                    $('td', row).css('background-color', '#F44336');
                }

                if (data.rolDesignado === 'ROLE_ADMINISTRADOR') {
                    $('td', row).css('background-color', '#ffd700');
                }
            },
            "ajax": {
                url: "usuarios.json?_csrf=" + token,
                type: "POST"
            }
        });


    webSocketUsuarios.onmessage = function(mensaje) {
        if (mensaje.data === 'actualizacion') {
            cargarGraficaUsuariosActivos();
            tablaUsuarios.clear().draw();
            tablaUsuarios.ajax.reload(null, false);
        }
    };

})();



function cargarGraficaUsuariosActivos() {
    $.ajax({
        url: 'numero-usuarios-por-unidad-apoyo.json?_csrf=' + token,
        type: 'POST',
        success: function(datosGrafica) {
            graficaUsuariosActivos.series[0].setData(datosGrafica, true);
        },
        error: function() {
            swal("ERROR", "Se ha perdido la comunicación con el servidor, intentelo mas tarde.");
        }
    });
}


function actualizacionUsuario(idUsuario){
    alert(idUsuario);
}

function bajaUsuario(idUsuario){
    swal({
        title: "¿Estás realmente seguro de borrar este usuario?",
        text: "Se borrara este usuario permanentemente con todo su historial de actividades(NO se borraran Arboles de objetivos, Indicadores, Calendarizaciones, Informes cuatrimestrales ó cuadros de mando)!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Si, borrar este usuario!",
        closeOnConfirm: false
    }, function() {
        $.ajax({
            url: 'baja-usuario/' + idUsuario + '?_csrf=' + token,
            type: 'POST',
            data: {
                'idUsuario': idUsuario
            },
            success: function(u) {
                swal("TAREA EXITOSA!", "Se ha correctamente dado de baja el usuario: "
                    + u.nombre+ " " + u.apellidoPaterno + " " + u.apellidoMaterno + " con nombre de usuario: " + u.identidad);
                webSocketUsuarios.send('actualizacion');
            },
            error: function() {
                swal("ERROR", "Se ha perdido la comunicación con el servidor ó el recurso que busca ya no existe!, intentelo mas tarde.");
            }
        });
    });
}

function activarCuentaUsuario(idUsuario){
    swal({
        title: "¿Estás realmente seguro de activar/desactivar este usuario?",
        text: "Al activar o desactivar este usuario afectara solamente si el usuario puede autenticarse o no!",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Si, activar/desactivar este usuario!",
        closeOnConfirm: false
    }, function() {
        $.ajax({
            url: 'activacion-cuenta/' + idUsuario + '?_csrf=' + token,
            type: 'POST',
            data: {
                'idUsuario': idUsuario
            },
            success: function(u) {
                swal("TAREA EXITOSA!", "Se ha realizado la tarea exitosamente!");
                webSocketUsuarios.send('actualizacion');
            },
            error: function() {
                swal("ERROR", "Se ha perdido la comunicación con el servidor ó el recurso que busca ya no existe!, intentelo mas tarde.");
            }
        });
    });
}

function reestablecerCredencialesUsuario(idUsuario){
    alert(idUsuario);
}