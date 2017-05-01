package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.List;

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
	private String identidad;
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
	private UsuarioPermiso usuarioPermiso;
	/**
	 * M&oacute;dulos en los que tiene permisos el usuario actual.
	 */
	private List<UsuarioModulo> usuarioModulos;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdUnidadApoyo() {
		return idUnidadApoyo;
	}

	public void setIdUnidadApoyo(long idUnidadApoyo) {
		this.idUnidadApoyo = idUnidadApoyo;
	}

	public String getIdentidad() {
		return identidad;
	}

	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getPuestoLaboral() {
		return puestoLaboral;
	}

	public void setPuestoLaboral(String puestoLaboral) {
		this.puestoLaboral = puestoLaboral;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getExtensionTelefonica() {
		return extensionTelefonica;
	}

	public void setExtensionTelefonica(String extensionTelefonica) {
		this.extensionTelefonica = extensionTelefonica;
	}

	public String getRolDesignado() {
		return rolDesignado;
	}

	public void setRolDesignado(String rolDesignado) {
		this.rolDesignado = rolDesignado;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public UsuarioPermiso getUsuarioPermiso() {
		return usuarioPermiso;
	}

	public void setUsuarioPermiso(UsuarioPermiso usuarioPermiso) {
		this.usuarioPermiso = usuarioPermiso;
	}

	public List<UsuarioModulo> getUsuarioModulos() {
		return usuarioModulos;
	}

	public void setUsuarioModulos(List<UsuarioModulo> usuarioModulos) {
		this.usuarioModulos = usuarioModulos;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
