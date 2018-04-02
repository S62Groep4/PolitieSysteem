package service;

import domain.Journey;
import domain.TransLocation;
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
    
    @Inject
    TransLocationService transLocationService;

    @Inject
    SubInvoiceService subInvoiceService;

    @Inject
    JourneyService journeyService;
    
    private static final int logRounds = 12;
    
    @PostConstruct
    public void init(){
        
        TransLocation loc1 = new TransLocation(51.855305, 9.623518, "1", "31");
        TransLocation loc2 = new TransLocation(51.735719, 9.579573, "2", "31");
        TransLocation loc3 = new TransLocation(51.626728, 9.689436, "3", "31");
        TransLocation loc4 = new TransLocation(48.087453, 11.535139, "4", "31");
        TransLocation loc5 = new TransLocation(48.058089, 11.359358, "5", "31");
        TransLocation loc6 = new TransLocation(48.014012, 11.139631, "6", "31");
        TransLocation loc7 = new TransLocation(48.028709, 10.985823, "7", "31");
        
        Journey jou1 = new Journey();
        jou1.addTransLocation(loc1);
        jou1.addTransLocation(loc2);
        jou1.addTransLocation(loc3);

        Journey jou2 = new Journey();
        jou2.addTransLocation(loc4);
        jou2.addTransLocation(loc5);
        jou2.addTransLocation(loc6);
        jou2.addTransLocation(loc7);
        
        Vehicle vehicle1 = new Vehicle(BCrypt.hashpw("ZX-42-NG4", BCrypt.gensalt(logRounds)));
        vehicle1.addJourney(jou1);
        Vehicle vehicle2 = new Vehicle(BCrypt.hashpw("RN-R34-Z7", BCrypt.gensalt(logRounds)));
        vehicle2.addJourney(jou2);
        Vehicle vehicle3 = new Vehicle(BCrypt.hashpw("EF-23F-2S", BCrypt.gensalt(logRounds)));
        
        //vehicleService.insertVehicle(vehicle1);
        //vehicleService.insertVehicle(vehicle2);
        //vehicleService.insertVehicle(vehicle3);
    }

}
