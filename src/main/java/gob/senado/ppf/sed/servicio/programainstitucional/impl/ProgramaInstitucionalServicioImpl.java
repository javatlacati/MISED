package gob.senado.ppf.sed.servicio.programainstitucional.impl;

import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.repositorio.programainstitucional.ProgramaInstitucionalRepositorio;
import gob.senado.ppf.sed.servicio.programainstitucional.ProgramaInstitucionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service(value = "programaInstitucionalServicio")
public class ProgramaInstitucionalServicioImpl implements ProgramaInstitucionalServicio {
    
    private final ProgramaInstitucionalRepositorio programaInstitucionalRepositorio;
    
    @Autowired
    public ProgramaInstitucionalServicioImpl(ProgramaInstitucionalRepositorio programaInstitucionalRepositorio) {
        this.programaInstitucionalRepositorio = programaInstitucionalRepositorio;
    }
    
    @Override
    @Transactional
    public boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional) {
        return programaInstitucionalRepositorio.buscarProgramaInstitucional(programaInstitucional.getClave()) == null
                && programaInstitucionalRepositorio.altaProgramaInstitucional(programaInstitucional);
    }
    
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional) {
        return programaInstitucionalRepositorio
                .buscarProgramaInstitucional(idProgramaInstitucional);
    }
    
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public List<ProgramaInstitucional> obtenerProgramasInstitucionales() {
        return programaInstitucionalRepositorio.obtenerProgramasInstitucionales();
    }
    
    @Override
    @Transactional
    public boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional) {
        final ProgramaInstitucional programaInstitucionalActual = programaInstitucionalRepositorio
                .buscarProgramaInstitucional(programaInstitucional.getIdProgramaInstitucional());
        final ProgramaInstitucional programaInstitucionalCoincidente = programaInstitucionalRepositorio
                .buscarProgramaInstitucional(programaInstitucional.getClave());
        if (programaInstitucionalActual != null) {
            if (programaInstitucionalCoincidente != null && programaInstitucionalCoincidente
                    .getIdProgramaInstitucional() == programaInstitucionalActual.getIdProgramaInstitucional()) {
                return programaInstitucionalRepositorio.actualizarProgramaInstitucional(programaInstitucional);
            } else if (programaInstitucionalCoincidente == null) {
                return programaInstitucionalRepositorio.actualizarProgramaInstitucional(programaInstitucional);
            } else {
                return false;
            }
        } else {
            return false;
        }
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
