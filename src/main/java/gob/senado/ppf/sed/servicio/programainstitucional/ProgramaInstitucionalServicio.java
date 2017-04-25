package gob.senado.ppf.sed.servicio.programainstitucional;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

public interface ProgramaInstitucionalServicio {

	public abstract boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	public abstract ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);

	public abstract boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	public abstract boolean bajaProgramaInstitucional(long idProgramaInstitucional);

	public abstract long contarProgramasInstitucionales();
}
