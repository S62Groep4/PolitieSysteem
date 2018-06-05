package rest;

import domain.TransLocation;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("monitored")
@Consumes(MediaType.APPLICATION_JSON)
public class MonitoredVehicleResource {

    @POST
    public Response monitoredTransLocation(TransLocation transLocation) {
        //Do stuff with the transLocation data
        return Response.ok().build();
    }

}
