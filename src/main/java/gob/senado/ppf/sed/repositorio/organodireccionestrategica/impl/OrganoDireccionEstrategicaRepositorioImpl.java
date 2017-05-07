package gob.senado.ppf.sed.repositorio.organodireccionestrategica.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.repositorio.organodireccionestrategica.OrganoDireccionEstrategicaRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;

@Repository(value = "organoDireccionEstrategicaRepositorio")
public class OrganoDireccionEstrategicaRepositorioImpl implements OrganoDireccionEstrategicaRepositorio {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public OrganoDireccionEstrategicaRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public boolean altaOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
        return jdbcTemplate.update(
                "INSERT INTO ORGANO_DIRECCION_ESTRATEGICA(ID_PROGRAMA_INSTITUCIONAL, NOMBRE, DESCRIPCION) VALUES (?, ?, ?)",
                new Object[] { ode.getIdProgramaInstitucional(), ode.getNombre(), ode.getDescripcion() }) > 0;
    }
    
    @Override
    public boolean bajaOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        return jdbcTemplate.update("DELETE FROM ORGANO_DIRECCION_ESTRATEGICA WHERE ID_ORGANO_DIRECCION_ESTRATEGICA = ?",
                new Object[] { idOrganoDireccionEstrategica }) > 0;
    }
    
    @Override
    public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ODE.*, (SELECT COUNT(UA.ID_UNIDAD_APOYO) FROM UNIDAD_APOYO UA ")
                .append("WHERE UA.ID_ORGANO_DIRECCION_ESTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA) ")
                .append("AS NUMERO_UNIDADES_APOYO_ADSCRITAS FROM ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("WHERE ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = ?");
        return jdbcTemplate.queryForObject(sql.toString(), new Object[] { idOrganoDireccionEstrategica },
                RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA);
    }
    
    @Override
    public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(String nombre) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ODE.*, (SELECT COUNT(UA.ID_UNIDAD_APOYO) FROM UNIDAD_APOYO UA ")
                .append("WHERE UA.ID_ORGANO_DIRECCION_ESTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA) ")
                .append("AS NUMERO_UNIDADES_APOYO_ADSCRITAS FROM ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("WHERE ODE.NOMBRE = ?");
        return jdbcTemplate.queryForObject(sql.toString(), new Object[] { nombre },
                RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA);
    }
    
    @Override
    public List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategica() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ODE.*, (SELECT COUNT(UA.ID_UNIDAD_APOYO) FROM UNIDAD_APOYO UA ")
                .append("WHERE UA.ID_ORGANO_DIRECCION_ESTRATEGICA = ODE.ID_ORGANO_DIRECCION_ESTRATEGICA) ")
                .append("AS NUMERO_UNIDADES_APOYO_ADSCRITAS FROM ORGANO_DIRECCION_ESTRATEGICA ODE ");
        return jdbcTemplate.query(sql.toString(), RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA);
    }
    
    @Override
    public boolean actualizarOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
        return jdbcTemplate.update(
                "UPDATE ORGANO_DIRECCION_ESTRATEGICA SET ID_PROGRAMA_INSTITUCIONAL = ?, NOMBRE = ?, DESCRIPCION = ? WHERE ID_ORGANO_DIRECCION_ESTRATEGICA = ?",
                new Object[] { ode.getIdProgramaInstitucional(), ode.getNombre(), ode.getDescripcion(),
                    ode.getIdOrganoDireccionEstrategica() }) > 0;
    }
    
    @Override
    public long contarOrganosDireccionEstrategica() {
        return jdbcTemplate.queryForObject(
                "SELECT total_conteo FROM CONTAR_ORGANOS_DIRECCION_ESTRATEGICA", Long.class);
    }
    
}
