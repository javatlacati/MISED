package gob.senado.ppf.sed.repositorio.unidadapoyo;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;

import java.util.List;

public interface UnidadApoyoRepositorio {

	boolean altaUnidadApoyo(UnidadApoyo unidadApoyo);

	boolean bajaUnidadApoyo(long idUnidadApoyo);

	UnidadApoyo buscarUnidadApoyo(long idUnidadApoyo);
	
	UnidadApoyo buscarUnidadApoyo(String nombreUnidadApoyo);
	
	List<UnidadApoyo> obtenerUnidadesApoyo();

	boolean actualizarUnidadApoyo(UnidadApoyo unidadApoyo);

	long contarUnidadesApoyo();

}

