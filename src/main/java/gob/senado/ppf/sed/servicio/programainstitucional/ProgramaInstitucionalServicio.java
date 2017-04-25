package gob.senado.ppf.sed.servicio.programainstitucional;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

public interface ProgramaInstitucionalServicio {

	boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);

	boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	boolean bajaProgramaInstitucional(long idProgramaInstitucional);

	long contarProgramasInstitucionales();
}
