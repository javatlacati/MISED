package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"idHistorialActividadExtemporanea"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class HistorialActividadExtemporanea implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idHistorialActividadExtemporanea;
	private long idActividadExtemporanea;
	/**
	 * Identificador &uacute;nico de cada usuario.
	 */
	private long idUsuario;
	private boolean solicitoFasePlaneacion;
	private boolean solicitoFaseCalendarizacion;
	private boolean solicitoFasePrimerCuatrimestre;
	private boolean solicitoFaseSegundoCuatrimestre;
	private boolean solicitoFaseTercerCuatrimestre;
	private String fechaSolicitud;
	private String horaSolicitud;


	public boolean solicitoFaseCalendarizacion() {
		return solicitoFaseCalendarizacion;
	}

	public boolean solicitoFasePrimerCuatrimestre() {
		return solicitoFasePrimerCuatrimestre;
	}

	public boolean solicitoFaseSegundoCuatrimestre() {
		return solicitoFaseSegundoCuatrimestre;
	}

	public boolean solicitoFaseTercerCuatrimestre() {
		return solicitoFaseTercerCuatrimestre;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
