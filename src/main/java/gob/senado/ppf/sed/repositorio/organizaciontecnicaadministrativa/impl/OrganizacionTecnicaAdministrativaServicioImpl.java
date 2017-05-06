package gob.senado.ppf.sed.repositorio.organizaciontecnicaadministrativa.impl;

import gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativa;
import gob.senado.ppf.sed.repositorio.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativaRepositorio;
import gob.senado.ppf.sed.servicio.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "organizacionTecnicaAdministrativaServicio")
public class OrganizacionTecnicaAdministrativaServicioImpl implements OrganizacionTecnicaAdministrativaServicio{
    
    private OrganizacionTecnicaAdministrativaRepositorio organizacionTecnicaAdministrativaRepositorio;
    
    @Autowired
    public OrganizacionTecnicaAdministrativaServicioImpl(OrganizacionTecnicaAdministrativaRepositorio organizacionTecnicaAdministrativaRepositorio) {
        this.organizacionTecnicaAdministrativaRepositorio = organizacionTecnicaAdministrativaRepositorio;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativas() {
        return organizacionTecnicaAdministrativaRepositorio.obtenerOrganizacionesTecnicasAdministrativas();
    }
    
}
