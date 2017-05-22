package gob.senado.ppf.sed.dto.programainstitucional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.isA;

public class TestProgramaInstitucional {
	private ProgramaInstitucional programaInstitucional;
	
	@Before
	public void instanciarProgramaInstitucional() {
		programaInstitucional = new ProgramaInstitucional();
	}

	@Test
	public void testIdProgramaInstitucional() {
		programaInstitucional.setIdProgramaInstitucional(1);
		Assert.assertEquals(1, programaInstitucional.getIdProgramaInstitucional());
	}

	@Test
	public void testClaveProgramaInstitucional() {
		String clave = "1.1.01.004.R001-MD003";
		programaInstitucional.setClave(clave);
		Assert.assertThat(clave, isA(String.class));
		Assert.assertEquals(clave, programaInstitucional.getClave());
	}

	@Test
	public void testNombreProgramaInstitucional() {
		String nombreProgramaInstitucional = "Servicios de Apoyo T\u00e9cnico";
		programaInstitucional.setNombre(nombreProgramaInstitucional);
		Assert.assertEquals(nombreProgramaInstitucional, programaInstitucional.getNombre());
	}
}
