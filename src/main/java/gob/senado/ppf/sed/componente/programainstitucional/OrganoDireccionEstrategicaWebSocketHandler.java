package gob.senado.ppf.sed.componente.programainstitucional;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class OrganoDireccionEstrategicaWebSocketHandler extends TextWebSocketHandler{
    
    private static final List<WebSocketSession> sesionesWebSocket = new CopyOnWriteArrayList<>();
    private static final Logger log = Logger.getLogger(OrganoDireccionEstrategicaWebSocketHandler.class);
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sesionesWebSocket.add(session);
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try{
            for(WebSocketSession wss: sesionesWebSocket){
                session.sendMessage(message);
            }
        }catch(IOException e){
            log.error("Problema enviando mensaje por socket",e);
        }
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sesionesWebSocket.remove(session);
    }
    
    
    
    
    
    
}
