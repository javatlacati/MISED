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

    /**
     * Permite dar de baja un usuario del sistema.
     *
     * @param idUsuario identifdicador &uacute;nico del usuario a dar de baja
     */
    boolean bajaUsuario(long idUsuario);

    /**
     * Permite dar de buscar un usuario del sistema.
     *
     * @param idUsuario identifdicador &uacute;nico del usuario a dar de baja
     */
    Usuario buscarUsuario(long idUsuario);

    /**
     * Permite dar de buscar un usuario del sistema.
     *
     * @param identidad
     */
    Usuario buscarUsuario(String identidad);

    boolean aplicarActividadExtemporanea(long idUsuario, Fase fase, Activacion activacion);

    boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion);

    boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso);

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema.
     */
    long contarUsuarios();

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema perrtenecientes a una unidad especificada.
     *
     * @param idUnidadApoyo identificador único de la unidad de apoyo a la que los usuarios que se desean buscar petenecen
     * @see gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo
     */
    long contarUsuariosPorUnidadApoyo(long idUnidadApoyo);

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema perrtenecientes a un &oacute;rgano de direcci&oacute;n estrat&eacute;gica especificado.
     *
     * @param idOrganoDireccionEstrategica identificador &uacute;nico del &oacute;rgano de direcci&oacute;n estrat&eacute;gica al que los usuarios que se desean buscar petenecen
     * @see gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica
     */
    long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema perrtenecientes a un Programa Institucional especificado.
     *
     * @param idProgramaInstitucional identificador &uacute;nico del Programa Institucional al que los usuarios que se desean buscar petenecen
     * @see gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional
     */
    long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional);

}
