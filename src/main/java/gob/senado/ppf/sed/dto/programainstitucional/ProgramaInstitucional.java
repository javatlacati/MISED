package gob.senado.ppf.sed.dto.programainstitucional;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ProgramaInstitucional implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idProgramaInstitucional;
	private String clave;
	private String nombre;
	private String descripcion;

	public long getIdProgramaInstitucional() {
		return idProgramaInstitucional;
	}

	public void setIdProgramaInstitucional(long idProgramaInstitucional) {
		this.idProgramaInstitucional = idProgramaInstitucional;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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
		if(obj instanceof ProgramaInstitucional){
			final ProgramaInstitucional pi = (ProgramaInstitucional)obj;
			return this.clave.equals(pi.clave) && this.nombre.equalsIgnoreCase(pi.nombre);
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nombre, this.clave);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
