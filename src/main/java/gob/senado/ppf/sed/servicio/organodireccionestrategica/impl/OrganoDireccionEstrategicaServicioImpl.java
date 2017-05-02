package gob.senado.ppf.sed.servicio.organodireccionestrategica.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.repositorio.organodireccionestrategica.OrganoDireccionEstrategicaRepositorio;
import gob.senado.ppf.sed.servicio.organodireccionestrategica.OrganoDireccionEstrategicaServicio;

@Service(value = "organoDireccionEstrategicaServicio")
public class OrganoDireccionEstrategicaServicioImpl implements OrganoDireccionEstrategicaServicio {

	@Autowired
	private OrganoDireccionEstrategicaRepositorio organoDireccionEstrategicaRepositorio;

	@Override
	@Transactional
	public boolean altaOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
		if (organoDireccionEstrategicaRepositorio.buscarOrganoDireccionEstrategica(ode.getNombre()) == null) {
			return organoDireccionEstrategicaRepositorio.altaOrganoDireccionEstrategica(ode);
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean bajaOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		return organoDireccionEstrategicaRepositorio.bajaOrganoDireccionEstrategica(idOrganoDireccionEstrategica);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		return organoDireccionEstrategicaRepositorio.buscarOrganoDireccionEstrategica(idOrganoDireccionEstrategica);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(String nombre) {
		return organoDireccionEstrategicaRepositorio.buscarOrganoDireccionEstrategica(nombre);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategica() {
		return organoDireccionEstrategicaRepositorio.obtenerOrganosDireccionEstrategica();
	}

	@Override
	@Transactional
	public boolean actualizarOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
		final OrganoDireccionEstrategica odeActual = organoDireccionEstrategicaRepositorio
				.buscarOrganoDireccionEstrategica(ode.getIdOrganoDireccionEstrategica());
		final OrganoDireccionEstrategica odeCoincidente = organoDireccionEstrategicaRepositorio
				.buscarOrganoDireccionEstrategica(ode.getNombre());
		if (odeActual != null) {
			if ((odeCoincidente != null) && odeCoincidente.getIdOrganoDireccionEstrategica() == odeActual
					.getIdOrganoDireccionEstrategica()) {
				return organoDireccionEstrategicaRepositorio.actualizarOrganoDireccionEstrategica(ode);
			}else if(odeCoincidente == null){
				return organoDireccionEstrategicaRepositorio.actualizarOrganoDireccionEstrategica(ode);
			}else{
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarOrganosDireccionEstrategica() {
		return organoDireccionEstrategicaRepositorio.contarOrganosDireccionEstrategica();
	}

}
