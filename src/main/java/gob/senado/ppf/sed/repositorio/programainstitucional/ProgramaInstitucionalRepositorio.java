
package gob.senado.ppf.sed.repositorio.programainstitucional;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;

import java.util.List;

public interface ProgramaInstitucionalRepositorio {

    boolean altaProgramaInstitucional(ProgramaInstitucional programaInstitucional);

    ProgramaInstitucional buscarProgramaInstitucional(long idProgramaInstitucional);

    ProgramaInstitucional buscarProgramaInstitucional(String claveProgramaInstitucional);

    List<ProgramaInstitucional> obtenerProgramasInstitucionales();

    List<OrganoDireccionEstrategica> obtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional(long idProgramaInstitucional);

    List<UnidadApoyo> obtenerUnidadesApoyoPorIdProgramaInstitucional(long idProgramaInstitucional);

    boolean actualizarProgramaInstitucional(ProgramaInstitucional programaInstitucional);

    boolean bajaProgramaInstitucional(long idProgramaInstitucional);

    long contarProgramasInstitucionales();

}


