package gob.senado.ppf.sed.controlador.programainstitucional;

import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

public interface ProgramaInstitucionalControlador {

	public abstract ModelAndView vistaAdministracionProgramasInstitucionales();

	public abstract HttpEntity<List<ProgramaInstitucional>> obtenerProgramasInstitucionales();
	
	public abstract ResponseEntity<Void> registroProgramaInstitucional(ProgramaInstitucional programaInstitucional);
	
	public abstract ResponseEntity<ProgramaInstitucional> bajaProgramaInstitucional(String idProgramaInstitucional);
}
