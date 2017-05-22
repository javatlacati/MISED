function Usuario(pidUsuario = "", pidUnidadApoyo = "",
                 pidentidad = "", pclaveAcceso = "", pnombre = "",
                 papellidoPaterno = "", papellidoMaterno = "", ppuestoLaboral = "",
                 pcorreoElectronico = "", pextensionTelefonica = "", prolDesignado = "",
                 ptipoUsuario = "", ppuedeConsultar = false, ppuedeActualizar = false,
                 ppuedeAgregar = false, ppuedeBorrar = false){
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

Usuario.prototype.toString = function(){
    return `${this.idUsuario} ${this.idUnidadApoyo} ${this.identidad} ${this.claveAcceso} ${this.nombre} ${this.apellidoPaterno} ${this.apellidoMaterno} ${this.puestoLaboral} ${this.correoElectronico} ${this.extensionTelefonica} ${this.rolDesignado} ${this.tipoUsuario} ${this.puedeConsultar} ${this.puedeActualizar} ${this.puedeAgregar} ${this.puedeBorrar}`;
};
