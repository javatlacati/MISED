package gob.senado.ppf.sed.repositorio.organodireccionestrategica;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;

import java.util.List;

public interface OrganoDireccionEstrategicaRepositorio {

	boolean altaOrganoDireccionEstrategica(OrganoDireccionEstrategica ode);

	boolean bajaOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);

	OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);

	OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(String nombre);
	
	List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategica();

	boolean actualizarOrganoDireccionEstrategica(OrganoDireccionEstrategica ode);

	long contarOrganosDireccionEstrategica();
}
