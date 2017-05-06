package gob.senado.ppf.sed.repositorio.organizaciontecnicaadministrativa;

import gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativa;
import java.util.List;

public interface OrganizacionTecnicaAdministrativaRepositorio {
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativas();
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdProgramaInstitucional(long idProgramaInstitucional);
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdOrganoDireccionEstrategica(long idOrganoDireccionEstrategica);
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdUnidadApoyo(long idUnidadApoyo);
    
}
