package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

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

    /*
     * Permisos parar el usuario actual.
     */


    private boolean puedeConsultar;
    private boolean puedeActualizar;
    private boolean puedeAgregar;
    private boolean puedeBorrar;
    private boolean puedeAutenticarse;

    private String claveProgramaInstitucionalAdscrito;
    private String nombreProgramaInstitucionalAdscrito;
    private String nombreOrganoDireccionEstrategicaAdscrito;
    private String nombreUnidadApoyoAdscrito;

    @java.beans.ConstructorProperties({"idUsuario", "idUnidadApoyo", "identidad", "claveAcceso", "nombre", "apellidoPaterno", "apellidoMaterno", "puestoLaboral", "correoElectronico", "extensionTelefonica", "rolDesignado", "tipoUsuario", "fechaRegistro", "horaRegistro", "puedeConsultar", "puedeActualizar", "puedeAgregar", "puedeBorrar", "puedeAutenticarse", "claveProgramaInstitucionalAdscrito", "nombreProgramaInstitucionalAdscrito", "nombreOrganoDireccionEstrategicaAdscrito", "nombreUnidadApoyoAdscrito"})
    private Usuario(long idUsuario, long idUnidadApoyo, String identidad, String claveAcceso, String nombre, String apellidoPaterno, String apellidoMaterno, String puestoLaboral, String correoElectronico, String extensionTelefonica, String rolDesignado, String tipoUsuario, String fechaRegistro, String horaRegistro, boolean puedeConsultar, boolean puedeActualizar, boolean puedeAgregar, boolean puedeBorrar, boolean puedeAutenticarse, String claveProgramaInstitucionalAdscrito, String nombreProgramaInstitucionalAdscrito, String nombreOrganoDireccionEstrategicaAdscrito, String nombreUnidadApoyoAdscrito) {
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
        this.puedeConsultar = puedeConsultar;
        this.puedeActualizar = puedeActualizar;
        this.puedeAgregar = puedeAgregar;
        this.puedeBorrar = puedeBorrar;
        this.puedeAutenticarse = puedeAutenticarse;
        this.claveProgramaInstitucionalAdscrito = claveProgramaInstitucionalAdscrito;
        this.nombreProgramaInstitucionalAdscrito = nombreProgramaInstitucionalAdscrito;
        this.nombreOrganoDireccionEstrategicaAdscrito = nombreOrganoDireccionEstrategicaAdscrito;
        this.nombreUnidadApoyoAdscrito = nombreUnidadApoyoAdscrito;
    }

    public Usuario() {
    }

    public static Usuario from(long idUsuario, long idUnidadApoyo, String identidad, String claveAcceso, String nombre, String apellidoPaterno, String apellidoMaterno, String puestoLaboral, String correoElectronico, String extensionTelefonica, String rolDesignado, String tipoUsuario, String fechaRegistro, String horaRegistro, boolean puedeConsultar, boolean puedeActualizar, boolean puedeAgregar, boolean puedeBorrar, boolean puedeAutenticarse, String claveProgramaInstitucionalAdscrito, String nombreProgramaInstitucionalAdscrito, String nombreOrganoDireccionEstrategicaAdscrito, String nombreUnidadApoyoAdscrito) {
        return new Usuario(idUsuario, idUnidadApoyo, identidad, claveAcceso, nombre, apellidoPaterno, apellidoMaterno, puestoLaboral, correoElectronico, extensionTelefonica, rolDesignado, tipoUsuario, fechaRegistro, horaRegistro, puedeConsultar, puedeActualizar, puedeAgregar, puedeBorrar, puedeAutenticarse, claveProgramaInstitucionalAdscrito, nombreProgramaInstitucionalAdscrito, nombreOrganoDireccionEstrategicaAdscrito, nombreUnidadApoyoAdscrito);
    }

    /*
     * M&oacute;dulos en los que tiene permisos el usuario actual.
     */
//    private List<UsuarioModulo> usuarioModulos;

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

    public boolean isPuedeConsultar() {
        return this.puedeConsultar;
    }

    public boolean isPuedeActualizar() {
        return this.puedeActualizar;
    }

    public boolean isPuedeAgregar() {
        return this.puedeAgregar;
    }

    public boolean isPuedeBorrar() {
        return this.puedeBorrar;
    }

    public boolean isPuedeAutenticarse() {
        return this.puedeAutenticarse;
    }

    public String getClaveProgramaInstitucionalAdscrito() {
        return this.claveProgramaInstitucionalAdscrito;
    }

    public String getNombreProgramaInstitucionalAdscrito() {
        return this.nombreProgramaInstitucionalAdscrito;
    }

    public String getNombreOrganoDireccionEstrategicaAdscrito() {
        return this.nombreOrganoDireccionEstrategicaAdscrito;
    }

    public String getNombreUnidadApoyoAdscrito() {
        return this.nombreUnidadApoyoAdscrito;
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

    public void setPuedeConsultar(boolean puedeConsultar) {
        this.puedeConsultar = puedeConsultar;
    }

    public void setPuedeActualizar(boolean puedeActualizar) {
        this.puedeActualizar = puedeActualizar;
    }

    public void setPuedeAgregar(boolean puedeAgregar) {
        this.puedeAgregar = puedeAgregar;
    }

    public void setPuedeBorrar(boolean puedeBorrar) {
        this.puedeBorrar = puedeBorrar;
    }

    public void setPuedeAutenticarse(boolean puedeAutenticarse) {
        this.puedeAutenticarse = puedeAutenticarse;
    }

    public void setClaveProgramaInstitucionalAdscrito(String claveProgramaInstitucionalAdscrito) {
        this.claveProgramaInstitucionalAdscrito = claveProgramaInstitucionalAdscrito;
    }

    public void setNombreProgramaInstitucionalAdscrito(String nombreProgramaInstitucionalAdscrito) {
        this.nombreProgramaInstitucionalAdscrito = nombreProgramaInstitucionalAdscrito;
    }

    public void setNombreOrganoDireccionEstrategicaAdscrito(String nombreOrganoDireccionEstrategicaAdscrito) {
        this.nombreOrganoDireccionEstrategicaAdscrito = nombreOrganoDireccionEstrategicaAdscrito;
    }

    public void setNombreUnidadApoyoAdscrito(String nombreUnidadApoyoAdscrito) {
        this.nombreUnidadApoyoAdscrito = nombreUnidadApoyoAdscrito;
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
