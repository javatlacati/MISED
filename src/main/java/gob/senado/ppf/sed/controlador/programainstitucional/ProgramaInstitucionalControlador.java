package gob.senado.ppf.sed.controlador.programainstitucional;

import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.servlet.ModelAndView;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;

public interface ProgramaInstitucionalControlador {

	public abstract ModelAndView vistaAdministracionProgramasInstitucionales();

	public abstract HttpEntity<List<ProgramaInstitucional>>  obtenerProgramasInstitucionales();
}
