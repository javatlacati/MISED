package gob.senado.ppf.sed.dto.unidadapoyo;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.util.HtmlUtils;
import java.io.Serializable;

public class UnidadApoyo implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;
	private long idUnidadaApoyo;
	private long idOrganoDireccionEstrategica;
	private String nombre;
	private String proposito;

	public long getIdUnidadaApoyo() {
		return idUnidadaApoyo;
	}

	public void setIdUnidadaApoyo(long idUnidadaApoyo) {
		this.idUnidadaApoyo = idUnidadaApoyo;
	}

	public long getIdOrganoDireccionEstrategica() {
		return idOrganoDireccionEstrategica;
	}

	public void setIdOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = HtmlUtils.htmlEscape(nombre, Formateable.UTF_8);
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = HtmlUtils.htmlEscape(proposito, Formateable.UTF_8);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
