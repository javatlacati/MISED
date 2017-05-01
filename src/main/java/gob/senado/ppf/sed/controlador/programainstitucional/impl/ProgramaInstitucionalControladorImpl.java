package gob.senado.ppf.sed.controlador.programainstitucional.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import gob.senado.ppf.sed.controlador.programainstitucional.ProgramaInstitucionalControlador;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.servicio.programainstitucional.ProgramaInstitucionalServicio;
import gob.senado.ppf.sed.utilidades.Suppliers;

@Controller(value = "programaInstitucionalControlador")
@RequestMapping(value = "/administrador")
public class ProgramaInstitucionalControladorImpl implements ProgramaInstitucionalControlador {

	@Autowired
	private ProgramaInstitucionalServicio programaInstitucionalServicio;

	@Override
	@GetMapping(value = "/programa-institucional/administracion-programas-institucionales.htm")
	public ModelAndView vistaAdministracionProgramasInstitucionales() {
		return new ModelAndView("administrador/programas-institucionales/administracion-programa-institucional",
				"programaInstitucional", Suppliers.PROGRAMA_INSTITUCIONAL.get());
	}

	@Override
	@PostMapping(value = "/programa-institucional/programas-institucionales.json")
	public HttpEntity<List<ProgramaInstitucional>> obtenerProgramasInstitucionales() {
		List<ProgramaInstitucional> programasInstitucionales = programaInstitucionalServicio
				.obtenerProgramasInstitucionales();
		if (programasInstitucionales.size() > 0) {
			return new ResponseEntity<List<ProgramaInstitucional>>(programasInstitucionales, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ProgramaInstitucional>>(programasInstitucionales, HttpStatus.NO_CONTENT);
		}
	}

	@Override
	@PostMapping(value = "/programa-institucional/registro-programa-institucional")
	public ResponseEntity<ProgramaInstitucional> registroProgramaInstitucional(
			@ModelAttribute(binding = true, name = "programaInstitucional") ProgramaInstitucional programaInstitucional) {
		if (programaInstitucionalServicio.altaProgramaInstitucional(programaInstitucional)) {
			return new ResponseEntity<ProgramaInstitucional>(programaInstitucional, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<ProgramaInstitucional>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@Override
	@PostMapping(value = "/programa-institucional/baja-programa-institucional/{idProgramaInstitucional}")
	public ResponseEntity<ProgramaInstitucional> bajaProgramaInstitucional(
			@PathVariable(required = true, name = "idProgramaInstitucional") String idProgramaInstitucional) {
		try {
			long identificadorProgramaInstitucional = Long.parseLong(idProgramaInstitucional);
			final ProgramaInstitucional programaInstitucional = programaInstitucionalServicio
					.buscarProgramaInstitucional(Long.parseLong(idProgramaInstitucional));
			if (programaInstitucional != null) {
				if (programaInstitucionalServicio.bajaProgramaInstitucional(identificadorProgramaInstitucional)) {
					return new ResponseEntity<ProgramaInstitucional>(programaInstitucional, HttpStatus.OK);
				} else {
					return new ResponseEntity<ProgramaInstitucional>(HttpStatus.SERVICE_UNAVAILABLE);
				}
			} else {
				return new ResponseEntity<ProgramaInstitucional>(HttpStatus.NOT_FOUND);
			}
		} catch (NumberFormatException nfe) {
			return new ResponseEntity<ProgramaInstitucional>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	@PostMapping(value = "/programa-institucional/buscar-programa-institucional/{idProgramaInstitucional}")
	public HttpEntity<ProgramaInstitucional> buscarProgramaInstitucional(
			@PathVariable(required = true, name = "idProgramaInstitucional") String idProgramaInstitucional) {
		try {
			long identificadorProgramaInstitucional = Long.parseLong(idProgramaInstitucional);
			final ProgramaInstitucional programaInstitucional = programaInstitucionalServicio
					.buscarProgramaInstitucional(identificadorProgramaInstitucional);
			if (programaInstitucional != null) {
				return new ResponseEntity<ProgramaInstitucional>(programaInstitucional, HttpStatus.OK);
			} else {
				return new ResponseEntity<ProgramaInstitucional>(HttpStatus.NOT_FOUND);
			}
		} catch (NumberFormatException nfe) {
			return new ResponseEntity<ProgramaInstitucional>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	@PostMapping(value = "/programa-institucional/actualizar-programa-institucional")
	public ResponseEntity<ProgramaInstitucional> actualizarProgramaInstitucional(
			@ModelAttribute(binding = true, name = "programaInstitucional") ProgramaInstitucional programaInstitucional, BindingResult result) {
		final ProgramaInstitucional programaInstitucionalRegistrado = programaInstitucionalServicio
				.buscarProgramaInstitucional(programaInstitucional.getIdProgramaInstitucional());
		if (programaInstitucionalRegistrado != null) {
			if (programaInstitucionalServicio.actualizarProgramaInstitucional(programaInstitucional)) {
				return new ResponseEntity<ProgramaInstitucional>(programaInstitucional, HttpStatus.OK);
			} else {
				return new ResponseEntity<ProgramaInstitucional>(HttpStatus.SERVICE_UNAVAILABLE);
			}
		} else {
			return new ResponseEntity<ProgramaInstitucional>(HttpStatus.NOT_FOUND);
		}
	}

}
