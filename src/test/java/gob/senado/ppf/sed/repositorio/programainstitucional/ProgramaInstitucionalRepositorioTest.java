package gob.senado.ppf.sed.repositorio.programainstitucional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaDataSource;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaExtras;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaSeguridad;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaWeb;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import org.junit.Assert;
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
@DatabaseSetup(value = "classpath:datasetProgramaInsitucional1.xml",type = com.github.springtestdbunit.annotation.DatabaseOperation.CLEAN_INSERT)
public class ProgramaInstitucionalRepositorioTest {
    @Autowired
    private ProgramaInstitucionalRepositorio programaInstitucionalRepositorio;


//    DataSource dataSource;
//    @Before
//    public void setUp() throws Exception {
//        IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File(getClass().getResource("/datasetProgramaInsitucional2.xml").getFile()));
//        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(dataSource);
//        DatabaseOperation.CLEAN_INSERT.execute(dbConn, dataSet);
//    }


    @Test
    public void buscarProgramaInstitucional() throws Exception {
        ProgramaInstitucional programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional(1);
        Assert.assertNotNull(programaInstitucional);
        programaInstitucional = programaInstitucionalRepositorio.buscarProgramaInstitucional(-1);
        Assert.assertNull(programaInstitucional);
    }

    @Test
    public void altaProgramaInstitucional() throws Exception {
    }

    @Test
    public void buscarProgramaInstitucional1() throws Exception {
    }

    @Test
    public void obtenerProgramasInstitucionales() throws Exception {
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
    }
}