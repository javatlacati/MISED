package gob.senado.ppf.sed.dto.programainstitucional;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

/**
 * 
 * @author Benjamin Natanael Ocotzi Alvarez
 */
public class ProgramaInstitucional implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    private long idProgramaInstitucional;
    private String clave;
    private String nombre;
    private String descripcion;

    @java.beans.ConstructorProperties({"idProgramaInstitucional", "clave", "nombre", "descripcion"})
    private ProgramaInstitucional(long idProgramaInstitucional, String clave, String nombre, String descripcion) {
        this.idProgramaInstitucional = idProgramaInstitucional;
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ProgramaInstitucional() {
    }

    public static ProgramaInstitucional from(long idProgramaInstitucional, String clave, String nombre, String descripcion) {
        return new ProgramaInstitucional(idProgramaInstitucional, clave, nombre, descripcion);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public long getIdProgramaInstitucional() {
        return this.idProgramaInstitucional;
    }

    public String getClave() {
        return this.clave;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setIdProgramaInstitucional(long idProgramaInstitucional) {
        this.idProgramaInstitucional = idProgramaInstitucional;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ProgramaInstitucional)) return false;
        final ProgramaInstitucional other = (ProgramaInstitucional) o;
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
        return other instanceof ProgramaInstitucional;
    }
}
