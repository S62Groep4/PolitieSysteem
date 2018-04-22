package rest;

import domain.Vehicle;
import dto.RegisterLicencePlateDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.VehicleService;

@Stateless
@Path("vehicles")
public class VehicleResource {

    @Inject
    VehicleService vehicleService;

    @POST
    public void insertVehicle(Vehicle vehicle) {
        vehicleService.insertVehicle(vehicle);
    }

    @PUT
    public void updateVehicle(Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
    }

    @DELETE
    @Path("{hashedLicencePlate}")
    public void removeVehicle(@PathParam("hashedLicencePlate") String hashedLicencePlate) {
        vehicleService.removeVehicle(hashedLicencePlate);
    }

    @GET
    @Path("{hashedLicencePlate}")
    public List<Vehicle> getVehicle(@PathParam("hashedLicencePlate") String hashedLicencePlate) {
        return vehicleService.getVehicle(hashedLicencePlate);
    }

    @GET
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}
