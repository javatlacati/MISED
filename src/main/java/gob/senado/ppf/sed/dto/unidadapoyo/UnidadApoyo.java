package gob.senado.ppf.sed.dto.unidadapoyo;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"nombre"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class UnidadApoyo implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;
	private long idUnidadaApoyo;
	private long idOrganoDireccionEstrategica;
	private String nombre;
	private String proposito;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
