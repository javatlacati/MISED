package gob.senado.ppf.sed.dto.organodireccionestrategica;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrganoDireccionEstrategica {

	private OrganoDireccionEstrategica organoDireccionEstrategica;
	
	@Before
	public void instanciarOrganoDireccionEstrategica(){
		organoDireccionEstrategica = new OrganoDireccionEstrategica();
	}
	
	@Test
	public void testIdOrganoDireccionEstrategica(){
		organoDireccionEstrategica.setIdOrganoDireccionEstrategica(444);
		assertEquals(444, organoDireccionEstrategica.getIdOrganoDireccionEstrategica());
	}
	
	@Test
	public void testIdProgramaInstitucional(){
		organoDireccionEstrategica.setIdProgramaInstitucional(211);
		assertEquals(211, organoDireccionEstrategica.getIdProgramaInstitucional());
	}
	
	@Test
	public void testNombre(){
		organoDireccionEstrategica.setNombre("Unidad de Servicios Medicos");
		assertEquals("Unidad de Servicios Medicos", organoDireccionEstrategica.getNombre());
	}
	
	@Test
	public void testNombreProgramaInstitucional(){
		organoDireccionEstrategica.setNombreProgramaInstitucional("Servicios Auxiliares");
		assertEquals("Servicios Auxiliares", organoDireccionEstrategica.getNombreProgramaInstitucional());
	}
	
	@Test
	public void testClaveProgramaInstitucional(){
		organoDireccionEstrategica.setClaveProgramaInstitucional("1020.0.X.1");
		assertEquals("1020.0.X.1", organoDireccionEstrategica.getClaveProgramaInstitucional());
	}
	
	@Test
	public void testDescripcionOrganoDireccionEstrategica(){
		organoDireccionEstrategica.setDescripcion("La descripcion no debe fallar.");
		assertEquals("La descripcion no debe fallar.", organoDireccionEstrategica.getDescripcion());
	}
	
	@Test
	public void testDescripcionProgramaInstitucional(){
		organoDireccionEstrategica.setDescripcionProgramaInstitucional("Descripcion del Programa Institucional");
		assertEquals("Descripcion del Programa Institucional", organoDireccionEstrategica.getDescripcionProgramaInstitucional());
	}
	
	@Test
	public void testTotalUnidadesApoyoAdscritas(){
		organoDireccionEstrategica.setTotalUnidadesApoyoAdscritas(14);
		assertEquals(14, organoDireccionEstrategica.getTotalUnidadesApoyoAdscritas());
	}
}
