package gob.senado.ppf.sed.repositorio.usuario.impl;

import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.repositorio.usuario.UsuarioRepositorio;
import gob.senado.ppf.sed.utilidades.Activacion;
import gob.senado.ppf.sed.utilidades.Fase;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository(value = "usuarioRepositorio")
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean altaUsuario(Usuario usuario) {
		final StringBuilder sqlUsuario = new StringBuilder();
		sqlUsuario.append("INSERT INTO USUARIO (id_unidad_apoyo, identidad, clave_acceso, nombre, ")
				.append("apellido_paterno, apellido_materno, puesto_laboral, correo_electronico, ")
				.append("extension_telefonica, rol_designado, tipo_usuario, fecha_registro, hora_registro) ")
				.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int rowsAffectedUsuario = jdbcTemplate.update((Connection con) -> {
			PreparedStatement pst = con.prepareStatement(sqlUsuario.toString(), new String[] { "id_usuario" });
			pst.setLong(1, usuario.getIdUnidadApoyo());
			pst.setString(2, usuario.getIdentidad());
			pst.setString(3, usuario.getClaveAcceso());
			pst.setString(4, usuario.getNombre());
			pst.setString(5, usuario.getApellidoPaterno());
			pst.setString(6, usuario.getApellidoMaterno());
			pst.setString(7, usuario.getPuestoLaboral());
			pst.setString(8, usuario.getCorreoElectronico());
			pst.setString(9, usuario.getExtensionTelefonica());
			pst.setString(10, usuario.getRolDesignado());
			pst.setString(11, usuario.getTipoUsuario());
			pst.setString(11, usuario.getFechaRegistro());
			pst.setString(12, usuario.getHoraRegistro());
			return pst;
		}, keyHolder);

		final long llavePrimariaUsuario = keyHolder.getKey().longValue();
		final StringBuilder sqlUsuarioPermiso = new StringBuilder();
		sqlUsuarioPermiso.append("INSERT INTO USUARIO_PERMISO(id_usuario, puede_consultar, ")
				.append("puede_actualizar, puede_agregar, puede_borrar, puede_autenticarse) VALUES (?, ?, ?, ?, ?, ?)");
		int rowsAffectedUsuarioPermiso = jdbcTemplate.update((Connection con) -> {
			PreparedStatement pst = con.prepareStatement(sqlUsuarioPermiso.toString());
			pst.setLong(1, llavePrimariaUsuario);
			pst.setBoolean(2, usuario.getUsuarioPermiso().puedeConsultar());
			pst.setBoolean(3, usuario.getUsuarioPermiso().puedeActualizar());
			pst.setBoolean(4, usuario.getUsuarioPermiso().puedeAgregar());
			pst.setBoolean(5, usuario.getUsuarioPermiso().puedeBorrar());
			pst.setBoolean(6, usuario.getUsuarioPermiso().puedeAutenticarse());
			return pst;
		});
		return rowsAffectedUsuario > 0 && rowsAffectedUsuarioPermiso > 0;
	}

	@Override
	public boolean actualizarUsuario(Usuario usuario) {
		final StringBuilder sqlUsuario = new StringBuilder();
		sqlUsuario.append("UPDATE USUARIO SET id_unidad_apoyo = ?, nombre = ?, ")
				.append("apellido_paterno = ?, apellido_materno = ?, puesto_laboral = ?, ")
				.append("correo_electronico = ?, extension_telefonica = ?, rol_designado = ?, ")
				.append("tipo_usuario = ? WHERE id_usuario = ?");
		int rowsAffectedUsuario = jdbcTemplate.update((Connection con) -> {
			PreparedStatement pst = con.prepareStatement(sqlUsuario.toString());
			pst.setLong(1, usuario.getIdUnidadApoyo());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getApellidoPaterno());
			pst.setString(4, usuario.getApellidoMaterno());
			pst.setString(5, usuario.getPuestoLaboral());
			pst.setString(6, usuario.getCorreoElectronico());
			pst.setString(7, usuario.getExtensionTelefonica());
			pst.setString(8, usuario.getRolDesignado());
			pst.setString(9, usuario.getTipoUsuario());
			pst.setLong(10, usuario.getIdUsuario());
			return pst;
		});

		final StringBuilder sqlUsuarioPermiso = new StringBuilder();
		sqlUsuarioPermiso
				.append("UPDATE USUARIO_PERMISO SET puede_consultar = ?, puede_actualizar = ?, puede_agregar = ?, ")
				.append("puede_borrar = ?, puede_autenticarse = ? WHERE id_permiso = ? AND id_usuario = ?");
		int rowsAffectedUsuarioPermiso = jdbcTemplate.update((Connection con) -> {
			PreparedStatement pst = con.prepareStatement(sqlUsuarioPermiso.toString());
			pst.setBoolean(1, usuario.getUsuarioPermiso().puedeConsultar());
			pst.setBoolean(2, usuario.getUsuarioPermiso().puedeActualizar());
			pst.setBoolean(3, usuario.getUsuarioPermiso().puedeAgregar());
			pst.setBoolean(4, usuario.getUsuarioPermiso().puedeBorrar());
			pst.setBoolean(5, usuario.getUsuarioPermiso().puedeAutenticarse());
			pst.setLong(6, usuario.getUsuarioPermiso().getIdPermiso());
			pst.setLong(7, usuario.getUsuarioPermiso().getIdUsuario());
			return pst;
		});

		return rowsAffectedUsuario > 0 && rowsAffectedUsuarioPermiso > 0;
	}

	@Override
	public boolean bajaUsuario(long idUsuario) {
		return jdbcTemplate.update("DELETE FROM USUARIO WHERE id_usuario = ?", new Object[] { idUsuario }) > 0;
	}

	@Override
	public Usuario buscarUsuario(long idUsuario) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM USUARIO U INNER JOIN USUARIO_PERMISO UP ON U.ID_USUARIO = UP.ID_USUARIO ").append(
					"INNER JOIN ACTIVIDAD_EXTEMPORANEA AE ON U.ID_USUARIO = AE.ID_USUARIO WHERE U.ID_USUARIO = ?");
			return jdbcTemplate.queryForObject(sql.toString(), new Object[] { idUsuario }, RowMappers.ROW_MAPPER_USUARIO);
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		} catch (IncorrectResultSizeDataAccessException irsdae) {
			return null;
		}
	}

	@Override
	public Usuario buscarUsuario(String identidad) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM USUARIO U INNER JOIN USUARIO_PERMISO UP ON U.ID_USUARIO = UP.ID_USUARIO ").append(
					"INNER JOIN ACTIVIDAD_EXTEMPORANEA AE ON U.ID_USUARIO = AE.ID_USUARIO WHERE U.IDENTIDAD = \'?\'");
			return jdbcTemplate.queryForObject(sql.toString(), new Object[] { identidad }, RowMappers.ROW_MAPPER_USUARIO);
		} catch (EmptyResultDataAccessException erdae) {
			return null;
		} catch (IncorrectResultSizeDataAccessException irsdae) {
			return null;
		}
	}

	@Override
	public boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE USUARIO_PERMISO SET puede_autenticarse = ? WHERE id_usuario = ?");
		return jdbcTemplate.update(sql.toString(), new Object[] { activacion.getEstadoInterruptor(), idUsuario }) > 0;
	}

	@Override
	public boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso) {
		return jdbcTemplate.update("UPDATE USUARIO SET clave_acceso = ? WHERE id_usuario = ?",
				new Object[] { nuevaClaveAcceso, idUsuario }) > 0;
	}

	@Override
	public long contarUsuarios() {
		return jdbcTemplate.queryForObject("SELECT TOTAL_CONTEO FROM CONTAR_USUARIOS", Long.class);
	}

	@Override
	public long contarUsuariosPorUnidadApoyo(long idUnidadApoyo) {
		return jdbcTemplate.queryForObject("SELECT CONTAR_USUARIOS_POR_UNIDAD_APOYO(?)", new Object[] { idUnidadApoyo },
				Long.class);
	}

	@Override
	public long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		return jdbcTemplate.queryForObject("SELECT CONTAR_USUARIOS_POR_ORGANO_DIRECCION_ESTRATEGICA(?)",
				new Object[] { idOrganoDireccionEstrategica }, Long.class);
	}

	@Override
	public long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional) {
		return jdbcTemplate.queryForObject("SELECT CONTAR_USUARIOS_POR_PROGRAMA_INSTITUCIONAL(?)",
				new Object[] { idProgramaInstitucional }, Long.class);
	}
}
