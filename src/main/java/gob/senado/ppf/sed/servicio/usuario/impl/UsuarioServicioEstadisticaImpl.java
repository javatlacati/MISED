package gob.senado.ppf.sed.servicio.usuario.impl;

import com.google.gson.Gson;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.unidadapoyo.UnidadApoyoRepositorio;
import gob.senado.ppf.sed.servicio.usuario.UsuarioServicioEstadistica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service(value = "usuarioServicioEstadistica")
public class UsuarioServicioEstadisticaImpl implements UsuarioServicioEstadistica {

	private UnidadApoyoRepositorio unidadApoyoRepositorio;

	@Autowired
	public UsuarioServicioEstadisticaImpl(UnidadApoyoRepositorio unidadApoyoRepositorio) {
		this.unidadApoyoRepositorio = unidadApoyoRepositorio;
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public String obtenerNumeroUsuariosPorUnidadApoyo() {
		Gson gson = new Gson();
		// List<Object[]> conjunto = 
		return unidadApoyoRepositorio.obtenerUnidadesApoyo().parallelStream()
				.<Object[]>map((UnidadApoyo unidadApoyo) -> {
					return new Object[] { unidadApoyo.getNombre(), unidadApoyo.getTotalUsuariosAdscritosUnidadApoyo() };
				}).collect(Collectors.collectingAndThen(Collectors.toList(), gson::toJson));
	//	return gson.toJson(conjunto);
	}

}
