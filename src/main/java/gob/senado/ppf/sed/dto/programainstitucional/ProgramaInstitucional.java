package gob.senado.ppf.sed.dto.programainstitucional;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

public class ProgramaInstitucional implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idProgramaInstitucional;
	private String clave;
	private String nombre;
	private String descripcion;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
