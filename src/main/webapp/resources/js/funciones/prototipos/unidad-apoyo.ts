function UnidadApoyo(pidUnidadApoyo = "", pidOrganoDireccionEstrategica = "",
                     pnombre = "", pproposito = "") {
    this.idUnidadApoyo = pidUnidadApoyo;
    this.idOrganoDireccionEstrategica = pidOrganoDireccionEstrategica;
    this.nombre = pnombre;
    this.proposito = pproposito;
}

UnidadApoyo.prototype.toString = function () {
    return `${this.idUnidadApoyo} ${this.idOrganoDireccionEstrategica} ${this.nombre} ${this.proposito}`;
};