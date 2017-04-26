var token = $("meta[name='_csrf']").attr("content");
var fechaActual = new Date();
var anio = fechaActual.getFullYear(); 
var titulo = 'PROGRAMAS INSTITUCIONALES '+anio;
var columnas = [0, 1, 2];
var orientacion = 'landscape';
var tamanioPagina = 'LEGAL';
$(function(){
	$('#tabla-programas-institucionales').DataTable({
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
            	{ "mData": "clave"},
            	{ "mData": "nombre" },
            	{"mData" : "descripcion"}
            	],
            "ajax":
                {
                    url: "programas-institucionales.do?_csrf=" + token,
                    type: "POST"
                }
     });
});