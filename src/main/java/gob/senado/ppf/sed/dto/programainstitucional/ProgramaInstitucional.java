package gob.senado.ppf.sed.dto.programainstitucional;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.util.HtmlUtils;
import java.io.Serializable;

public class ProgramaInstitucional implements Serializable, Formateable {

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
		this.clave = HtmlUtils.htmlEscape(clave, Formateable.UTF_8);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = HtmlUtils.htmlEscape(nombre, Formateable.UTF_8);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = HtmlUtils.htmlEscape(descripcion, Formateable.UTF_8);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
