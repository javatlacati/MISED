declare var $:JQueryStatic;
declare var swal: any;
let token = $("meta[name='_csrf']").attr("content");
let titulo = 'ORGANOS DIRECCION ESTRATEGICA ' + new Date().getFullYear();
let columnas = [ 0, 1 ];
let orientacion = 'portrait';
let tamanioPagina = 'A4';
let tablaOrganosDireccionEstrategica = null;
let webSocketOrganosDireccionEstrategica = null; //TODO no se usa de momento
(function(){
    cargarProgramasInstitucionales();

    tablaOrganosDireccionEstrategica = $('#tabla-organos-direccion-estrategica')
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
            }, ],
            "pagingType": "full_numbers",
            "lengthMenu": [
                [5, 15, 25, 50],
                [5, 15, 25, 50]
            ],
            "sAjaxDataProp": "",
            "bProcessing": true,
            "aoColumns": [{
                "mData": "nombre",
                "sDefaultContent": ''
            }, {
                "mData": "descripcion",
                "sDefaultContent": ''
            }],
            "columnDefs": [{
                "targets": 2,
                "data": "acciones",
                "render": function(data, type, row) {
                    return `<a onclick='actualizacionOrganoDireccionEstrategica(${data})' class='btn bg-deep-orange waves-effect' style='margin-right: 7px;'>Actualizar</a><a class='btn bg-red waves-effect' style='margin-right: 7px;' onclick='bajaOrganoDireccionEstrategica(${data})'>Eliminar</a>`;
                }
            }],
            "ajax": {
                url: `organos-direccion-estrategica.json?_csrf=${token}`,
                type: "POST"
            }
        });
})();



function cargarProgramasInstitucionales(){
    $.ajax({
        url: `../programa-institucional/programas-institucionales.json?_csrf=${token}`,
        type: 'POST',
        success: function(programasInstitucionales) {
            //reniciamos
            var $selectDropdown =
                $("#selector-id-unidadApoyo")
                    .empty()
                    .html(' ');

            programasInstitucionales.forEach(function(pi){
                $selectDropdown.append(
                    $("<option></option>")
                        .attr("value", pi.idProgramaInstitucional)
                        .text(`${pi.clave} ${pi.nombre}`)
                );

            });
            //$("#selector-id-programaInstitucional").selectpicker('refresh');
            $selectDropdown.trigger('contentChanged');
        },
        error: function() {
            swal("ERROR", "Se ha perdido la comunicacion con el servidor \n\
                    o el recurso que busca ya no existe!, intentelo mas tarde.");
        }
    });
    $('select').on('contentChanged', function() {
        // re-initialize (update)
        $(this).material_select();
    });
}