package gob.senado.ppf.sed.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import gob.senado.ppf.sed.componente.programainstitucional.ProgramaInstitucionalWebSocketHandler;

@Configuration
public class ConfiguracionParaWebSocketHandlers {

	@Bean
	public ProgramaInstitucionalWebSocketHandler programaInstitucionalWebSocketHandler() {
		return new ProgramaInstitucionalWebSocketHandler();
	}

}
