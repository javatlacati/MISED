package gob.senado.ppf.sed.repositorio.programainstitucional.impl;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.programainstitucional.ProgramaInstitucionalRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;

@Repository(value = "programaInstitucionalRepositorio")
public class ProgramaInstitucionalRepositorioImpl implements ProgramaInstitucionalRepositorio {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public ProgramaInstitucionalRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    @Override
    public boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional) {
        return jdbcTemplate.update("INSERT INTO PROGRAMA_INSTITUCIONAL(clave, nombre, descripcion) VALUES (?, ?, ?)",
                new Object[] { programaInstitucional.getClave(), programaInstitucional.getNombre(),
                    programaInstitucional.getDescripcion() }) > 0;
    }
    
    @Override
    public ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM PROGRAMA_INSTITUCIONAL WHERE id_programa_institucional = ?",
                    new Object[] { idProgramaInstitucional }, RowMappers.ROW_MAPPER_PROGRAMA_INSTITICIONAL);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }
    
    @Override
    public ProgramaInstitucional buscarProgramaInstitucional(String claveProgramaInstitucional) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM PROGRAMA_INSTITUCIONAL WHERE clave = ?",
                    new Object[] { claveProgramaInstitucional }, RowMappers.ROW_MAPPER_PROGRAMA_INSTITICIONAL);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }
    
    @Override
    public List<ProgramaInstitucional> obtenerProgramasInstitucionales() {
        return jdbcTemplate.query("SELECT * FROM PROGRAMA_INSTITUCIONAL", RowMappers.ROW_MAPPER_PROGRAMA_INSTITICIONAL);
    }
    
    @Override
    public List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional(long idProgramaInstitucional) {
        return jdbcTemplate.query("SELECT * FROM ORGANO_DIRECCION_ESTRATEGICA WHERE id_programa_institucional = ?",
                new Object[]{idProgramaInstitucional}, RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA);
    }
    
    @Override
    public List<UnidadApoyo> obtenerUnidadesApoyoPorIdProgramaInstitucional(long idProgramaInstitucional) {
        final StringBuilder sql = new StringBuilder();
        sql.append("SELECT UA.ID_UNIDAD_APOYO, UA.ID_ORGANO_DIRECCION_ESTRATEGICA, UA.NOMBRE, UA.PROPOSITO ")
                .append("FROM UNIDAD_APOYO UA INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("ON UA.ID_ORGANO_DIRECCION_eSTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                .append("INNER JOIN PROGRAMA_INSTITUCIONAL PI ON ODE.ID_PROGRAMA_INSTITUCIONAL = PI.ID_PROGRAMA_INSTITUCIONAL ")
                .append("WHERE PI.ID_PROGRAMA_INSTITUCIONAL = ?");
        return jdbcTemplate.query(sql.toString(), new Object[]{idProgramaInstitucional}, RowMappers.ROW_MAPPER_UNIDAD_APOYO);
    }
    
    
    @Override
    public boolean actualizarProgramaInstitucional(ProgramaInstitucional pi) {
        return jdbcTemplate.update(
                "UPDATE PROGRAMA_INSTITUCIONAL SET clave = ?, nombre = ?, descripcion = ? WHERE id_programa_institucional = ?",
                new Object[] { pi.getClave(), pi.getNombre(), pi.getDescripcion(),
                    pi.getIdProgramaInstitucional() }) > 0;
    }
    
    @Override
    public boolean bajaProgramaInstitucional(long idProgramaInstitucional) {
        return jdbcTemplate.update("DELETE FROM PROGRAMA_INSTITUCIONAL WHERE id_programa_institucional = ?",
                new Object[] { idProgramaInstitucional }) > 0;
    }
    
    @Override
    public long contarProgramasInstitucionales() {
        return jdbcTemplate.queryForObject("SELECT total_conteo FROM CONTAR_PROGRAMAS_INSTITUCIONALES", Long.class);
    }
    
}
