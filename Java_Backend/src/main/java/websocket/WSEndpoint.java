package websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.TransLocationDTO;
import rest.RegisteratieCommunication;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Teun
 */
@ServerEndpoint(value = "/serverwsendpoint/{searchId}", encoders = TransLocationEncoder.class, decoders = TransLocationDecoder.class)
@Singleton
@Startup

public class WSEndpoint {

    private static Map<Session, String> clients = Collections.synchronizedMap(new HashMap<Session, String>());

    @Inject
    private RegisteratieCommunication registeratieCommunication;

    public WSEndpoint() {
    }

    @OnOpen
    public void onOpen(@PathParam("searchId") String id, Session session) throws IOException {
        clients.put(session, id);
        System.out.println("Connected Clients: " + clients.size());
        try {
            session.getBasicRemote().sendText("Response");
        } catch (IOException ex) {
            Logger.getLogger(WSEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
        registeratieCommunication.AddNewStolenVehicle(id);

    }

    @OnClose
    public void onClose(Session session) {

        String id = clients.get(session);
        clients.remove(session);
        registeratieCommunication.RemoveStolenVehicle(id);

    }

    private void UpdateLocation(TransLocationDTO location) throws IOException {
        synchronized (clients) {

            for (Map.Entry<Session, String> s : clients.entrySet()) {
                if (location.getSerialNumber().equals(s.getValue())) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonDTO = gson.toJson(location);
                    s.getKey().getBasicRemote().sendText(jsonDTO.toString());
                }
            }
        }

    }

    public void reveiveEvent(@Observes TransLocationDTO transLocation) {
        try {
            UpdateLocation(transLocation);
        } catch (IOException e) {
            Logger.getLogger(WSEndpoint.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}