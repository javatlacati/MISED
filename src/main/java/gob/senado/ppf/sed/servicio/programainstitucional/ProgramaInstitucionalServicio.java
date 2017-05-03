package gob.senado.ppf.sed.servicio.programainstitucional;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

import java.util.List;

public interface ProgramaInstitucionalServicio {

	boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);

	List<ProgramaInstitucional> obtenerProgramasInstitucionales();

	boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	boolean bajaProgramaInstitucional(long idProgramaInstitucional);

	long contarProgramasInstitucionales();
}
