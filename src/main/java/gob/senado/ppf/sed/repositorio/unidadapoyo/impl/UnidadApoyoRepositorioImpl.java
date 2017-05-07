package gob.senado.ppf.sed.repositorio.unidadapoyo.impl;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.unidadapoyo.UnidadApoyoRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
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
        return jdbcTemplate.update("DELETE FROM UNIDAD_APOYO WHERE id_unidad_apoyo = ?",
                idUnidadApoyo) > 0;
    }
    
    @Override
    public UnidadApoyo buscarUnidadApoyo(long idUnidadApoyo) {
        return jdbcTemplate.queryForObject("SELECT * FROM UNIDAD_APOYO WHERE id_unidad_apoyo = ?",
                new Object[] { idUnidadApoyo }, RowMappers.ROW_MAPPER_UNIDAD_APOYO);
    }
    
    @Override
    public UnidadApoyo buscarUnidadApoyo(String nombreUnidadApoyo) {
        return jdbcTemplate.queryForObject("SELECT * FROM UNIDAD_APOYO WHERE nombre = ?",
                new Object[] { nombreUnidadApoyo }, RowMappers.ROW_MAPPER_UNIDAD_APOYO);
    }
    
    @Override
    public List<UnidadApoyo> obtenerUnidadesApoyo() {
        return jdbcTemplate.query("SELECT * FROM UNIDAD_APOYO", RowMappers.ROW_MAPPER_UNIDAD_APOYO);
    }
    
    @Override
    public boolean actualizarUnidadApoyo(UnidadApoyo ua) {
        return jdbcTemplate.update(
                "UPDATE unidad_apoyo SET id_organo_direccion_estrategica = ?, nombre = ?, proposito = ? WHERE id_unidad_apoyo = ?",
                new Object[] { ua.getIdOrganoDireccionEstrategica(), ua.getNombre(), ua.getProposito(), ua.getIdUnidadApoyo() }) > 0;
    }
    
    @Override
    public long contarUnidadesApoyo() {
        return jdbcTemplate.queryForObject("SELECT TOTAL_CONTEO FROM CONTAR_UNIDADES_APOYO", Long.class);
    }
    
}
