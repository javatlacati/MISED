package gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.utilidades.Formateable;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OrganizacionTecnicaAdministrativa implements Serializable, Formateable{
    public ProgramaInstitucional programInstitucional;
    public OrganoDireccionEstrategica organoDireccionEstrategica;
    public UnidadApoyo unidadApoyo;
    
    public OrganoDireccionEstrategica getOrganoDireccionEstrategica() {
        return organoDireccionEstrategica;
    }
    
    public ProgramaInstitucional getProgramInstitucional() {
        return programInstitucional;
    }
    
    public UnidadApoyo getUnidadApoyo() {
        return unidadApoyo;
    }
    
    public void setOrganoDireccionEstrategica(OrganoDireccionEstrategica organoDireccionEstrategica) {
        this.organoDireccionEstrategica = organoDireccionEstrategica;
    }
    
    public void setProgramInstitucional(ProgramaInstitucional programInstitucional) {
        this.programInstitucional = programInstitucional;
    }
    
    public void setUnidadApoyo(UnidadApoyo unidadApoyo) {
        this.unidadApoyo = unidadApoyo;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    } 
    
}
