package gob.senado.ppf.sed.repositorio.unidadapoyo.impl;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.unidadapoyo.UnidadApoyoRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "unidadApoyoRepositorio")
public class UnidadApoyoRepositorioImpl implements UnidadApoyoRepositorio {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UnidadApoyoRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean altaUnidadApoyo(UnidadApoyo ua) {
        return jdbcTemplate.update(
                "INSERT INTO UNIDAD_APOYO(id_organo_direccion_estrategica, nombre, proposito) VALUES (?, ?, ?)",
                ua.getIdOrganoDireccionEstrategica(), ua.getNombre(), ua.getProposito()) > 0;
    }

    @Override
    public boolean bajaUnidadApoyo(long idUnidadApoyo) {
        return jdbcTemplate.update("DELETE FROM UNIDAD_APOYO WHERE id_unidad_apoyo = ?", idUnidadApoyo) > 0;
    }

    @Override
    public UnidadApoyo buscarUnidadApoyo(long idUnidadApoyo) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PI.ID_PROGRAMA_INSTITUCIONAL, PI.CLAVE, PI.NOMBRE, PI.DESCRIPCION, ")
                    .append("ODE.ID_ORGANO_DIRECCION_ESTRATEGICA, ODE.NOMBRE, ODE.DESCRIPCION, ")
                    .append("UA.ID_UNIDAD_APOYO, UA.NOMBRE, UA.PROPOSITO, (SELECT COUNT(*) FROM USUARIO U ")
                    .append("WHERE UA.ID_UNIDAD_APOYO = U.ID_UNIDAD_APOYO) AS TOTAL_USUARIOS_ADSCRITOS_UNIDAD_APOYO ")
                    .append("FROM PROGRAMA_INSTITUCIONAL PI INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                    .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL INNER JOIN UNIDAD_APOYO UA ")
                    .append("ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                    .append("WHERE UA.ID_UNIDAD_APOYO = ?");
            return jdbcTemplate.queryForObject(sql.toString(),
                    new Object[]{idUnidadApoyo}, RowMappers.ROW_MAPPER_UNIDAD_APOYO);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public UnidadApoyo buscarUnidadApoyo(String nombreUnidadApoyo) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PI.ID_PROGRAMA_INSTITUCIONAL, PI.CLAVE, PI.NOMBRE, PI.DESCRIPCION, ")
                    .append("ODE.ID_ORGANO_DIRECCION_ESTRATEGICA, ODE.NOMBRE, ODE.DESCRIPCION, ")
                    .append("UA.ID_UNIDAD_APOYO, UA.NOMBRE, UA.PROPOSITO, (SELECT COUNT(*) FROM USUARIO U ")
                    .append("WHERE UA.ID_UNIDAD_APOYO = U.ID_UNIDAD_APOYO) AS TOTAL_USUARIOS_ADSCRITOS_UNIDAD_APOYO ")
                    .append("FROM PROGRAMA_INSTITUCIONAL PI INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                    .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL INNER JOIN UNIDAD_APOYO UA ")
                    .append("ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                    .append("WHERE UA.NOMBRE = ?");
            return jdbcTemplate.queryForObject(sql.toString(),
                    new Object[]{nombreUnidadApoyo}, RowMappers.ROW_MAPPER_UNIDAD_APOYO);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public List<UnidadApoyo> obtenerUnidadesApoyo() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT PI.ID_PROGRAMA_INSTITUCIONAL, PI.CLAVE, PI.NOMBRE, PI.DESCRIPCION, ")
                .append("ODE.ID_ORGANO_DIRECCION_ESTRATEGICA, ODE.NOMBRE, ODE.DESCRIPCION, ")
                .append("UA.ID_UNIDAD_APOYO, UA.NOMBRE, UA.PROPOSITO, (SELECT COUNT(*) FROM USUARIO U ")
                .append("WHERE UA.ID_UNIDAD_APOYO = U.ID_UNIDAD_APOYO) AS TOTAL_USUARIOS_ADSCRITOS_UNIDAD_APOYO ")
                .append("FROM PROGRAMA_INSTITUCIONAL PI INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL INNER JOIN UNIDAD_APOYO UA ")
                .append("ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ORDER BY UA.NOMBRE");
        return jdbcTemplate.query(sql.toString(), RowMappers.ROW_MAPPER_UNIDAD_APOYO);
    }

    @Override
    public boolean actualizarUnidadApoyo(UnidadApoyo ua) {
        return jdbcTemplate.update(
                "UPDATE unidad_apoyo SET id_organo_direccion_estrategica = ?, nombre = ?, proposito = ? WHERE id_unidad_apoyo = ?",
                new Object[]{ua.getIdOrganoDireccionEstrategica(), ua.getNombre(), ua.getProposito(),
                        ua.getIdUnidadApoyo()}) > 0;
    }

    @Override
    public long contarUnidadesApoyo() {
        return jdbcTemplate.queryForObject("SELECT TOTAL_CONTEO FROM CONTAR_UNIDADES_APOYO", Long.class);
    }

}