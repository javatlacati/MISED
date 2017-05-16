package gob.senado.ppf.sed.repositorio.programainstitucional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaDataSource;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaExtras;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaSeguridad;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaWeb;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Administrador on 15/05/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ConfiguracionParaExtras.class,
        ConfiguracionParaDataSource.class,
        ConfiguracionParaSeguridad.class,
        ConfiguracionParaWeb.class,
//        ConfiguracionParaWebSocket.class,
//        ConfiguracionParaWebSocketHandlers.class
})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@WebAppConfiguration
@DbUnitConfiguration(databaseConnection = "dataSource")
@DatabaseSetup(value = "classpath:datasetProgramaInsitucional2.xml", type = com.github.springtestdbunit.annotation.DatabaseOperation.CLEAN_INSERT)
public class ProgramaInstitucionalRepositorioTest {
    @Autowired
    private ProgramaInstitucionalRepositorio programaInstitucionalRepositorio;

    @Test
    public void buscarProgramaInstitucional() throws Exception {
        ProgramaInstitucional programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional(1);
        assertNotNull(programaInstitucional);
        programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional(-1);
        assertNull(programaInstitucional);
    }

    @Test
    public void altaProgramaInstitucional() throws Exception {
    }

    @Test
    public void buscarProgramaInstitucional1() throws Exception {
        ProgramaInstitucional programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional("p00001");
        assertNotNull(programaInstitucional);
        programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional("sdfsdfsdf");
        assertNull(programaInstitucional);
    }

    @Test
    public void obtenerProgramasInstitucionales() throws Exception {
        List<ProgramaInstitucional> programas = programaInstitucionalRepositorio.obtenerProgramasInstitucionales();
        assertNotNull(programas);
        assertEquals(2, programas.size());
    }

    @Test
    public void obtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional() throws Exception {
    }

    @Test
    public void obtenerUnidadesApoyoPorIdProgramaInstitucional() throws Exception {
    }

    @Test
    public void actualizarProgramaInstitucional() throws Exception {
    }

    @Test
    public void bajaProgramaInstitucional() throws Exception {
    }

    @Test
    public void contarProgramasInstitucionales() throws Exception {
        assertEquals(2L, programaInstitucionalRepositorio.contarProgramasInstitucionales());
    }

}