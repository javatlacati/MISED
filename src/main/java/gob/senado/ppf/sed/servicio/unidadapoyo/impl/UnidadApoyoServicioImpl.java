package gob.senado.ppf.sed.servicio.unidadapoyo.impl;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.unidadapoyo.UnidadApoyoRepositorio;
import gob.senado.ppf.sed.servicio.unidadapoyo.UnidadApoyoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "unidadApoyoServicio")
public class UnidadApoyoServicioImpl implements UnidadApoyoServicio {

	private final UnidadApoyoRepositorio unidadApoyoRepositorio;

	@Autowired
	public UnidadApoyoServicioImpl(UnidadApoyoRepositorio unidadApoyoRepositorio) {
		this.unidadApoyoRepositorio = unidadApoyoRepositorio;
	}

	@Override
	@Transactional
	public boolean altaUnidadApoyo(UnidadApoyo unidadApoyo) {
		return unidadApoyoRepositorio.buscarUnidadApoyo(unidadApoyo.getNombre()) == null && unidadApoyoRepositorio.altaUnidadApoyo(unidadApoyo);
	}

	@Override
	@Transactional
	public boolean bajaUnidadApoyo(long idUnidadApoyo) {
		return unidadApoyoRepositorio.bajaUnidadApoyo(idUnidadApoyo);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public UnidadApoyo buscarUnidadApoyo(long idOrganoDireccionEstrategica) {
		return unidadApoyoRepositorio.buscarUnidadApoyo(idOrganoDireccionEstrategica);
	}

	@Override
	@Transactional
	public boolean actualizarUnidadApoyo(UnidadApoyo unidadApoyo) {
		final UnidadApoyo uaActual = unidadApoyoRepositorio.buscarUnidadApoyo(unidadApoyo.getIdUnidadApoyo());
		final UnidadApoyo uaCoincidente = unidadApoyoRepositorio.buscarUnidadApoyo(unidadApoyo.getNombre());
		if(uaActual != null){
			if((uaCoincidente != null) && uaCoincidente.getIdUnidadApoyo() == uaActual.getIdUnidadApoyo()){
				return unidadApoyoRepositorio.actualizarUnidadApoyo(unidadApoyo);
			}else if(uaCoincidente == null){
				return unidadApoyoRepositorio.actualizarUnidadApoyo(unidadApoyo);
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<UnidadApoyo> obtenerUnidadesApoyo() {
		return unidadApoyoRepositorio.obtenerUnidadesApoyo();
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarUnidadesApoyo() {
		return unidadApoyoRepositorio.contarUnidadesApoyo();
	}

}
