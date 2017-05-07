package gob.senado.ppf.sed.dto.organodireccionestrategica;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

public class OrganoDireccionEstrategica implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    private long idOrganoDireccionEstrategica;
    private long idProgramaInstitucional;
    private String nombre;
    private String descripcion;
    private long totalUnidadesApoyoAdscritas;

    @java.beans.ConstructorProperties({"idOrganoDireccionEstrategica", "idProgramaInstitucional", "nombre", "descripcion"})
    private OrganoDireccionEstrategica(long idOrganoDireccionEstrategica, long idProgramaInstitucional, String nombre, String descripcion) {
        this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
        this.idProgramaInstitucional = idProgramaInstitucional;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public OrganoDireccionEstrategica() {
    }

    public static OrganoDireccionEstrategica from(long idOrganoDireccionEstrategica, long idProgramaInstitucional, String nombre, String descripcion) {
        return new OrganoDireccionEstrategica(idOrganoDireccionEstrategica, idProgramaInstitucional, nombre, descripcion);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public long getIdOrganoDireccionEstrategica() {
        return this.idOrganoDireccionEstrategica;
    }

    public long getIdProgramaInstitucional() {
        return this.idProgramaInstitucional;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setIdOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
    }

    public void setIdProgramaInstitucional(long idProgramaInstitucional) {
        this.idProgramaInstitucional = idProgramaInstitucional;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getTotalUnidadesApoyoAdscritas() {
        return totalUnidadesApoyoAdscritas;
    }

    public void setTotalUnidadesApoyoAdscritas(long totalUnidadesApoyoAdscritas) {
        this.totalUnidadesApoyoAdscritas = totalUnidadesApoyoAdscritas;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof OrganoDireccionEstrategica)) return false;
        final OrganoDireccionEstrategica other = (OrganoDireccionEstrategica) o;
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
        return other instanceof OrganoDireccionEstrategica;
    }
}
