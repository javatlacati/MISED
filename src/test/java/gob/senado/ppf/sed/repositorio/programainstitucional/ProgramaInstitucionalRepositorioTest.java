package gob.senado.ppf.sed.repositorio.programainstitucional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaDataSource;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaExtras;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaSeguridad;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaWeb;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

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
//@TransactionConfiguration(defaultRollback=true)
@Transactional
@Rollback
public class ProgramaInstitucionalRepositorioTest {
    @Autowired
    private ProgramaInstitucionalRepositorio programaInstitucionalRepositorio;
    @Ignore
    @Test
    public void buscarProgramaInstitucional() throws Exception {
        ProgramaInstitucional programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional(1);
        assertNotNull(programaInstitucional);
        programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional(-1);
        assertNull(programaInstitucional);
    }
    @Ignore
    @Test
    public void altaProgramaInstitucional() throws Exception {
    }
    @Ignore
    @Test
    public void buscarProgramaInstitucional1() throws Exception {
        ProgramaInstitucional programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional("1.1.01.004.R001-MD003");
        assertNotNull(programaInstitucional);
        programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional("sdfsdfsdf");
        assertNull(programaInstitucional);
    }
    @Ignore
    @Test
    public void obtenerProgramasInstitucionales() throws Exception {
        List<ProgramaInstitucional> programas = programaInstitucionalRepositorio.obtenerProgramasInstitucionales();
        assertNotNull(programas);
        assertEquals(3, programas.size());
    }
    @Ignore
    @Test
    public void obtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional() throws Exception {
        List<OrganoDireccionEstrategica> organosDireccionEstrategica = programaInstitucionalRepositorio.obtenerOrganosDireccionEstrategicaPorIdProgramaInstitucional(0);
        assertNotNull(organosDireccionEstrategica);
        //TODO mejorar
    }
    @Ignore
    @Test
    public void obtenerUnidadesApoyoPorIdProgramaInstitucional() throws Exception {
    }
    @Ignore
    @Test
    public void actualizarProgramaInstitucional() throws Exception {
    }
    @Ignore
    @Test
    public void bajaProgramaInstitucional() throws Exception {
    }
    @Ignore
    @Test
    public void contarProgramasInstitucionales() throws Exception {
        assertEquals(3L, programaInstitucionalRepositorio.contarProgramasInstitucionales());
    }

}