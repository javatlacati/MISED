package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class UsuarioModulo implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idUsuarioModulo;
	/**
	 * Identificador &uacute;nico de cada usuario.
	 */
	private long idUsuario;
	private long idModulo;
	private boolean puedeAcceder;

	public long getIdUsuarioModulo() {
		return idUsuarioModulo;
	}

	public void setIdUsuarioModulo(long idUsuarioModulo) {
		this.idUsuarioModulo = idUsuarioModulo;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(long idModulo) {
		this.idModulo = idModulo;
	}

	public boolean puedeAcceder() {
		return puedeAcceder;
	}

	public void setPuedeAcceder(boolean puedeAcceder) {
		this.puedeAcceder = puedeAcceder;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
