package gob.senado.ppf.sed.repositorio.programainstitucional;

import java.util.List;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

public interface ProgramaInstitucionalRepositorio {
	
	public abstract boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);
	
	public abstract ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);
	
	public abstract ProgramaInstitucional buscarProgramaInstitucional(String claveProgramaInstitucional);
	
	public abstract List<ProgramaInstitucional> obtenerProgramasInstitucionales();
	
	public abstract boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);
	
	public abstract boolean bajaProgramaInstitucional(long idProgramaInstitucional);
	
	public abstract long contarProgramasInstitucionales();
	
}
