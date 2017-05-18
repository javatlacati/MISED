/**
 * Funcion que construye un prototype ProgramaInstitucional para almacenar el identificador del programa institucional,
 * la clave del programa institucional, el nombre del programa institucional y la descripcion del mismo.
 * @param pIdProgramaInstitucional identificador del programa
 * @param pClave clave del programa
 * @param pNombre nombre del programa
 * @param pDescripcion descripcion del programa
 */
function ProgramaInstitucional(pIdProgramaInstitucional = "", pClave = "", pNombre = "", pDescripcion = ""){
    this.idProgramaInstitucional = pIdProgramaInstitucional;
    this.clave = pClave;
    this.nombre = pNombre;
    this.descripcion = pDescripcion;
}

ProgramaInstitucional.prototype.toString = function():string{
    return this.idProgramaInstitucional + " " + this.clave + " " + this.nombre + " " + this.descripcion;
};
