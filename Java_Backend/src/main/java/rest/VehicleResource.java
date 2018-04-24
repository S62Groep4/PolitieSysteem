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
    @Path("{licencePlate}")
    public void removeVehicle(@PathParam("licencePlate") String licencePlate) {
        vehicleService.removeVehicle(licencePlate);
    }

    @GET
    @Path("{licencePlate}")
    public List<Vehicle> getVehicle(@PathParam("licencePlate") String licencePlate) {
        return vehicleService.getVehicle(licencePlate);
    }

    @GET
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}
