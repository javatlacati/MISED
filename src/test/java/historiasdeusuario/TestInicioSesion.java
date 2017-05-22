package historiasdeusuario;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = { "pretty" }, features = { "src/test/resources" })
public class TestInicioSesion implements En {

	private WebDriver webDriver;

	//version 32.0 de firefox
	public TestInicioSesion() {
		Given("^El usuario ingresa a la siguiente direccion \'(.*)\'$", (String url) -> {
			webDriver = new FirefoxDriver();
			webDriver.get(url);
		});

		Then("^Ingresa su usuario \'(.*)\' y la clave de acceso \'(.*)\'", (String usuario, String clave) -> {
			WebElement inputUsuario = webDriver.findElement(By.id("username"));
			WebElement inputClave = webDriver.findElement(By.id("password"));
			inputUsuario.sendKeys(usuario);
			inputClave.sendKeys(clave);
		});

		And("^Pulsa el boton de ENTRAR!$", () -> {
			WebElement botonIngresar = webDriver.findElement(By.id("btn-entrar"));
			assertNotNull(botonIngresar);
			botonIngresar.click();
		});

		Then("^El usuario es redirigido a \'(.*)\'", (String url) -> {
			assertEquals(url, webDriver.getCurrentUrl());
			webDriver.close();
		});
	}		

}
