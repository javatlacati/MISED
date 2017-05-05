package gob.senado.ppf.sed.componente.programainstitucional;

import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProgramaInstitucionalWebSocketHandler extends TextWebSocketHandler {
    
    private static final Logger log = Logger.getLogger(ProgramaInstitucionalWebSocketHandler.class);
    private final List<WebSocketSession> sesionesWebSocket = new CopyOnWriteArrayList<>();
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        Single.just(session)
                .subscribe(sesionesWebSocket::add, log::error);
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        Observable.fromArray(sesionesWebSocket.toArray(new WebSocketSession[0]))
                .subscribe(ws -> ws.sendMessage(message),
                        throwableWebSocketSession ->
                                log.error("Problema enviando mensaje por websocket ",
                                        throwableWebSocketSession));
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        Single.just(session).subscribe(sesionesWebSocket::remove,
                throwableWebSocketSession -> log.error("Problema removiendo el websocket ", throwableWebSocketSession));
    }
}
