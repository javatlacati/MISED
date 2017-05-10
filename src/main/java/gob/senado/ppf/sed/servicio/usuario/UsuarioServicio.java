package gob.senado.ppf.sed.servicio.usuario;

import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.utilidades.Activacion;

/**
 * Capa de servicios para tareas de administraci&oacute;n de usuarios del sistema.
 */
public interface UsuarioServicio {

    /**
     * Permite dar de alta el usuario especificado en el sistema.
     *
     * @param usuario Objeto con los datos de un usuario
     * @return si el usuario ha sido dado de alta
     */
    boolean altaUsuario(Usuario usuario);

    /**
     * Permite modificar la informaci&oacute;n de un usuario existente en el sistema.
     *
     * @param usuario Objeto con los datos de un usuario
     * @return si el usuario ha sido modificado
     */
    boolean actualizarUsuario(Usuario usuario);

    /**
     * Permite dar de baja un usuario del sistema.
     *
     * @param idUsuario identificador &uacute;nico del usuario a dar de baja
     * @return si el usuario ha sido dado de baja
     */
    boolean bajaUsuario(long idUsuario);

    /**
     * Permite dar de buscar un usuario del sistema.
     *
     * @param idUsuario identifdicador &uacute;nico del usuario a dar de baja
     * @return objeto con los datosd del usuario u objeto vacio en otro caso
     */
    Usuario buscarUsuario(long idUsuario);

    /**
     * Permite dar de buscar un usuario del sistema.
     *
     * @param identidad nickname de usuario
     * @return objeto con los datosd del usuario u objeto vacio en otro caso
     */
    Usuario buscarUsuario(String identidad);

    boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion);

    boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso);

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema.
     *
     * @return numero de usuarios del sistema
     */
    long contarUsuarios();

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema perrtenecientes a una unidad especificada.
     *
     * @param idUnidadApoyo identificador único de la unidad de apoyo a la que los usuarios que se desean buscar petenecen
     * @return numero de usuarios
     * @see gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo
     */
    long contarUsuariosPorUnidadApoyo(long idUnidadApoyo);

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema perrtenecientes a un &oacute;rgano de direcci&oacute;n estrat&eacute;gica especificado.
     *
     * @param idOrganoDireccionEstrategica identificador &uacute;nico del &oacute;rgano de direcci&oacute;n estrat&eacute;gica al que los usuarios que se desean buscar petenecen
     * @return numero de usuarios
     * @see gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica
     */
    long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);

    /**
     * Obtiene el n&uacute;mero total de usuarios que tiene el sistema pertenecientes a un Programa Institucional especificado.
     *
     * @param idProgramaInstitucional identificador &uacute;nico del Programa Institucional al que los usuarios que se desean buscar petenecen
     * @return numero de usuarios
     * @see gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica
     */
    long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional);

}
