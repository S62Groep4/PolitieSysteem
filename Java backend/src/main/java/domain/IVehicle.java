package domain;

import java.util.List;


public interface IVehicle {
    
    String getHashedLicensePlate();
    
    List<IJourney> getJourneys();
    
    List<ISubInvoice> getSubInvoices();

}
