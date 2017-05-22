package gob.senado.ppf.sed.dto.unidadapoyo;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class UnidadApoyo implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    private long idProgramaInstitucional;
    private String claveProgramaInstitucional;
    private String nombreProgramaInstitucional;
    private String descripcionProgramaInstitucional;
    private long idOrganoDireccionEstrategica;
    private String nombreOrganoDireccionEstrategica;
    private String descripcionOrganoDireccionEstrategica;
    private long idUnidadApoyo;
    private String nombre;
    private String proposito;
    private long totalUsuariosAdscritosUnidadApoyo;

    @java.beans.ConstructorProperties({"idProgramaInstitucional", "claveProgramaInstitucional", "nombreProgramaInstitucional", "descripcionProgramaInstitucional", "idOrganoDireccionEstrategica", "nombreOrganoDireccionEstrategica", "descripcionOrganoDireccionEstrategica", "idUnidadApoyo", "nombre", "proposito", "totalUsuariosAdscritosUnidadApoyo"})
    private UnidadApoyo(long idProgramaInstitucional, String claveProgramaInstitucional, String nombreProgramaInstitucional, String descripcionProgramaInstitucional, long idOrganoDireccionEstrategica, String nombreOrganoDireccionEstrategica, String descripcionOrganoDireccionEstrategica, long idUnidadApoyo, String nombre, String proposito, long totalUsuariosAdscritosUnidadApoyo) {
        this.idProgramaInstitucional = idProgramaInstitucional;
        this.claveProgramaInstitucional = claveProgramaInstitucional;
        this.nombreProgramaInstitucional = nombreProgramaInstitucional;
        this.descripcionProgramaInstitucional = descripcionProgramaInstitucional;
        this.idOrganoDireccionEstrategica = idOrganoDireccionEstrategica;
        this.nombreOrganoDireccionEstrategica = nombreOrganoDireccionEstrategica;
        this.descripcionOrganoDireccionEstrategica = descripcionOrganoDireccionEstrategica;
        this.idUnidadApoyo = idUnidadApoyo;
        this.nombre = nombre;
        this.proposito = proposito;
        this.totalUsuariosAdscritosUnidadApoyo = totalUsuariosAdscritosUnidadApoyo;
    }

    public UnidadApoyo() {
    }

    public static UnidadApoyo from(long idProgramaInstitucional, String claveProgramaInstitucional, String nombreProgramaInstitucional, String descripcionProgramaInstitucional, long idOrganoDireccionEstrategica, String nombreOrganoDireccionEstrategica, String descripcionOrganoDireccionEstrategica, long idUnidadApoyo, String nombre, String proposito, long totalUsuariosAdscritosUnidadApoyo) {
        return new UnidadApoyo(idProgramaInstitucional, claveProgramaInstitucional, nombreProgramaInstitucional, descripcionProgramaInstitucional, idOrganoDireccionEstrategica, nombreOrganoDireccionEstrategica, descripcionOrganoDireccionEstrategica, idUnidadApoyo, nombre, proposito, totalUsuariosAdscritosUnidadApoyo);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public long getIdProgramaInstitucional() {
        return this.idProgramaInstitucional;
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

    public String getNombreOrganoDireccionEstrategica() {
        return this.nombreOrganoDireccionEstrategica;
    }

    public String getDescripcionOrganoDireccionEstrategica() {
        return this.descripcionOrganoDireccionEstrategica;
    }

    public long getIdUnidadApoyo() {
        return this.idUnidadApoyo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getProposito() {
        return this.proposito;
    }

    public long getTotalUsuariosAdscritosUnidadApoyo() {
        return this.totalUsuariosAdscritosUnidadApoyo;
    }

    public void setIdProgramaInstitucional(long idProgramaInstitucional) {
        this.idProgramaInstitucional = idProgramaInstitucional;
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

    public void setNombreOrganoDireccionEstrategica(String nombreOrganoDireccionEstrategica) {
        this.nombreOrganoDireccionEstrategica = nombreOrganoDireccionEstrategica;
    }

    public void setDescripcionOrganoDireccionEstrategica(String descripcionOrganoDireccionEstrategica) {
        this.descripcionOrganoDireccionEstrategica = descripcionOrganoDireccionEstrategica;
    }

    public void setIdUnidadApoyo(long idUnidadApoyo) {
        this.idUnidadApoyo = idUnidadApoyo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
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
