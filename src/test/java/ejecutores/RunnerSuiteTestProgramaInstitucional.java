package ejecutores;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunnerSuiteTestProgramaInstitucional {

	public static void main(String[] args) {
		Result resultado = JUnitCore.runClasses(SuiteTestDto.class, SuiteTestRepositorio.class);
		for (Failure falla : resultado.getFailures()) {
			System.out.println("Se ha encontrado una falla en : " + falla.getDescription() + "\nLa causa fue: "
					+ falla.getMessage());
		}
		System.out.println("Se encontrarón " + resultado.getFailureCount() + " falla(s) potenciales");
		System.out.println("Fue exitoso: " + resultado.wasSuccessful());
	}
}
