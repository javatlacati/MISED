package gob.senado.ppf.sed.dto.programainstitucional;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

/**
 * <p>
 * Clase que representa un objeto de transferencia de datos de un <b>Programa Institucional</b>, este objeto tiene como responsabilidad
 * representar un conjunto de instrumentos de política, para coadyuvar los objetivos, prioridades, estrategias y políticas
 * definidas del PND, esto quiere decir que un <b>Programa Institucional</b> es un macro elemento que es la suma de los esfuerzos
 * coordinados por los Órganos de Dirección Estratégica (ODE´s) que a su vez coordinan distintas Unidades de Apoyo (UA´s) siendo los ODE´s
 * y UA´s agrupados por <b>Programa Institucional</b>.
 * </p>
 *
 * @see gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica
 * @see gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo
 *
 * @author Benjamin Natanael Ocotzi Alvarez
 */
public class ProgramaInstitucional implements Serializable, Formateable {
    
    private static final long serialVersionUID = 1L;
    
    /** Variable que almacena el identificador numérico del programa institucional */
    private long idProgramaInstitucional;
    
    /** Variable que almacena la clave alfanumérica del programa institucional */
    private String clave;
    
    /** Variable que almacena el nombre del programa institucional */
    private String nombre;
    
    /** Variable que almacena la descripción del programa institucional */
    private String descripcion;
    
    /**
     * Constructor por defecto para la clase ProgramaInstitucional.
     */
    public ProgramaInstitucional() {
    }
    
    /**
     * Contructor privado para la clase ProgramaInstitucional
     * @param idProgramaInstitucional identificador numérico del Programa Institucional
     * @param clave Clave alfanumérica del Programa Institucional
     * @param nombre nombre del Programa Institucional
     * @param descripcion descripción del Programa Institucional
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
     * @param idProgramaInstitucional identificador numérico del Programa Institucional
     * @param clave Clave alfanumérica del Programa Institucional
     * @param nombre nombre del Programa Institucional
     * @param descripcion descripción del Programa Institucional
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
     * Metodo que retorna el identificador numérico del Programa Institucional.
     * @return Identificador numérico del Programa Institucional.
     */
    public long getIdProgramaInstitucional() {
        return this.idProgramaInstitucional;
    }
    
    /**
     * Metodo que retorna la clave alfanumérica del Programa Institucional.
     * @return Clave alfanumérica del Programa Institucional.
     */
    public String getClave() {
        return this.clave;
    }
    
    /**
     * Metodo que retorna el nombre del Programa Institucional.
     * @return Nombre del Programa Institucional.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Metodo que retorna la descripción del Programa Institucional.
     * @return Descripción del Programa Institucional.
     */
    public String getDescripcion() {
        return this.descripcion;
    }
    
    /**
     * Metodo que configura el identificador del Programa Institucional.
     * @param idProgramaInstitucional Identificador numérico del Programa Institucional.
     */
    public void setIdProgramaInstitucional(long idProgramaInstitucional) {
        this.idProgramaInstitucional = idProgramaInstitucional;
    }
    
    /**
     * Metodo que configura la clave alfanumérica del Programa Institucional.
     * @param clave Clave alfanumérica del Programa Institucional.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * Metodo que configura el nombre del Programa Institucional.
     * @param nombre Nombre del Programa Institucional.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo que configura la descripcion de un Programa Institucional.
     * @param descripcion Descripción del Programa Institucional.
     */
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
