let token = $("meta[name='_csrf']").attr("content");
(function(){
    cargarProgramasInstitucionales();
})();



function cargarProgramasInstitucionales(){
    $.ajax({
        url: '../programa-institucional/programas-institucionales.json?_csrf=' + token,
        type: 'POST',
        success: function(programasInstitucionales) {
            let opciones = "";
            programasInstitucionales.forEach(function(pi){
                opciones += "<option value='" + pi.idProgramaInstitucional + "'>"+ pi.clave + " " + pi.nombre +"</option>";
            });
            $("#selector-id-programaInstitucional").html(opciones);
            $("#selector-id-programaInstitucional").selectpicker('refresh');
        },
        error: function() {
            swal("ERROR", "Se ha perdido la comunicacion con el servidor \n\
                    o el recurso que busca ya no existe!, intentelo mas tarde.");
        }
    });
}