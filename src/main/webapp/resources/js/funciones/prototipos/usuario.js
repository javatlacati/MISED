function Usuario(pidUsuario, pidUnidadApoyo, pidentidad, pclaveAcceso, pnombre, papellidoPaterno, papellidoMaterno, ppuestoLaboral, pcorreoElectronico, pextensionTelefonica, prolDesignado, ptipoUsuario, ppuedeConsultar, ppuedeActualizar, ppuedeAgregar, ppuedeBorrar) {
    if (pidUsuario === void 0) { pidUsuario = ""; }
    if (pidUnidadApoyo === void 0) { pidUnidadApoyo = ""; }
    if (pidentidad === void 0) { pidentidad = ""; }
    if (pclaveAcceso === void 0) { pclaveAcceso = ""; }
    if (pnombre === void 0) { pnombre = ""; }
    if (papellidoPaterno === void 0) { papellidoPaterno = ""; }
    if (papellidoMaterno === void 0) { papellidoMaterno = ""; }
    if (ppuestoLaboral === void 0) { ppuestoLaboral = ""; }
    if (pcorreoElectronico === void 0) { pcorreoElectronico = ""; }
    if (pextensionTelefonica === void 0) { pextensionTelefonica = ""; }
    if (prolDesignado === void 0) { prolDesignado = ""; }
    if (ptipoUsuario === void 0) { ptipoUsuario = ""; }
    if (ppuedeConsultar === void 0) { ppuedeConsultar = false; }
    if (ppuedeActualizar === void 0) { ppuedeActualizar = false; }
    if (ppuedeAgregar === void 0) { ppuedeAgregar = false; }
    if (ppuedeBorrar === void 0) { ppuedeBorrar = false; }
    this.idUsuario = pidUsuario;
    this.idUnidadApoyo = pidUnidadApoyo;
    this.identidad = pidentidad;
    this.claveAcceso = pclaveAcceso;
    this.nombre = pnombre;
    this.apellidoPaterno = papellidoPaterno;
    this.apellidoMaterno = papellidoMaterno;
    this.puestoLaboral = ppuestoLaboral;
    this.correoElectronico = pcorreoElectronico;
    this.extensionTelefonica = pextensionTelefonica;
    this.rolDesignado = prolDesignado;
    this.tipoUsuario = ptipoUsuario;
    this.puedeConsultar = ppuedeConsultar;
    this.puedeActualizar = ppuedeActualizar;
    this.puedeAgregar = ppuedeAgregar;
    this.puedeBorrar = ppuedeBorrar;
}
Usuario.prototype.toString = function () {
    return this.idUsuario + " " + this.idUnidadApoyo + " " + this.identidad + " " + this.claveAcceso + " " + this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno + " " + this.puestoLaboral + " " + this.correoElectronico + " " + this.extensionTelefonica + " " + this.rolDesignado + " " + this.tipoUsuario + " " + this.puedeConsultar + " " + this.puedeActualizar + " " + this.puedeAgregar + " " + this.puedeBorrar;
};
