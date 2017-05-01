package gob.senado.ppf.sed.servicio.unidadapoyo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.unidadapoyo.UnidadApoyoRepositorio;
import gob.senado.ppf.sed.servicio.unidadapoyo.UnidadApoyoServicio;

@Service(value = "unidadApoyoServicio")
public class UnidadApoyoServicioImpl implements UnidadApoyoServicio {

	@Autowired
	private UnidadApoyoRepositorio unidadApoyoRepositorio;

	@Override
	@Transactional
	public boolean altaUnidadApoyo(UnidadApoyo unidadApoyo) {
		if (unidadApoyoRepositorio.buscarUnidadApoyo(unidadApoyo.getNombre()) == null) {
			return unidadApoyoRepositorio.altaUnidadApoyo(unidadApoyo);
		} else {
			return false;
		}
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
