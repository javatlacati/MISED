package gob.senado.ppf.sed.dto.usuario;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import gob.senado.ppf.sed.utilidades.Formateable;


public class UsuarioPermiso implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idPermiso;
	private long idUsuario;
	private boolean puedeConsultar;
	private boolean puedeActualizar;
	private boolean puedeAgregar;
	private boolean puedeBorrar;
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

	public boolean puedeConsultar() {
		return puedeConsultar;
	}

	public void setPuedeConsultar(boolean puedeConsultar) {
		this.puedeConsultar = puedeConsultar;
	}

	public boolean puedeActualizar() {
		return puedeActualizar;
	}

	public void setPuedeActualizar(boolean puedeActualizar) {
		this.puedeActualizar = puedeActualizar;
	}

	public boolean puedeAgregar() {
		return puedeAgregar;
	}

	public void setPuedeAgregar(boolean puedeAgregar) {
		this.puedeAgregar = puedeAgregar;
	}

	public boolean puedeBorrar() {
		return puedeBorrar;
	}

	public void setPuedeBorrar(boolean puedeBorrar) {
		this.puedeBorrar = puedeBorrar;
	}

	public boolean puedeAutenticarse() {
		return puedeAutenticarse;
	}

	public void setPuedeAutenticarse(boolean puedeAutenticarse) {
		this.puedeAutenticarse = puedeAutenticarse;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UsuarioPermiso) {
			final UsuarioPermiso up = (UsuarioPermiso) obj;
			return this.idUsuario == up.idUsuario;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.idPermiso); 
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
