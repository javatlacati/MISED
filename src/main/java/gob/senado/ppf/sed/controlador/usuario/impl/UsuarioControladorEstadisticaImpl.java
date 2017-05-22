package gob.senado.ppf.sed.controlador.usuario.impl;

import gob.senado.ppf.sed.controlador.usuario.UsuarioControladorEstadistica;
import gob.senado.ppf.sed.servicio.usuario.UsuarioServicioEstadistica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "usuarioControladorEstadistica")
@RequestMapping("/administrador")
public class UsuarioControladorEstadisticaImpl implements UsuarioControladorEstadistica {

	private UsuarioServicioEstadistica usuarioServicioEstadistica;

	@Autowired
	public UsuarioControladorEstadisticaImpl(UsuarioServicioEstadistica usuarioServicioEstadistica) {
		this.usuarioServicioEstadistica = usuarioServicioEstadistica;
	}

	@Override
	@RequestMapping(value = "/usuario/numero-usuarios-por-unidad-apoyo.json", method = { RequestMethod.GET,RequestMethod.POST })
	public String obtenerNumeroUsuariosPorUnidadApoyo() {
		return usuarioServicioEstadistica.obtenerNumeroUsuariosPorUnidadApoyo();
	}
}
