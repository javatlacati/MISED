package gob.senado.ppf.sed.repositorio.unidadapoyo;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;

public interface UnidadApoyoRepositorio {

	public abstract boolean altaUnidadApoyo(UnidadApoyo unidadApoyo);

	public abstract boolean bajaUnidadApoyo(long idUnidadApoyo);

	public abstract UnidadApoyo buscarUnidadApoyo(long idUnidadApoyo);
	
	public abstract UnidadApoyo buscarUnidadApoyo(String nombreUnidadApoyo);

	public abstract boolean actualizarUnidadApoyo(UnidadApoyo unidadApoyo);

	public abstract long contarUnidadesApoyo();

}

