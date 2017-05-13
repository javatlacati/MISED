package historiasdeusuario;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Created by Administrador on 21/04/2017.
 */
public class InicioSesion implements En {
    WebDriver driver = null;

    public InicioSesion() {
//        Given("^I have (\\d+) cukes in my belly$",
//                (Integer cukes) -> {
//                    System.out.printf("Cukes: %d\n", cukes);
//                }
//        );

        Given("^Se abre el navegador$", () -> {
//            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk-9\\bin\\chromedriver.exe");
            driver = new EdgeDriver();
        });

        When("^Se abre la url del sistema$", () -> {
            driver.navigate().to("http://localhost:8080/");
        });

        Then("^Debe existir un campo de texto para el nombre de usuario$", () -> {
            WebElement campoUsuario = driver.findElement(By.name("username"));
            System.out.println(campoUsuario.isEnabled() ? "Test 1 Pass" : "Test 1 Fail");
        });

        Then("^Se cierra el navegador$", () -> {
            driver.close();
        });
    }
}
