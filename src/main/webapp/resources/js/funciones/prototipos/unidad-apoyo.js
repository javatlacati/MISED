function UnidadApoyo(pidUnidadApoyo, pidOrganoDireccionEstrategica, pnombre, pproposito) {
    if (pidUnidadApoyo === void 0) { pidUnidadApoyo = ""; }
    if (pidOrganoDireccionEstrategica === void 0) { pidOrganoDireccionEstrategica = ""; }
    if (pnombre === void 0) { pnombre = ""; }
    if (pproposito === void 0) { pproposito = ""; }
    this.idUnidadApoyo = pidUnidadApoyo;
    this.idOrganoDireccionEstrategica = pidOrganoDireccionEstrategica;
    this.nombre = pnombre;
    this.proposito = pproposito;
}
UnidadApoyo.prototype.toString = function () {
    return this.idUnidadApoyo + " " + this.idOrganoDireccionEstrategica + " " + this.nombre + " " + this.proposito;
};
