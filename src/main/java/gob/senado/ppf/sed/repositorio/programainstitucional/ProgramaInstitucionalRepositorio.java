package gob.senado.ppf.sed.repositorio.programainstitucional;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

public interface ProgramaInstitucionalRepositorio {
	
	boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);
	
	ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);
	
	ProgramaInstitucional buscarProgramaInstitucional(String claveProgramaInstitucional);
	
	boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);
	
	boolean bajaProgramaInstitucional(long idProgramaInstitucional);
	
	long contarProgramasInstitucionales();
	
}
