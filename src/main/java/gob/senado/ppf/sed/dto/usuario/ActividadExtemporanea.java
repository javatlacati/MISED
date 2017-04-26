package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"idUsuario"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class ActividadExtemporanea implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idActividadExtemporanea;
	private long idUsuario;
	private boolean fasePlaneacion;
	private boolean faseCalendarizacion;
	private boolean fasePrimerCuatrimestre;
	private boolean faseSegundoCuatrimestre;
	private boolean faseTercerCuatrimestre;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
