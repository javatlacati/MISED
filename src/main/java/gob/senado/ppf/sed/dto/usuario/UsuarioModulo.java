package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"idUsuario","idModulo"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class UsuarioModulo implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idUsuarioModulo;
	private long idUsuario;
	private long idModulo;
	private boolean puedeAcceder;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
