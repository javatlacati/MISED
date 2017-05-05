package gob.senado.ppf.sed.dto.programainstitucional;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Representa un objeto de transferencia de datos de un <b>Programa Institucional</b>.
 * Este objeto tiene como responsabilidad
 * representar un conjunto de instrumentos de pol&iacute;tica, para coadyuvar los objetivos, prioridades, estrategias y pol&iacute;ticas
 * definidas del PND, esto quiere decir que un <b>Programa Institucional</b> es un macro elemento que es la suma de los esfuerzos
 * coordinados por los &Oacute;rganos de Direcci&oacute;n Estrat&eacute;gica (ODE&acute;s) que a su vez coordinan distintas Unidades de 
 * Apoyo (UA&acute;s) siendo los ODE&acute;s
 * y UA&acute;s agrupados por <b>Programa Institucional</b>.
 *
 * @author Benjamin Natanael Ocotzi Alvarez
 * @see gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica
 * @see gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo
 */
public class ProgramaInstitucional implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador num&eacute;rico del programa institucional
     */
    private long idProgramaInstitucional;

    /**
     * Clave alfanum&eacute;rica del programa institucional
     */
    private String clave;

    /**
     * Nombre del programa institucional
     */
    private String nombre;

    /**
     * Descripci&oacute;n del programa institucional
     */
    private String descripcion;

    /**
     * Constructor por defecto para la clase ProgramaInstitucional.
     */
    public ProgramaInstitucional() {
    }

    /**
     * Contructor privado para la clase ProgramaInstitucional
     *
     * @param idProgramaInstitucional identificador num&eacute;rico del Programa Institucional
     * @param clave                   Clave alfanum&eacute;rica del Programa Institucional
     * @param nombre                  nombre del Programa Institucional
     * @param descripcion             descripci&oacute;n del Programa Institucional
     */
    @java.beans.ConstructorProperties({"idProgramaInstitucional", "clave", "nombre", "descripcion"})
    private ProgramaInstitucional(long idProgramaInstitucional, String clave, String nombre, String descripcion) {
        this.idProgramaInstitucional = idProgramaInstitucional;
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Metodo estatico de conveniencia para obtener una instancia de la clase ProgramaInstitucional recibiendo como parametros todos los
     * atributos de esta clase.
     *
     * @param idProgramaInstitucional identificador num&eacute;rico del Programa Institucional
     * @param clave                   Clave alfanum&eacute;rica del Programa Institucional
     * @param nombre                  nombre del Programa Institucional
     * @param descripcion             descripci&oacute;n del Programa Institucional
     * @return Una nueva instancia de la clase ProgramaInstitucional con todos sus atributos configurados.
     */
    public static ProgramaInstitucional from(long idProgramaInstitucional, String clave, String nombre, String descripcion) {
        return new ProgramaInstitucional(idProgramaInstitucional, clave, nombre, descripcion);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    /**
     * Retorna el identificador num&eacute;rico del Programa Institucional.
     *
     * @return Identificador num&eacute;rico del Programa Institucional.
     */
    public long getIdProgramaInstitucional() {
        return this.idProgramaInstitucional;
    }

    /**
     * Retorna la clave alfanum&eacute;rica del Programa Institucional.
     *
     * @return Clave alfanum&eacute;rica del Programa Institucional.
     */
    public String getClave() {
        return this.clave;
    }

    /**
     * Retorna el nombre del Programa Institucional.
     *
     * @return Nombre del Programa Institucional.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Retorna la descripci&oacute;n del Programa Institucional.
     *
     * @return Descripci&oacute;n del Programa Institucional.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Configura el identificador del Programa Institucional.
     *
     * @param idProgramaInstitucional Identificador num&eacute;rico del Programa Institucional.
     */
    public void setIdProgramaInstitucional(long idProgramaInstitucional) {
        this.idProgramaInstitucional = idProgramaInstitucional;
    }

    /**
     * Configura la clave alfanum&eacute;rica del Programa Institucional.
     *
     * @param clave Clave alfanum&eacute;rica del Programa Institucional.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Configura el nombre del Programa Institucional.
     *
     * @param nombre Nombre del Programa Institucional.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Configura la descripcion de un Programa Institucional.
     *
     * @param descripcion Descripci&oacute;n del Programa Institucional.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ProgramaInstitucional)) return false;
        final ProgramaInstitucional other = (ProgramaInstitucional) o;
        if (!other.canEqual(this)) return false;
        final Object this$nombre = this.getNombre();
        final Object other$nombre = other.getNombre();
        return this$nombre == null ? other$nombre == null : this$nombre.equals(other$nombre);
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $nombre = this.getNombre();
        result = result * PRIME + ($nombre == null ? 43 : $nombre.hashCode());
        return result;
    }

    private boolean canEqual(Object other) {
        return other instanceof ProgramaInstitucional;
    }
}
