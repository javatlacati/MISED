package gob.senado.ppf.sed.servicio.unidadapoyo;

import java.util.List;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;

public interface UnidadApoyoServicio {
	
	public abstract boolean altaUnidadApoyo(UnidadApoyo unidadApoyo);

	public abstract boolean bajaUnidadApoyo(long idUnidadApoyo);

	public abstract UnidadApoyo buscarUnidadApoyo(long idOrganoDireccionEstrategica);
	
	public abstract List<UnidadApoyo> obtenerUnidadesApoyo();

	public abstract boolean actualizarUnidadApoyo(UnidadApoyo unidadApoyo);

	public abstract long contarUnidadesApoyo();
	
}
