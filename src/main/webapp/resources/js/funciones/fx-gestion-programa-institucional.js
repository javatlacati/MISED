var token = $("meta[name='_csrf']").attr("content");
var fechaActual = new Date();
var anio = fechaActual.getFullYear(); 
var titulo = 'PROGRAMAS INSTITUCIONALES '+anio;
var columnas = [0, 1, 2];
var orientacion = 'portrait';
var tamanioPagina = 'A4';
$(function(){
	let tablaProgramasInstitucionales = $('#tabla-programas-institucionales').DataTable({
     	"language": LENGUAJE,
         dom: 'Bfrtilp',
         buttons: [
            	 {extend: 'copy', text: 'Copiar al portapapeles', header: true, exportOptions: {columns: columnas}, title: titulo, orientation: orientacion}, 
            	 {extend: 'csv', text: 'Texto separado por comas', header: true, exportOptions: {columns: columnas}, title: titulo, orientation: orientacion},  
            	 {extend: 'excel', text: 'Exportar a excel', header: true, exportOptions: {columns: columnas}, title: titulo, orientation: orientacion},
            	 {extend: 'pdf', text: 'Exportar a PDF', header: true, exportOptions: {columns: columnas}, title: titulo, orientation: orientacion, 
            		 customize: function(doc) { doc.defaultStyle.fontSize = 8;}, pageSize: tamanioPagina}, 
             	 {extend: 'print', text: 'Imprimir', header: true, exportOptions: {columns: columnas}, title: titulo, orientation: orientacion},
        	 ],
			"pagingType" : "full_numbers",
			"lengthMenu" : [ [5, 15, 25, 50], [5, 15, 25, 50 ] ],
			"sAjaxDataProp": "",
			"bProcessing": true, 
            "aoColumns": [
            	{ "mData": "clave", "sDefaultContent": ''},
            	{ "mData": "nombre", "sDefaultContent": '' },
            	{"mData" : "descripcion", "sDefaultContent": ''},
            	{ "mData": "idProgramaInstitucional", "sDefaultContent": ''}
            	],
            "columnDefs": [
            	 {
            	    "targets": 3,
            	    "data": "acciones",
            	    "render": function (data, type, row ){
            	      return "<a class='btn bg-deep-orange waves-effect' style='margin-right: 7px;' onclick='actualizacionProgramaInstitucional("+data+")'>Actualizar</a>"
            	       + "<a class='btn bg-red waves-effect' style='margin-right: 7px;' onclick='bajaProgramaInstitucional("+data+")'>Eliminar</a>";
            	      ;
            	    }
            	 }
            	],
            "ajax":{
                  url: "programas-institucionales.json?_csrf=" + token,
                  type: "POST"
                	  
                }
     });
});

function actualizacionProgramaInstitucional(idProgramaInstitucional){
	alert("Funcion para actualizar el programa institucional: " + idProgramaInstitucional);
}

function bajaProgramaInstitucional(idProgramaInstitucional){
	alert("Funcion para eliminar el programa institucional: " + idProgramaInstitucional);
}