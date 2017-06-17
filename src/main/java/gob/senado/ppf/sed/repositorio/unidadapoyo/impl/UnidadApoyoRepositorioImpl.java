package gob.senado.ppf.sed.repositorio.unidadapoyo.impl;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.unidadapoyo.UnidadApoyoRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "unidadApoyoRepositorio")
public class UnidadApoyoRepositorioImpl implements UnidadApoyoRepositorio {

    private final JdbcTemplate jdbcTemplate;

    private Environment env;

    @Autowired
    public UnidadApoyoRepositorioImpl(JdbcTemplate jdbcTemplate, Environment env) {
        this.jdbcTemplate = jdbcTemplate;
        this.env = env;
    }

    @Override
    public boolean altaUnidadApoyo(UnidadApoyo ua) {
        return jdbcTemplate.update(
                env.getProperty("alta_ua"),
                ua.getIdOrganoDireccionEstrategica(), ua.getNombre(), ua.getProposito()
        ) > 0;
    }

    @Override
    public boolean bajaUnidadApoyo(long idUnidadApoyo) {
        return jdbcTemplate.update(
                env.getProperty("baja_ua")
                , idUnidadApoyo
        ) > 0;
    }

    @Override
    public UnidadApoyo buscarUnidadApoyo(long idUnidadApoyo) {
        try {
            return jdbcTemplate.queryForObject(
                    env.getProperty("busca_ua_por_id"),
                    new Object[]{idUnidadApoyo},
                    RowMappers.ROW_MAPPER_UNIDAD_APOYO
            );
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public UnidadApoyo buscarUnidadApoyo(String nombreUnidadApoyo) {
        try {
            return jdbcTemplate.queryForObject(
                    env.getProperty("busca_ua_por_nombre"),
                    new Object[]{nombreUnidadApoyo},
                    RowMappers.ROW_MAPPER_UNIDAD_APOYO
            );
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public List<UnidadApoyo> obtenerUnidadesApoyo() {
        return jdbcTemplate.query(env.getProperty("obtener_ua"), RowMappers.ROW_MAPPER_UNIDAD_APOYO);
    }

    @Override
    public boolean actualizarUnidadApoyo(UnidadApoyo ua) {
        return jdbcTemplate.update(
                env.getProperty("actualizar_ua"),
                new Object[]{ua.getIdOrganoDireccionEstrategica(), ua.getNombre(), ua.getProposito(),
                        ua.getIdUnidadApoyo()}
        ) > 0;
    }

    @Override
    public long contarUnidadesApoyo() {
        return jdbcTemplate.queryForObject(
                env.getProperty("contar_ua"),
                Long.class
        );
    }

}