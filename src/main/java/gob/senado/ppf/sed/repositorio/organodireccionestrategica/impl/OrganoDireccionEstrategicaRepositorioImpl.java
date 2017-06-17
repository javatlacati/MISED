package gob.senado.ppf.sed.repositorio.organodireccionestrategica.impl;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.repositorio.organodireccionestrategica.OrganoDireccionEstrategicaRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "organoDireccionEstrategicaRepositorio")
public class OrganoDireccionEstrategicaRepositorioImpl implements OrganoDireccionEstrategicaRepositorio {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Environment env;

    @Autowired
    public OrganoDireccionEstrategicaRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean altaOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
        return jdbcTemplate.update(
                env.getProperty("alta_ode"),
                new Object[]{ode.getIdProgramaInstitucional(), ode.getNombre(), ode.getDescripcion()}
        ) > 0;
    }

    @Override
    public boolean bajaOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        return jdbcTemplate.update(
                env.getProperty("baja_ode"),
                new Object[]{idOrganoDireccionEstrategica}
        ) > 0;
    }

    @Override
    public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        try {
            return jdbcTemplate.queryForObject(
                    env.getProperty("buscar_ode_por_id"),
                    new Object[]{idOrganoDireccionEstrategica},
                    RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA
            );
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(String nombre) {
        try {
            return jdbcTemplate.queryForObject(
                    env.getProperty("buscar_ode_por_nombre"),
                    new Object[]{nombre},
                    RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA
            );
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategica() {
        return jdbcTemplate.query(
                env.getProperty("obtener_ode"),
                RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA
        );
    }

    @Override
    public boolean actualizarOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
        return jdbcTemplate.update(
                env.getProperty("actualizar_ode"),
                new Object[]{ode.getIdProgramaInstitucional(), ode.getNombre(), ode.getDescripcion(),
                        ode.getIdOrganoDireccionEstrategica()}
        ) > 0;
    }

    @Override
    public long contarOrganosDireccionEstrategica() {
        return jdbcTemplate.queryForObject(
                env.getProperty("contar_odes")
                , Long.class
        );
    }

}
