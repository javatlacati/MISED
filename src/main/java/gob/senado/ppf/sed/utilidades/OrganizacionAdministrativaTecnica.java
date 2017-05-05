package gob.senado.ppf.sed.utilidades;

import java.io.Serializable;


public final class OrganizacionAdministrativaTecnica implements Serializable, Formateable{
    
    private static final long serialVersionUID = 1L;
    
    private final long idProgramaInstitucional;
    private final String claveProgramaInstitucional;
    private final String nombreProgramaInstitucional;
    private final String descripcionProgramaInstitucional;
    private final long idOrganoDireccionEstrategica;
    private final String nombreOrganoDireccionEstrategica;
    private final String descripcionOrganoDireccionEstrategica;
    private final long idUnidadApoyo;
    private final String nombreUnidadApoyo;
    private final String propositoUnidadApoyo;
    
    private OrganizacionAdministrativaTecnica(OrganizacionAdministrativaTecnicaBuilder that){
        this.idProgramaInstitucional = that.idProgramaInstitucional;
        this.claveProgramaInstitucional = that.claveProgramaInstitucional;
        this.nombreProgramaInstitucional = that.nombreProgramaInstitucional;
        this.descripcionProgramaInstitucional = that.descripcionProgramaInstitucional;
        this.idOrganoDireccionEstrategica = that.idOrganoDireccionEstrategica;
        this.nombreOrganoDireccionEstrategica = that.nombreOrganoDireccionEstrategica;
        this.descripcionOrganoDireccionEstrategica = that.descripcionOrganoDireccionEstrategica;
        this.idUnidadApoyo = that.idUnidadApoyo;
        this.nombreUnidadApoyo = that.nombreUnidadApoyo;
        this.propositoUnidadApoyo = that.propositoUnidadApoyo;
    }
    
    
    public static final class OrganizacionAdministrativaTecnicaBuilder {
        private long idProgramaInstitucional;
        private String claveProgramaInstitucional;
        private String nombreProgramaInstitucional;
        private String descripcionProgramaInstitucional;
        private long idOrganoDireccionEstrategica;
        private String nombreOrganoDireccionEstrategica;
        private String descripcionOrganoDireccionEstrategica;
        private long idUnidadApoyo;
        private String nombreUnidadApoyo;
        private String propositoUnidadApoyo;
        
        
        
    }
}
