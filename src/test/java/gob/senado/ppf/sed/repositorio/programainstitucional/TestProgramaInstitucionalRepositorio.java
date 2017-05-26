package gob.senado.ppf.sed.repositorio.programainstitucional;

import gob.senado.ppf.sed.configuracion.ConfiguracionParaDataSource;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaExtras;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.programainstitucional.impl.ProgramaInstitucionalRepositorioImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfiguracionParaExtras.class, ConfiguracionParaDataSource.class,
        ProgramaInstitucionalRepositorioImpl.class}, loader = AnnotationConfigContextLoader.class)
public class TestProgramaInstitucionalRepositorio {

    @Autowired
    private ProgramaInstitucionalRepositorio programaInstitucionalRepositorio;

    @Test
    @Transactional
    @Rollback(true)
    @Ignore
    public void testAltaProgramaInstitucional() {
        ProgramaInstitucional piPrueba = new ProgramaInstitucional();
        piPrueba.setIdProgramaInstitucional(4);
        piPrueba.setClave("1.1.01.004.R001-MD004");
        piPrueba.setNombre("Servicio Extra");
        piPrueba.setDescripcion("Sin descripci\u00f3n");
        assertTrue(programaInstitucionalRepositorio.altaProgramaInstitucional(piPrueba));
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testBuscarProgramaInstitucionalPorIdProgramaInstitucional() {
        ProgramaInstitucional piEsperado = new ProgramaInstitucional();
        piEsperado.setIdProgramaInstitucional(1);
        piEsperado.setClave("1.1.01.004.R001-MD003");
        piEsperado.setNombre("Servicios de Apoyo T\u00e9cnico");
        piEsperado.setDescripcion("Sin descripci\u00f3n");
        ProgramaInstitucional pi = programaInstitucionalRepositorio.buscarProgramaInstitucional(1);
        assertEquals(piEsperado.getIdProgramaInstitucional(), pi.getIdProgramaInstitucional());
        assertEquals(piEsperado.getClave(), pi.getClave());
        assertEquals(piEsperado.getNombre(), pi.getNombre());
        assertEquals(piEsperado.getDescripcion(), pi.getDescripcion());
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testBuscarProgramaInstitucionalPorNombreProgramaInstitucional() {
        ProgramaInstitucional piEsperado = new ProgramaInstitucional();
        piEsperado.setIdProgramaInstitucional(1);
        piEsperado.setClave("1.1.01.004.R001-MD003");
        piEsperado.setNombre("Servicios de Apoyo T\u00e9cnico");
        piEsperado.setDescripcion("Sin descripci\u00f3n");
        piEsperado.setTotalOrganosDireccionEstrategicaAdscritos(1);
        piEsperado.setTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos(7);
        ProgramaInstitucional pi = programaInstitucionalRepositorio
                .buscarProgramaInstitucional("1.1.01.004.R001-MD003");
        assertEquals(piEsperado.getIdProgramaInstitucional(), pi.getIdProgramaInstitucional());
        assertEquals(piEsperado.getClave(), pi.getClave());
        assertEquals(piEsperado.getNombre(), pi.getNombre());
        assertEquals(piEsperado.getDescripcion(), pi.getDescripcion());
        assertEquals(piEsperado.getTotalOrganosDireccionEstrategicaAdscritos(),
                pi.getTotalOrganosDireccionEstrategicaAdscritos());
        assertEquals(piEsperado.getTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos(),
                pi.getTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos());
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testObtenerProgramasInstitucionales() {
        List<ProgramaInstitucional> listaProgramasInstitucionales = programaInstitucionalRepositorio
                .obtenerProgramasInstitucionales();
        assertEquals(3, listaProgramasInstitucionales.size());
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testObtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional() {
        List<OrganoDireccionEstrategica> listaOrganosDireccionEstrategica = programaInstitucionalRepositorio
                .obtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional(1);
        assertEquals(1, listaOrganosDireccionEstrategica.size());
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testObtenerUnidadesApoyoPorIdProgramaInstitucional() {
        List<UnidadApoyo> listaUnidadesApoyo = programaInstitucionalRepositorio
                .obtenerUnidadesApoyoPorIdProgramaInstitucional(3);
        assertEquals(14, listaUnidadesApoyo.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    @Ignore
    public void testActualizarProgramaInstitucional() {
        ProgramaInstitucional programaInstitucional = new ProgramaInstitucional();
        programaInstitucional.setIdProgramaInstitucional(3);
        programaInstitucional.setClave("1.1.01.004.R001-MD004");
        programaInstitucional.setNombre("Servicio Extra");
        programaInstitucional.setDescripcion("Sin descripción");
        assertTrue(programaInstitucionalRepositorio.actualizarProgramaInstitucional(programaInstitucional));
    }

    @Test
    @Transactional
    @Rollback(true)
    @Ignore
    public void testBajaProgramaInstitucional() {
        assertTrue(programaInstitucionalRepositorio.bajaProgramaInstitucional(2));
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testContarProgramasInstitucionales() {
        assertEquals(3, programaInstitucionalRepositorio.contarProgramasInstitucionales());
    }
}
