package gob.senado.ppf.sed.servicio.unidadapoyo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

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
		return unidadApoyoRepositorio.actualizarUnidadApoyo(unidadApoyo);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarUnidadesApoyo() {
		return unidadApoyoRepositorio.contarUnidadesApoyo();
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public String enviarJsonUnidadApoyo(long idOrganoDireccionEstrategica) {
		UnidadApoyo ua = unidadApoyoRepositorio.buscarUnidadApoyo(idOrganoDireccionEstrategica);
		Gson gson = new Gson();
		return gson.toJson(ua);
	}

}
