package gob.senado.ppf.sed.componente.programainstitucional;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ProgramaInstitucionalWebSocketHandler extends TextWebSocketHandler {

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
				e.printStackTrace();
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		sesionesWebSocket.remove(session);
	}
}
