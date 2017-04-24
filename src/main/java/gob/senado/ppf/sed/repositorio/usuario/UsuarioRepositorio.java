package gob.senado.ppf.sed.repositorio.usuario;

import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.utilidades.Activacion;
import gob.senado.ppf.sed.utilidades.Fase;

public interface UsuarioRepositorio {

	public abstract boolean altaUsuario(Usuario usuario);

	public abstract boolean actualizarUsuario(Usuario usuario);

	public abstract boolean bajaUsuario(long idUsuario);

	public abstract Usuario buscarUsuario(long idUsuario);

	public abstract Usuario buscarUsuario(String identidad);

	public abstract boolean aplicarActividadExtemporanea(long idUsuario, Fase fase, Activacion activacion);
	
	public abstract boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion);
	
	public abstract boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso);

	public abstract long contarUsuarios();

	public abstract long contarUsuariosPorUnidadApoyo(long idUnidadApoyo);

	public abstract long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);
	
	public abstract long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional);

}
