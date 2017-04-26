package gob.senado.ppf.sed.servicio.programainstitucional.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.repositorio.programainstitucional.ProgramaInstitucionalRepositorio;
import gob.senado.ppf.sed.servicio.programainstitucional.ProgramaInstitucionalServicio;

@Service(value = "programaInstitucionalServicio")
public class ProgramaInstitucionalServicioImpl implements ProgramaInstitucionalServicio {
	
	@Autowired
	private ProgramaInstitucionalRepositorio programaInstitucionalRepositorio;

	@Override
	@Transactional
	public boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional) {
		if(programaInstitucionalRepositorio.buscarProgramaInstitucional(programaInstitucional.getClave()) == null){
			return programaInstitucionalRepositorio.altaProgramaInstitucional(programaInstitucional);
		}else{
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional) {
		return programaInstitucionalRepositorio.buscarProgramaInstitucional(idProgramaInstitucional);
	}
	
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<ProgramaInstitucional> obtenerProgramasInstitucionales() {
		return programaInstitucionalRepositorio.obtenerProgramasInstitucionales();
	}

	@Override
	@Transactional
	public boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional) {
		return programaInstitucionalRepositorio.actualizarProgramaInstitucional(programaInstitucional);
	}

	@Override
	@Transactional
	public boolean bajaProgramaInstitucional(long idProgramaInstitucional) {
		return programaInstitucionalRepositorio.bajaProgramaInstitucional(idProgramaInstitucional);
	}

	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public long contarProgramasInstitucionales() {
		return programaInstitucionalRepositorio.contarProgramasInstitucionales();
	}


}
