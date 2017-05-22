package gob.senado.ppf.sed.dto.organodireccionestrategica;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class OrganoDireccionEstrategica implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    private String claveProgramaInstitucional;
    private String nombreProgramaInstitucional;
    private String descripcionProgramaInstitucional;
    private long idOrganoDireccionEstrategica;
    private long idProgramaInstitucional;
    private String nombre;
    private String descripcion;
    private long totalUnidadesApoyoAdscritas;

    @java.beans.ConstructorProperties({"claveProgramaInstitucional", "nombreProgramaInstitucional", "descripcionProgramaInstitucional", "idOrganoDireccionEstrategica", "idProgramaInstitucional", "nombre", "descripcion", "totalUnidadesApoyoAdscritas"})
    private OrganoDireccionEstrategica(String claveProgramaInstitucional, String nombreProgramaInstitucional, String descripcionProgramaInstitucional, long idOrganoDireccionEstrategica, long idProgramaInstitucional, String nombre, String descripcion, long totalUnidadesApoyoAdscritas) {
        this.claveProgramaInstitucional = claveProgramaInstitucional;
        this.nombreProgramaInstitucional = nombreProgramaInstitucional;
        this.descripcionProgramaInstitucional = descripcionProgramaInstitucional;
        this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
        this.idProgramaInstitucional = idProgramaInstitucional;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.totalUnidadesApoyoAdscritas = totalUnidadesApoyoAdscritas;
    }

    public OrganoDireccionEstrategica() {
    }

    public static OrganoDireccionEstrategica from(String claveProgramaInstitucional, String nombreProgramaInstitucional, String descripcionProgramaInstitucional, long idOrganoDireccionEstrategica, long idProgramaInstitucional, String nombre, String descripcion, long totalUnidadesApoyoAdscritas) {
        return new OrganoDireccionEstrategica(claveProgramaInstitucional, nombreProgramaInstitucional, descripcionProgramaInstitucional, idOrganoDireccionEstrategica, idProgramaInstitucional, nombre, descripcion, totalUnidadesApoyoAdscritas);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public String getClaveProgramaInstitucional() {
        return this.claveProgramaInstitucional;
    }

    public String getNombreProgramaInstitucional() {
        return this.nombreProgramaInstitucional;
    }

    public String getDescripcionProgramaInstitucional() {
        return this.descripcionProgramaInstitucional;
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

    public long getTotalUnidadesApoyoAdscritas() {
        return this.totalUnidadesApoyoAdscritas;
    }

    public void setClaveProgramaInstitucional(String claveProgramaInstitucional) {
        this.claveProgramaInstitucional = claveProgramaInstitucional;
    }

    public void setNombreProgramaInstitucional(String nombreProgramaInstitucional) {
        this.nombreProgramaInstitucional = nombreProgramaInstitucional;
    }

    public void setDescripcionProgramaInstitucional(String descripcionProgramaInstitucional) {
        this.descripcionProgramaInstitucional = descripcionProgramaInstitucional;
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
