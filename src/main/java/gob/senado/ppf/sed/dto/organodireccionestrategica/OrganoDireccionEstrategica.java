package gob.senado.ppf.sed.dto.organodireccionestrategica;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.util.HtmlUtils;
import java.io.Serializable;

public class OrganoDireccionEstrategica implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idOrganoDireccionEstrategica;
	private long idProgramaInstitucional;
	private String nombre;
	private String descripcion;

	public long getIdOrganoDireccionEstrategica() {
		return idOrganoDireccionEstrategica;
	}

	public void setIdOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
	}

	public long getIdProgramaInstitucional() {
		return idProgramaInstitucional;
	}

	public void setIdProgramaInstitucional(long idProgramaInstitucional) {
		this.idProgramaInstitucional = idProgramaInstitucional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
