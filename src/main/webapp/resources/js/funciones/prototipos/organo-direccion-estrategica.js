function OrganoDireccionEstrategica(pidOrganoDireccionEstrategica, pidProgramaInstitucional, pnombre, pdescripcion) {
    if (pidOrganoDireccionEstrategica === void 0) { pidOrganoDireccionEstrategica = ""; }
    if (pidProgramaInstitucional === void 0) { pidProgramaInstitucional = ""; }
    if (pnombre === void 0) { pnombre = ""; }
    if (pdescripcion === void 0) { pdescripcion = ""; }
    this.idOrganoDireccionEstrategica = pidOrganoDireccionEstrategica;
    this.idProgramaInstitucional = pidProgramaInstitucional;
    this.nombre = pnombre;
    this.descripcion = pdescripcion;
}
OrganoDireccionEstrategica.prototype.toString = function () {
    return this.idOrganoDireccionEstrategica + " " + this.idProgramaInstitucional + " " + this.nombre;
};
