package gob.senado.ppf.sed.repositorio.programainstitucional.impl;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.programainstitucional.ProgramaInstitucionalRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "programaInstitucionalRepositorio")
public class ProgramaInstitucionalRepositorioImpl implements ProgramaInstitucionalRepositorio {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProgramaInstitucionalRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private Environment env;


    @Override
    public boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional) {
        System.out.println(programaInstitucional);
        return jdbcTemplate.update(
                env.getProperty("inserta_programa_institucional"),
                programaInstitucional.getClave(),
                programaInstitucional.getNombre(),
                programaInstitucional.getDescripcion()
        ) > 0;
    }

    @Override
    public ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional) {
        try {
            return jdbcTemplate.queryForObject(
                    env.getProperty("busca_programa_institucional_por_id"),
                    new Object[]{idProgramaInstitucional},
                    RowMappers.ROW_MAPPER_PROGRAMA_INSTITICIONAL
            );
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
                    env.getProperty("busca_programa_institucional_por_clave"),
                    new Object[]{claveProgramaInstitucional},
                    RowMappers.ROW_MAPPER_PROGRAMA_INSTITICIONAL);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public List<ProgramaInstitucional> obtenerProgramasInstitucionales() {
        return jdbcTemplate.query(
                env.getProperty("obtener_programas_institucionales")
                , RowMappers.ROW_MAPPER_PROGRAMA_INSTITICIONAL
        );
    }

    @Override
    public List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional(long idProgramaInstitucional) {
        return jdbcTemplate.query(
                env.getProperty("obtener_ode_por_idprogramainstitucional"),
                new Object[]{idProgramaInstitucional},
                RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA
        );
    }

    @Override
    public List<UnidadApoyo> obtenerUnidadesApoyoPorIdProgramaInstitucional(long idProgramaInstitucional) {
        return jdbcTemplate.query(
                env.getProperty("obtener_unidadesapoyo_por_idprogramainstitucional")
                , new Object[]{idProgramaInstitucional}, RowMappers.ROW_MAPPER_UNIDAD_APOYO
        );
    }


    @Override
    public boolean actualizarProgramaInstitucional(ProgramaInstitucional pi) {
        return jdbcTemplate.update(
                env.getProperty("actualizar_programa_institucional"),
                pi.getClave(), pi.getNombre(), pi.getDescripcion(),
                pi.getIdProgramaInstitucional()
        ) > 0;
    }

    @Override
    public boolean bajaProgramaInstitucional(long idProgramaInstitucional) {
        return jdbcTemplate.update(
                env.getProperty("borrar_programa_institucional"),
                idProgramaInstitucional
        ) > 0;
    }

    @Override
    public long contarProgramasInstitucionales() {
        return jdbcTemplate.queryForObject(
                env.getProperty("contar_programas_institucionales"),
                Long.class
        );
    }

}
