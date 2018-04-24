package domain;

import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({@NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
               @NamedQuery(name = "Vehicle.findByLicenseplate", query = "SELECT v FROM Vehicle v WHERE v.hashedLicensePlate = :licensePlate")
})
@Entity
public class Vehicle implements IVehicle{
    
    @Id
    private String hashedLicensePlate;
    private List<IJourney> journeys;
    private List<ISubInvoice> subInvoices;
    
    public Vehicle(){
        
    }

    @Override
    public String getHashedLicensePlate() {
        return this.hashedLicensePlate;
    }

    @Override
    public List<IJourney> getJourneys() {
        return Collections.unmodifiableList(journeys);
    }

    @Override
    public List<ISubInvoice> getSubInvoices() {
        return Collections.unmodifiableList(subInvoices);
    }

}
