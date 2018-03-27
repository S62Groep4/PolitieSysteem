package rest;

import domain.Vehicle;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.VehicleService;

@Stateless
@Path("Vehicle")
public class VehicleResource {
    
    @Inject
    VehicleService vehicleService;
    
    @POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertVehicle(Vehicle vehicle){
        vehicleService.insertVehicle(vehicle);
    }
    
    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateVehicle(Vehicle vehicle){
        vehicleService.updateVehicle(vehicle);
    }
    
    @POST
    @Path("remove")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeVehicle(Vehicle vehicle){
        vehicleService.removeVehicle(vehicle);
    }
    
    @GET
    @Path("{hashedLicensePlate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle getVehicle(@PathParam("hashLicensePlate") String hashedLicensePlate){
        return vehicleService.getVehicle(hashedLicensePlate).get(0);
    }
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public void getAllVehicles(){
        
    }

}
