package gob.senado.ppf.sed.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import gob.senado.ppf.sed.componente.programainstitucional.ProgramaInstitucionalWebSocketHandler;

@Configuration
@EnableWebSocket
public class ConfiguracionParaWebSocket implements WebSocketConfigurer {
	
	@Autowired
	private ProgramaInstitucionalWebSocketHandler programaInstitucionalWebSocketHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(programaInstitucionalWebSocketHandler, "/actualizacion-programa-institucional");
	}

}
