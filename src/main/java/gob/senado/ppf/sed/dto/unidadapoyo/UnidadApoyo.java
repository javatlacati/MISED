package gob.senado.ppf.sed.dto.unidadapoyo;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UnidadApoyo implements Serializable {

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
		this.nombre = nombre;
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnidadApoyo) {
			final UnidadApoyo ua = (UnidadApoyo) obj;
			return this.nombre.equalsIgnoreCase(ua.nombre);
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
