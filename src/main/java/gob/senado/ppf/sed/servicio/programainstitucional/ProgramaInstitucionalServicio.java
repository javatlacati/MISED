package gob.senado.ppf.sed.servicio.programainstitucional;

import java.util.List;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import io.reactivex.Observable;

public interface ProgramaInstitucionalServicio {

	boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);
	
	public abstract List<ProgramaInstitucional> obtenerProgramasInstitucionales();

	boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);

	boolean bajaProgramaInstitucional(long idProgramaInstitucional);

	long contarProgramasInstitucionales();
}
