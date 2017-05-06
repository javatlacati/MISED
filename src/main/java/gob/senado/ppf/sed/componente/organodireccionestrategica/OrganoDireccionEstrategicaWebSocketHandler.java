package gob.senado.ppf.sed.componente.organodireccionestrategica;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OrganoDireccionEstrategicaWebSocketHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession> sesionesWebSocket = new CopyOnWriteArrayList<>();
    private static final Logger log = Logger.getLogger(OrganoDireccionEstrategicaWebSocketHandler.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Single.just(session)
                .subscribe(sesionesWebSocket::add, log::error);

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
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
