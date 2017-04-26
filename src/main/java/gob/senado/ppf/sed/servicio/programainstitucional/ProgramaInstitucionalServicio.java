package gob.senado.ppf.sed.servicio.programainstitucional;

import java.util.List;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import io.reactivex.Observable;

public interface ProgramaInstitucionalServicio {

	public abstract boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	public abstract ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);
	
	public abstract List<ProgramaInstitucional> obtenerProgramasInstitucionales();

	public abstract boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	public abstract boolean bajaProgramaInstitucional(long idProgramaInstitucional);

	public abstract long contarProgramasInstitucionales();
}
