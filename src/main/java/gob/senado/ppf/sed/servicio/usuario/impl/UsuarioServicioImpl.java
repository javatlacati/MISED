package gob.senado.ppf.sed.servicio.usuario.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import gob.senado.ppf.sed.dto.usuario.ActividadExtemporanea;
import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.repositorio.usuario.UsuarioRepositorio;
import gob.senado.ppf.sed.servicio.usuario.UsuarioServicio;
import gob.senado.ppf.sed.utilidades.Activacion;
import gob.senado.ppf.sed.utilidades.Fase;
import gob.senado.ppf.sed.utilidades.Fecha;
import gob.senado.ppf.sed.utilidades.Hora;
import gob.senado.ppf.sed.utilidades.Suppliers;

@Service(value = "usuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public boolean altaUsuario(Usuario usuario) {
		if (usuarioRepositorio.buscarUsuario(usuario.getIdentidad()) == null) {
			usuario.setClaveAcceso(passwordEncoder.encode(usuario.getClaveAcceso()));
			usuario.setFechaRegistro(Fecha.FORMATO_FECHA_PRESENTACION.format(LocalDate.now()));
			usuario.setHoraRegistro(Hora.FORMATO_HORA_PRESENTACION.format(LocalTime.now()));
			ActividadExtemporanea ae = Suppliers.ACTIVIDAD_EXTEMPORANEA.get();
			ae.setFasePlaneacion(false);
			ae.setFaseCalendarizacion(false);
			ae.setFasePrimerCuatrimestre(false);
			ae.setFaseSegundoCuatrimestre(false);
			ae.setFaseTercerCuatrimestre(false);
			usuario.setActividadExtemporanea(ae);
			return usuarioRepositorio.altaUsuario(usuario);
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean actualizarUsuario(Usuario usuario) {
		return usuarioRepositorio.actualizarUsuario(usuario);
	}

	@Override
	@Transactional
	public boolean bajaUsuario(long idUsuario) {
		return usuarioRepositorio.bajaUsuario(idUsuario);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public Usuario buscarUsuario(long idUsuario) {
		return usuarioRepositorio.buscarUsuario(idUsuario);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public Usuario buscarUsuario(String identidad) {
		return usuarioRepositorio.buscarUsuario(identidad);
	}

	@Override
	@Transactional
	public boolean aplicarActividadExtemporanea(long idUsuario, Fase fase, Activacion activacion) {
		return usuarioRepositorio.aplicarActividadExtemporanea(idUsuario, fase, activacion);
	}

	@Override
	@Transactional
	public boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion) {
		return usuarioRepositorio.permitirUsoCuentaUsuario(idUsuario, activacion);
	}

	@Override
	@Transactional
	public boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso) {
		return usuarioRepositorio.reestablecerClaveAcceso(idUsuario, passwordEncoder.encode(nuevaClaveAcceso));
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarUsuarios() {
		return usuarioRepositorio.contarUsuarios();
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional) {
		return usuarioRepositorio.contarUsuariosPorProgramaInstitucional(idProgramaInstitucional);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		return usuarioRepositorio.contarUsuariosPorOrganoDireccionEstrategica(idOrganoDireccionEstrategica);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarUsuariosPorUnidadApoyo(long idUnidadApoyo) {
		return usuarioRepositorio.contarUsuariosPorUnidadApoyo(idUnidadApoyo);
	}

}
