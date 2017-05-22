package ejecutores;

import gob.senado.ppf.sed.dto.organodireccionestrategica.TestOrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.TestProgramaInstitucional;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestProgramaInstitucional.class, TestOrganoDireccionEstrategica.class })
public class SuiteTestDto {

}
