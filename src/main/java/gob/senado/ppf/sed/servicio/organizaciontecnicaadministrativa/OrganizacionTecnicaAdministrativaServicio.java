package gob.senado.ppf.sed.servicio.organizaciontecnicaadministrativa;

import gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativa;
import java.util.List;

public interface OrganizacionTecnicaAdministrativaServicio {
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativas();
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdProgramaInstitucional(long idProgramaInstitucional);
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdUnidadApoyo(long idUnidadApoyo);
    
}
