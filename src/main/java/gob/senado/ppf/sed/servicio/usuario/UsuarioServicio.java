package gob.senado.ppf.sed.servicio.usuario;

import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.utilidades.Activacion;
import gob.senado.ppf.sed.utilidades.Fase;

public interface UsuarioServicio {

	boolean altaUsuario(Usuario usuario);

	boolean actualizarUsuario(Usuario usuario);

	boolean bajaUsuario(long idUsuario);

	Usuario buscarUsuario(long idUsuario);

	Usuario buscarUsuario(String identidad);

	boolean aplicarActividadExtemporanea(long idUsuario, Fase fase, Activacion activacion);

	boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion);

	boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso);

	long contarUsuarios();

	long contarUsuariosPorUnidadApoyo(long idUnidadApoyo);

	long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);

	long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional);

}
