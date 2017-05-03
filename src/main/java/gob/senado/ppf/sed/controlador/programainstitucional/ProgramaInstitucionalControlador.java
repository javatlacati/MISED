package gob.senado.ppf.sed.controlador.programainstitucional;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public interface ProgramaInstitucionalControlador {

	ModelAndView vistaAdministracionProgramasInstitucionales();

	HttpEntity<List<ProgramaInstitucional>> obtenerProgramasInstitucionales();
	
	ResponseEntity<ProgramaInstitucional> registroProgramaInstitucional(ProgramaInstitucional programaInstitucional);
	
	ResponseEntity<ProgramaInstitucional> bajaProgramaInstitucional(String idProgramaInstitucional);
	
	HttpEntity<ProgramaInstitucional> buscarProgramaInstitucional(String idProgramaInstitucional);
	
	ResponseEntity<ProgramaInstitucional> actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional, BindingResult result);

}
