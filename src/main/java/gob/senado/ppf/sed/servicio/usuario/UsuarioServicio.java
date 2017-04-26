package gob.senado.ppf.sed.servicio.usuario;

import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.utilidades.Activacion;
import gob.senado.ppf.sed.utilidades.Fase;

/**
 * Capa de servicios para tareas de administraci&oacute;n de usuarios del sistema.
 */
public interface UsuarioServicio {

    /**
     * Permite dar de alta el usuario especificado en el sistema.
     *
     * @param usuario Objeto con los datos de un usuario
     */
    boolean altaUsuario(Usuario usuario);

    /**
     * Permite modificar la informaci&oacute;n de un usuario existente en el sistema.
     *
     * @param usuario Objeto con los datos de un usuario
     */
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
