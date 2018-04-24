package service;

import dao.UserDAO;
import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.User;
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
    UserDAO userDAO;

    @PostConstruct
    public void init() {      
        User testUser = new User("Medewerker@mail.com", "1234");
        userDAO.insertUser(testUser);
    }
}