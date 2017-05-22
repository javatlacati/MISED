package gob.senado.ppf.sed.repositorio.organodireccionestrategica;

import gob.senado.ppf.sed.configuracion.ConfiguracionParaDataSource;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaExtras;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.repositorio.organodireccionestrategica.impl.OrganoDireccionEstrategicaRepositorioImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfiguracionParaExtras.class, ConfiguracionParaDataSource.class,
        OrganoDireccionEstrategicaRepositorioImpl.class}, loader = AnnotationConfigContextLoader.class)
public class TestOrganoDireccionEstrategicaRepositorio {

    @Autowired
    private OrganoDireccionEstrategicaRepositorio organoDireccionEstrategicaRepositorio;

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testBuscarOrganoDireccionEstrategicaPorIdOganoDireccionEstrategica() {
        OrganoDireccionEstrategica odeEncontrado = organoDireccionEstrategicaRepositorio.buscarOrganoDireccionEstrategica(1);
        assertEquals(1, odeEncontrado.getIdOrganoDireccionEstrategica());
        assertEquals("Mesa Directiva", odeEncontrado.getNombre());
        assertEquals(1, odeEncontrado.getIdProgramaInstitucional());
        assertEquals("", odeEncontrado.getDescripcion());
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testBuscarOrganoDireccionEstrategicaPorNombre() {
        OrganoDireccionEstrategica odeEncontrado = organoDireccionEstrategicaRepositorio.buscarOrganoDireccionEstrategica("Mesa Directiva");
        assertEquals(1, odeEncontrado.getIdOrganoDireccionEstrategica());
        assertEquals("Mesa Directiva", odeEncontrado.getNombre());
        assertEquals(1, odeEncontrado.getIdProgramaInstitucional());
        assertEquals("", odeEncontrado.getDescripcion());
    }

    @Test
    @Transactional
    @Rollback(true)
    @Ignore
    public void testActualizarOrganoDireccionEstrategica() {
        OrganoDireccionEstrategica odeEsperado = new OrganoDireccionEstrategica();
        odeEsperado.setIdOrganoDireccionEstrategica(1);
        odeEsperado.setIdProgramaInstitucional(3);
        odeEsperado.setNombre("Organo De Direccion Estrategica Actualizado");
        odeEsperado.setDescripcion("Actualizaci�n de la descripci�n");
        assertTrue(organoDireccionEstrategicaRepositorio.actualizarOrganoDireccionEstrategica(odeEsperado));
        OrganoDireccionEstrategica odeEncontrado = organoDireccionEstrategicaRepositorio.buscarOrganoDireccionEstrategica(1);
        assertEquals(1, odeEncontrado.getIdOrganoDireccionEstrategica());
        assertEquals("Organo De Direccion Estrategica Actualizado", odeEncontrado.getNombre());
        assertEquals(3, odeEncontrado.getIdProgramaInstitucional());
        assertEquals("Actualizaci�n de la descripci�n", odeEncontrado.getDescripcion());
    }

    @Test
    @Transactional
    @Rollback(true)
    @Ignore
    public void testAltaOrganoDireccionEstrategica() {
        OrganoDireccionEstrategica odeNuevo = new OrganoDireccionEstrategica();
        odeNuevo.setIdProgramaInstitucional(3);
        odeNuevo.setNombre("Nuevo �rgano de Direcci�n Estrat�gica");
        odeNuevo.setDescripcion("Nueva Descripci�n");
        assertTrue(organoDireccionEstrategicaRepositorio.altaOrganoDireccionEstrategica(odeNuevo));

    }

    @Test
    @Transactional
    @Rollback(true)
    @Ignore
    public void testBajaOrganoDireccionEstrategica() {
        assertTrue(organoDireccionEstrategicaRepositorio.bajaOrganoDireccionEstrategica(2));
        assertEquals(2, organoDireccionEstrategicaRepositorio.contarOrganosDireccionEstrategica());
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testContarOrganosDireccionEstrategica() {
        assertEquals(3, organoDireccionEstrategicaRepositorio.contarOrganosDireccionEstrategica());
    }

    @Test
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    @Ignore
    public void testObtenerOrganosDireccionEstrategica() {
        assertEquals(3, organoDireccionEstrategicaRepositorio.obtenerOrganosDireccionEstrategica().size());
    }


}
