package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"idUsuario","idPermiso"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class UsuarioPermiso implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idPermiso;
	/**
	 * Identificador &uacute;nico de cada usuario.
	 */
	private long idUsuario;
	private boolean puedeConsultar;
	private boolean puedeActualizar;
	private boolean puedeAgregar;
	private boolean puedeBorrar;
	private boolean puedeAutenticarse;

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
