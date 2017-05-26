package gob.senado.ppf.sed.repositorio.unidadapoyo;

import gob.senado.ppf.sed.configuracion.ConfiguracionParaDataSource;
import gob.senado.ppf.sed.configuracion.ConfiguracionParaExtras;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.repositorio.unidadapoyo.impl.UnidadApoyoRepositorioImpl;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfiguracionParaExtras.class, ConfiguracionParaDataSource.class,
		UnidadApoyoRepositorioImpl.class }, loader = AnnotationConfigContextLoader.class)
public class TestUnidadApoyoRepositorio {

	@Autowired
	private UnidadApoyoRepositorio unidadApoyoRepositorio;
	
	@Test
	@Transactional
	@Rollback(true)
	@Ignore
	public void testAltaUnidadApoyo(){
		UnidadApoyo unidadApoyo = new UnidadApoyo();
		unidadApoyo.setIdOrganoDireccionEstrategica(2);
		unidadApoyo.setClaveProgramaInstitucional("444.555.666.777");
		unidadApoyo.setNombre("Nombre para la unidad de apoyo");
		unidadApoyo.setProposito("Nuevo proposito para la unidad de apoyo");
		assertTrue(unidadApoyoRepositorio.altaUnidadApoyo(unidadApoyo));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@Ignore
	public void testBajaUnidadApoyo(){
		assertTrue(unidadApoyoRepositorio.bajaUnidadApoyo(3));
	}
	
	@Test
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	@Ignore
	public void testBuscarUnidadApoyoPorIdUnidadApoyo(){
		UnidadApoyo ua = unidadApoyoRepositorio.buscarUnidadApoyo(1);
		assertNotNull(ua);
		assertEquals(1, ua.getIdUnidadApoyo());
		assertEquals(2, ua.getIdOrganoDireccionEstrategica());
		assertEquals("Secretar\u00eda General de Servicios Parlamentarios", ua.getNombre());
		assertEquals("", ua.getProposito());
	}
	
	@Test
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	@Ignore
	public void testBuscarUnidadApoyoPorNombreUnidadApoyo(){
		UnidadApoyo ua = unidadApoyoRepositorio.buscarUnidadApoyo("Secretar\u00eda General de Servicios Parlamentarios");
		assertNotNull(ua);
		assertEquals(1, ua.getIdUnidadApoyo());
		assertEquals(2, ua.getIdOrganoDireccionEstrategica());
		assertEquals("Secretar\u00eda General de Servicios Parlamentarios", ua.getNombre());
		assertEquals("", ua.getProposito());
	}
	
	@Test
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	@Ignore
	public void testObtenerUnidadesApoyo(){
		assertEquals(27, unidadApoyoRepositorio.obtenerUnidadesApoyo().size());
	}
	
	@Test
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	@Ignore
	public void testContarUnidadesApoyo(){
		assertEquals(27, unidadApoyoRepositorio.contarUnidadesApoyo());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	@Ignore
	public void testActualizarUnidadApoyo(){
		UnidadApoyo unidadApoyoActualizada = new UnidadApoyo();
		unidadApoyoActualizada.setIdUnidadApoyo(3);
		unidadApoyoActualizada.setIdOrganoDireccionEstrategica(1);
		unidadApoyoActualizada.setNombre("NOMBRE ACTUALIZADO");
		assertTrue(unidadApoyoRepositorio.actualizarUnidadApoyo(unidadApoyoActualizada));
	}
	
	
	
}
