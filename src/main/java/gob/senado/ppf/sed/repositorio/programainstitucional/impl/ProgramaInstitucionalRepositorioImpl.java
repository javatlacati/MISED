package gob.senado.ppf.sed.repositorio.programainstitucional.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.repositorio.programainstitucional.ProgramaInstitucionalRepositorio;
import gob.senado.ppf.sed.utilidades.RowMappers;

@Repository(value = "programaInstitucionalRepositorio")
public class ProgramaInstitucionalRepositorioImpl implements ProgramaInstitucionalRepositorio {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
