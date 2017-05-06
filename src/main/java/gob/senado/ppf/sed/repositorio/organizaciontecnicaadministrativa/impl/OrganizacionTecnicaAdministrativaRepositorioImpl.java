package gob.senado.ppf.sed.repositorio.organizaciontecnicaadministrativa.impl;

import gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativa;
import gob.senado.ppf.sed.repositorio.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativaRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "organizacionTecnicaAdministrativaRepositorio")
public class OrganizacionTecnicaAdministrativaRepositorioImpl implements OrganizacionTecnicaAdministrativaRepositorio{
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public OrganizacionTecnicaAdministrativaRepositorioImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativas() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PROGRAMA_INSTITUCIONAL PI ")
                .append("INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL ")
                .append("INNER JOIN UNIDAD_APOYO UA ")
                .append("ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA");
        return jdbcTemplate.query(sql.toString(), RowMappers.ROW_MAPPER_ORGANIZACION_TECNICA_ADMINISTRATIVA);
    }
    
    @Override
    public List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdProgramaInstitucional(long idProgramaInstitucional) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PROGRAMA_INSTITUCIONAL PI ")
                .append("INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL ")
                .append("INNER JOIN UNIDAD_APOYO UA ")
                .append("ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                .append("WHERE PI.ID_PROGRAMA_INSTITUCIONAL = ?");
        return jdbcTemplate.query(sql.toString(), new Object[]{idProgramaInstitucional}, RowMappers.ROW_MAPPER_ORGANIZACION_TECNICA_ADMINISTRATIVA);
    }
    
    @Override
    public List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PROGRAMA_INSTITUCIONAL PI ")
                .append("INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL ")
                .append("INNER JOIN UNIDAD_APOYO UA ")
                .append("ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                .append("WHERE ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = ?");
        return jdbcTemplate.query(sql.toString(), new Object[]{idOrganoDireccionEstrategica}, RowMappers.ROW_MAPPER_ORGANIZACION_TECNICA_ADMINISTRATIVA);
    }
    
    @Override
    public List<OrganizacionTecnicaAdministrativa> obtenerOrganizacionesTecnicasAdministrativasPorIdUnidadApoyo(long idUnidadApoyo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PROGRAMA_INSTITUCIONAL PI ")
                .append("INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL ")
                .append("INNER JOIN UNIDAD_APOYO UA ")
                .append("ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                .append("WHERE UA.ID_UNIDAD_APOYO = ?");
        return jdbcTemplate.query(sql.toString(), new Object[]{idUnidadApoyo}, RowMappers.ROW_MAPPER_ORGANIZACION_TECNICA_ADMINISTRATIVA);
    }
    
    
}
