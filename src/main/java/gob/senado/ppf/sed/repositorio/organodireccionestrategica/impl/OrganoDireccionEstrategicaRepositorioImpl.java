package gob.senado.ppf.sed.repositorio.organodireccionestrategica.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.repositorio.organodireccionestrategica.OrganoDireccionEstrategicaRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;

@Repository(value = "organoDireccionEstrategicaRepositorio")
public class OrganoDireccionEstrategicaRepositorioImpl implements OrganoDireccionEstrategicaRepositorio {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean altaOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
		return jdbcTemplate.update(
				"INSERT INTO ORGANO_DIRECCION_ESTRATEGICA(id_programa_institucional, nombre, descripcion) VALUES (?, ?, ?)",
				new Object[] { ode.getIdProgramaInstitucional(), ode.getNombre(), ode.getDescripcion() }) > 0;
	}

	@Override
	public boolean bajaOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		return jdbcTemplate.update("DELETE FROM ORGANO_DIRECCION_ESTRATEGICA WHERE id_organo_direccion_estrategica = ?",
				new Object[] { idOrganoDireccionEstrategica }) > 0;
	}

	@Override
	public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM ORGANO_DIRECCION_ESTRATEGICA WHERE id_organo_direccion_estrategica = ?",
				new Object[] { idOrganoDireccionEstrategica }, RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA);
	}

	@Override
	public OrganoDireccionEstrategica buscarOrganoDireccionEstrategica(String nombre) {
		return jdbcTemplate.queryForObject("SELECT * FROM ORGANO_DIRECCION_ESTRATEGICA WHERE nombre = ?",
				new Object[] { nombre }, RowMappers.ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA);
	}

	@Override
	public boolean actualizarOrganoDireccionEstrategica(OrganoDireccionEstrategica ode) {
		return jdbcTemplate.update(
				"UPDATE ORGANO_DIRECCION_ESTRATEGICA SET id_programa_institucional=?, nombre=?, descripcion WHERE id_organo_direccion_estrategica = ?",
				new Object[] { ode.getIdProgramaInstitucional(), ode.getNombre(), ode.getDescripcion(),
						ode.getIdOrganoDireccionEstrategica() }) > 0;
	}

	@Override
	public long contarOrganosDireccionEstrategica() {
		return jdbcTemplate.queryForObject(
				"SELECT total_conteo FROM CONTAR_ORGANOS_DIRECCION_ESTRATEGICA", Long.class);
	}

}
