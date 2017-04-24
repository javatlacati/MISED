package gob.senado.ppf.sed.dto.usuario;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UsuarioModulo implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idUsuarioModulo;
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

	public boolean isPuedeAcceder() {
		return puedeAcceder;
	}

	public void setPuedeAcceder(boolean puedeAcceder) {
		this.puedeAcceder = puedeAcceder;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UsuarioModulo) {
			final UsuarioModulo um = (UsuarioModulo) obj;
			return (this.idUsuario == um.idUsuario && this.idModulo == um.idModulo);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.idUsuario, this.idModulo);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
