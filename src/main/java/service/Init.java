package service;

import domain.Vehicle;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

@Startup
@Singleton
public class Init {
    
    @Inject
    VehicleService vehicleService;
    
    private static final int logRounds = 12;
    
    @PostConstruct
    public void init(){
        
        Vehicle vehicle1 = new Vehicle(BCrypt.hashpw("ZX-42-NG4", BCrypt.gensalt(logRounds)));
        Vehicle vehicle2 = new Vehicle(BCrypt.hashpw("RN-R34-Z7", BCrypt.gensalt(logRounds)));
        Vehicle vehicle3 = new Vehicle(BCrypt.hashpw("EF-23F-2S", BCrypt.gensalt(logRounds)));
        
        vehicleService.insertVehicle(vehicle1);
        vehicleService.insertVehicle(vehicle2);
        vehicleService.insertVehicle(vehicle3);
    }

}
