package websocket;

import dto.TransLocationDTO;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Teun
 */
@ServerEndpoint(value = "/serverwsendpoint", encoders = TransLocationEncoder.class, decoders = TransLocationDecoder.class)
public class WSEndpoint {

    public static final Set<Session> CONNECTEDCLIENTS = Collections.synchronizedSet(new HashSet());

    public WSEndpoint() {
    }

    @OnOpen
    public void onOpen(Session session) {
        CONNECTEDCLIENTS.add(session);
        System.out.println("Connected Clients: " + CONNECTEDCLIENTS.size());
        try {
            session.getBasicRemote().sendText("Response");
        } catch (IOException ex) {
            Logger.getLogger(WSEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnClose
    public void onClose(Session session) {
        CONNECTEDCLIENTS.remove(session);
    }

    @OnMessage
    public void onMessage(TransLocationDTO location, Session session) {
        for (Session s : CONNECTEDCLIENTS) {
            try {
                s.getBasicRemote().sendObject(location);
            } catch (EncodeException | IOException ex) {
                Logger.getLogger(WSEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
