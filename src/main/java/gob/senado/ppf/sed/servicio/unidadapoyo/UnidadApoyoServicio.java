package gob.senado.ppf.sed.servicio.unidadapoyo;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;

import java.util.List;

public interface UnidadApoyoServicio {
	
	boolean altaUnidadApoyo(UnidadApoyo unidadApoyo);

	boolean bajaUnidadApoyo(long idUnidadApoyo);

	UnidadApoyo buscarUnidadApoyo(long idOrganoDireccionEstrategica);
	
	List<UnidadApoyo> obtenerUnidadesApoyo();

	boolean actualizarUnidadApoyo(UnidadApoyo unidadApoyo);

	long contarUnidadesApoyo();
	
}
