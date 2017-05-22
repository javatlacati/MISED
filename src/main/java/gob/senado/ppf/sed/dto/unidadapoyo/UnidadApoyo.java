package gob.senado.ppf.sed.dto.unidadapoyo;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class UnidadApoyo implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;
    private long idUnidadApoyo;
    private long idOrganoDireccionEstrategica;
    private String nombre;
    private String proposito;
    private long totalUsuariosAdscritosUnidadApoyo;

    @java.beans.ConstructorProperties({"idUnidadApoyo", "idOrganoDireccionEstrategica", "nombre", "proposito"})
    private UnidadApoyo(long idUnidadApoyo, long idOrganoDireccionEstrategica, String nombre, String proposito) {
        this.idUnidadApoyo = idUnidadApoyo;
        this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
        this.nombre = nombre;
        this.proposito = proposito;
    }

    public UnidadApoyo() {
    }

    public static UnidadApoyo from(long idUnidadApoyo, long idOrganoDireccionEstrategica, String nombre, String proposito) {
        return new UnidadApoyo(idUnidadApoyo, idOrganoDireccionEstrategica, nombre, proposito);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public long getIdUnidadApoyo() {
        return this.idUnidadApoyo;
    }

    public long getIdOrganoDireccionEstrategica() {
        return this.idOrganoDireccionEstrategica;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getProposito() {
        return this.proposito;
    }

    public void setIdUnidadApoyo(long idUnidadApoyo) {
        this.idUnidadApoyo = idUnidadApoyo;
    }

    public void setIdOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public long getTotalUsuariosAdscritosUnidadApoyo() {
        return totalUsuariosAdscritosUnidadApoyo;
    }

    public void setTotalUsuariosAdscritosUnidadApoyo(long totalUsuariosAdscritosUnidadApoyo) {
        this.totalUsuariosAdscritosUnidadApoyo = totalUsuariosAdscritosUnidadApoyo;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UnidadApoyo)) return false;
        final UnidadApoyo other = (UnidadApoyo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$nombre = this.getNombre();
        final Object other$nombre = other.getNombre();
        if (this$nombre == null ? other$nombre != null : !this$nombre.equals(other$nombre)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $nombre = this.getNombre();
        result = result * PRIME + ($nombre == null ? 43 : $nombre.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UnidadApoyo;
    }
}
