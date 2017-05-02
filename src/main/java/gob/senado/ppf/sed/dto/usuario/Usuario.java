package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

// Person person = Person.from(123123L,123123L,"ssdfsdf","asd");
public class Usuario implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador &uacute;nico de cada usuario.
     */
    private long idUsuario;
    /**
     * Unidad de apoyo a la que petenece este usuario.
     *
     * @see gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo
     */
    private long idUnidadApoyo;
    /**
     * El nickname de usuario.
     */
    private String identidad;
    /**
     * Password del usuario.
     */
    private String claveAcceso;
    /**
     * Nombre del usuario del sistema.
     */
    private String nombre;
    /**
     * Primer apellido del usuario del sistema.
     */
    private String apellidoPaterno;
    /**
     * Segundo apellido del usuario del sistema.
     */
    private String apellidoMaterno;
    /**
     * Nombre del puesto laboral que ocupa.
     */
    private String puestoLaboral;
    /**
     * Direcci&oacute;n de correo electr&oacute;nico del usuario. Se espera que
     * sea un coreo elect[onico institucional.
     */
    private String correoElectronico;
    /**
     * Numero de extensi&oacute;n.
     */
    private String extensionTelefonica;
    /**
     * Nombre del rol de usuario que ocupa en el sistema.
     */
    private String rolDesignado;

    private String tipoUsuario;

    /**
     * Fecha en que se registr&oacute; en el sistema.
     */
    private String fechaRegistro;
    /**
     * Hora en que se rergistr&oacute; en el sistema.
     */
    private String horaRegistro;
    /**
     * Permisos parar el usuario actual.
     */
    private UsuarioPermiso usuarioPermiso;
    /**
     * M&oacute;dulos en los que tiene permisos el usuario actual.
     */
    private List<UsuarioModulo> usuarioModulos;

    @java.beans.ConstructorProperties({"idUsuario", "idUnidadApoyo", "identidad", "claveAcceso", "nombre", "apellidoPaterno", "apellidoMaterno", "puestoLaboral", "correoElectronico", "extensionTelefonica", "rolDesignado", "tipoUsuario", "fechaRegistro", "horaRegistro", "usuarioPermiso", "usuarioModulos"})
    private Usuario(long idUsuario, long idUnidadApoyo, String identidad, String claveAcceso, String nombre, String apellidoPaterno, String apellidoMaterno, String puestoLaboral, String correoElectronico, String extensionTelefonica, String rolDesignado, String tipoUsuario, String fechaRegistro, String horaRegistro, UsuarioPermiso usuarioPermiso, List<UsuarioModulo> usuarioModulos) {
        this.idUsuario = idUsuario;
        this.idUnidadApoyo = idUnidadApoyo;
        this.identidad = identidad;
        this.claveAcceso = claveAcceso;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puestoLaboral = puestoLaboral;
        this.correoElectronico = correoElectronico;
        this.extensionTelefonica = extensionTelefonica;
        this.rolDesignado = rolDesignado;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.usuarioPermiso = usuarioPermiso;
        this.usuarioModulos = usuarioModulos;
    }

    public Usuario() {
    }

    public static Usuario from(long idUsuario, long idUnidadApoyo, String identidad, String claveAcceso, String nombre, String apellidoPaterno, String apellidoMaterno, String puestoLaboral, String correoElectronico, String extensionTelefonica, String rolDesignado, String tipoUsuario, String fechaRegistro, String horaRegistro, UsuarioPermiso usuarioPermiso, List<UsuarioModulo> usuarioModulos) {
        return new Usuario(idUsuario, idUnidadApoyo, identidad, claveAcceso, nombre, apellidoPaterno, apellidoMaterno, puestoLaboral, correoElectronico, extensionTelefonica, rolDesignado, tipoUsuario, fechaRegistro, horaRegistro, usuarioPermiso, usuarioModulos);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public long getIdUsuario() {
        return this.idUsuario;
    }

    public long getIdUnidadApoyo() {
        return this.idUnidadApoyo;
    }

    public String getIdentidad() {
        return this.identidad;
    }

    public String getClaveAcceso() {
        return this.claveAcceso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public String getPuestoLaboral() {
        return this.puestoLaboral;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public String getExtensionTelefonica() {
        return this.extensionTelefonica;
    }

    public String getRolDesignado() {
        return this.rolDesignado;
    }

    public String getTipoUsuario() {
        return this.tipoUsuario;
    }

    public String getFechaRegistro() {
        return this.fechaRegistro;
    }

    public String getHoraRegistro() {
        return this.horaRegistro;
    }

    public UsuarioPermiso getUsuarioPermiso() {
        return this.usuarioPermiso;
    }

    public List<UsuarioModulo> getUsuarioModulos() {
        return this.usuarioModulos;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdUnidadApoyo(long idUnidadApoyo) {
        this.idUnidadApoyo = idUnidadApoyo;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setPuestoLaboral(String puestoLaboral) {
        this.puestoLaboral = puestoLaboral;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setExtensionTelefonica(String extensionTelefonica) {
        this.extensionTelefonica = extensionTelefonica;
    }

    public void setRolDesignado(String rolDesignado) {
        this.rolDesignado = rolDesignado;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setHoraRegistro(String horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public void setUsuarioPermiso(UsuarioPermiso usuarioPermiso) {
        this.usuarioPermiso = usuarioPermiso;
    }

    public void setUsuarioModulos(List<UsuarioModulo> usuarioModulos) {
        this.usuarioModulos = usuarioModulos;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Usuario)) return false;
        final Usuario other = (Usuario) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$identidad = this.getIdentidad();
        final Object other$identidad = other.getIdentidad();
        if (this$identidad == null ? other$identidad != null : !this$identidad.equals(other$identidad)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $identidad = this.getIdentidad();
        result = result * PRIME + ($identidad == null ? 43 : $identidad.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Usuario;
    }
}
