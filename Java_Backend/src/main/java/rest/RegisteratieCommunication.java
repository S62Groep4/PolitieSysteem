package rest;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Stateless
public class RegisteratieCommunication {

    private final String remoteServer = "http://192.168.24.91:8686";
    private final String extention = "RegistratieSysteem";

    public void AddNewStolenVehicle(String id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(remoteServer).path(String.format("%s/api/stolen/%s", extention, id));

        target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(null, MediaType.APPLICATION_JSON));
    }

    public void RemoveStolenVehicle(String id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(remoteServer).path(String.format("%s/api/stolen/%s",extention, id));

        target.request(MediaType.APPLICATION_JSON_TYPE)
                .delete();
    }
}
