package gob.senado.ppf.sed.controlador.programainstitucional;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public interface ProgramaInstitucionalControlador {

	public abstract ModelAndView vistaAdministracionProgramasInstitucionales();

	public abstract HttpEntity<List<ProgramaInstitucional>> obtenerProgramasInstitucionales();
	
	public abstract ResponseEntity<ProgramaInstitucional> registroProgramaInstitucional(ProgramaInstitucional programaInstitucional);
	
	public abstract ResponseEntity<ProgramaInstitucional> bajaProgramaInstitucional(String idProgramaInstitucional);
	
	public abstract HttpEntity<ProgramaInstitucional> buscarProgramaInstitucional(String idProgramaInstitucional);
	
	public abstract ResponseEntity<ProgramaInstitucional> actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional, BindingResult result);

}
