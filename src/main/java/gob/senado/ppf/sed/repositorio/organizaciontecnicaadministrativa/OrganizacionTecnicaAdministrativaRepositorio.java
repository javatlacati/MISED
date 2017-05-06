package gob.senado.ppf.sed.repositorio.organizaciontecnicaadministrativa;

import gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativa;
import java.util.List;


public interface OrganizacionTecnicaAdministrativaRepositorio {
    
    List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativas();
    
}
