package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Usuario implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idUsuario;
	private long idUnidadApoyo;
	private String identidad;
	private String claveAcceso;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String puestoLaboral;
	private String correoElectronico;
	private String extensionTelefonica;
	private String rolDesignado;
	private String fechaRegistro;
	private String horaRegistro;
	private UsuarioPermiso usuarioPermiso;
	private ActividadExtemporanea actividadExtemporanea;
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

	public ActividadExtemporanea getActividadExtemporanea() {
		return actividadExtemporanea;
	}

	public void setActividadExtemporanea(ActividadExtemporanea actividadExtemporanea) {
		this.actividadExtemporanea = actividadExtemporanea;
	}

	public List<UsuarioModulo> getUsuarioModulos() {
		return usuarioModulos;
	}

	public void setUsuarioModulos(List<UsuarioModulo> usuarioModulos) {
		this.usuarioModulos = usuarioModulos;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			final Usuario u = (Usuario) obj;
			return this.getIdentidad().equalsIgnoreCase(u.getIdentidad())
					&& this.getUsuarioPermiso().equals(u.getUsuarioPermiso());
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return ((this.identidad.length() * 22 + 5) % 2 == 0)
				? this.identidad.length() * 22 + 5 * 1 + this.identidad.hashCode()
				: this.identidad.length() * 122 + 2 + this.identidad.length();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
