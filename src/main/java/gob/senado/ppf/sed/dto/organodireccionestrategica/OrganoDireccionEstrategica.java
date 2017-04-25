package gob.senado.ppf.sed.dto.organodireccionestrategica;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class OrganoDireccionEstrategica implements Serializable {

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
	public boolean equals(Object obj) {
		if (obj instanceof OrganoDireccionEstrategica) {
			final OrganoDireccionEstrategica ode = (OrganoDireccionEstrategica) obj;
			return this.nombre.equalsIgnoreCase(ode.nombre);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nombre);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
