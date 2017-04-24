package gob.senado.ppf.sed.servicio.unidadapoyo;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;

public interface UnidadApoyoServicio {
	
	public abstract boolean altaUnidadApoyo(UnidadApoyo unidadApoyo);

	public abstract boolean bajaUnidadApoyo(long idUnidadApoyo);

	public abstract UnidadApoyo buscarUnidadApoyo(long idOrganoDireccionEstrategica);

	public abstract boolean actualizarUnidadApoyo(UnidadApoyo unidadApoyo);

	public abstract long contarUnidadesApoyo();
	
	public abstract String enviarJsonUnidadApoyo(long idOrganoDireccionEstrategica);
}
