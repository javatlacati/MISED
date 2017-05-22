function OrganoDireccionEstrategica(pidOrganoDireccionEstrategica = "",
                                    pidProgramaInstitucional = "", pnombre = "", pdescripcion = "") {
    this.idOrganoDireccionEstrategica = pidOrganoDireccionEstrategica;
    this.idProgramaInstitucional = pidProgramaInstitucional;
    this.nombre = pnombre;
    this.descripcion = pdescripcion;
}

OrganoDireccionEstrategica.prototype.toString = function () {
    return `${this.idOrganoDireccionEstrategica} ${this.idProgramaInstitucional} ${this.nombre}`;
};