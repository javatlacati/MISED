package gob.senado.ppf.sed.servicio.organodireccionestrategica;

import java.util.List;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;

public interface OrganoDireccionEstrategicaServicio {
	
	public abstract boolean altaOrganoDireccionEstrategica(OrganoDireccionEstrategica ode);

	public abstract boolean bajaOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);

	public abstract OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);

	public abstract OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(String nombre);
	
	public abstract List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategica();

	public abstract boolean actualizarOrganoDireccionEstrategica(OrganoDireccionEstrategica ode);

	public abstract long contarOrganosDireccionEstrategica();
	
}
