package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

public class UsuarioPermiso implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idPermiso;
	/**
	 * Identificador &uacute;nico de cada usuario.
	 */
	private long idUsuario;
	/**
	 * Permiso de consulta.
	 */
	private boolean puedeConsultar;
	/**
	 * Permiso de modificaci&oacute;n.
	 */
	private boolean puedeActualizar;
	/**
	 * Permiso de inserci&oacute;n de nuevos registros.
	 */
	private boolean puedeAgregar;
	/**
	 * Permiso de eliminaci&oacute;n..
	 */
	private boolean puedeBorrar;
	/**
	 * Permiso de Autentificaci&oacute;n.
	 */
	private boolean puedeAutenticarse;

	public long getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(long idPermiso) {
		this.idPermiso = idPermiso;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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

	public boolean puedeConsultar() {
		return puedeConsultar;
	}

	public boolean puedeActualizar() {
		return puedeActualizar;
	}

	public boolean puedeAgregar() {
		return puedeAgregar;
	}

	public boolean puedeBorrar() {
		return puedeBorrar;
	}

	public boolean puedeAutenticarse() {
		return puedeAutenticarse;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
