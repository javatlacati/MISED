package gob.senado.ppf.sed.controlador.programainstitucional.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import gob.senado.ppf.sed.controlador.programainstitucional.ProgramaInstitucionalControlador;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.servicio.programainstitucional.ProgramaInstitucionalServicio;

@Controller(value = "programaInstitucionalControlador")
@RequestMapping(value = "/administrador")
public class ProgramaInstitucionalControladorImpl implements ProgramaInstitucionalControlador {

	@Autowired
	private ProgramaInstitucionalServicio programaInstitucionalServicio;

	@Override
	@GetMapping(value = "/programa-institucional/administracion-programas-institucionales.htm")
	public ModelAndView vistaAdministracionProgramasInstitucionales() {
		return new ModelAndView("administrador/programas-institucionales/gestion-programa-institucional");
	}

	@Override
	@PostMapping(value = "/programa-institucional/programas-institucionales.do")
	public HttpEntity<List<ProgramaInstitucional>> obtenerProgramasInstitucionales() {
		return new ResponseEntity<List<ProgramaInstitucional>>(programaInstitucionalServicio.obtenerProgramasInstitucionales(), HttpStatus.OK);
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json; charset=ISO-8859-1");
//		response.setHeader("Cache-Control", "no-store");
//		return new Gson().toJson(programaInstitucionalServicio.obtenerProgramasInstitucionales());

	}

}
