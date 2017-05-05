package gob.senado.ppf.sed.configuracion;

import gob.senado.ppf.sed.componente.programainstitucional.OrganoDireccionEstrategicaWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import gob.senado.ppf.sed.componente.programainstitucional.ProgramaInstitucionalWebSocketHandler;

@Configuration
@EnableWebSocket
public class ConfiguracionParaWebSocket implements WebSocketConfigurer {
    
    private final ProgramaInstitucionalWebSocketHandler programaInstitucionalWebSocketHandler;
    private final OrganoDireccionEstrategicaWebSocketHandler organoDireccionEstrategicaWebSocketHandler;
    
    @Autowired
    public ConfiguracionParaWebSocket(ProgramaInstitucionalWebSocketHandler programaInstitucionalWebSocketHandler,
            OrganoDireccionEstrategicaWebSocketHandler organoDireccionEstrategicaWebSocketHandler){
        this.programaInstitucionalWebSocketHandler = programaInstitucionalWebSocketHandler;
        this.organoDireccionEstrategicaWebSocketHandler = organoDireccionEstrategicaWebSocketHandler;
    }
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(programaInstitucionalWebSocketHandler, "/actualizacion-programa-institucional")
                .addHandler(organoDireccionEstrategicaWebSocketHandler, "/actualizacion-organo-direccion-estrategica");
    }
    
}
