package historiasdeusuario;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrador on 21/04/2017.
 */
public class PuebaHistoriaUsuario implements En {
    WebDriver driver = null;

    public PuebaHistoriaUsuario() {
        Given("^I have (\\d+) cukes in my belly$",
                (Integer cukes) -> {
                    System.out.printf("Cukes: %d\n", cukes);
                }
        );

        Given("^I have open the browser$", () -> {
//            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jdk-9\\bin\\chromedriver.exe");
            driver = new FirefoxDriver();
        });

        When("^I open Facebook website$", () -> {
            driver.navigate().to("http://www.google.com/xhtml");
        });

        Then("^Login button should exits$", () -> {
            WebElement searchBox = driver.findElement(By.name("q"));
            System.out.println(searchBox.isEnabled() ? "Test 1 Pass" : "Test 1 Fail");

            driver.close();
        });
    }
}
