package gob.senado.ppf.sed.componente.programainstitucional;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProgramaInstitucionalWebSocketHandler extends TextWebSocketHandler {

	private static final Logger log = Logger.getLogger(ProgramaInstitucionalWebSocketHandler.class);
	private final List<WebSocketSession> sesionesWebSocket = new CopyOnWriteArrayList<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session){
		sesionesWebSocket.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
		for (WebSocketSession wss : sesionesWebSocket) {
			try {
				wss.sendMessage(message);
			} catch (IOException e) {
				log.error("Problema enviando mensaje por socket",e);
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		sesionesWebSocket.remove(session);
	}
}
