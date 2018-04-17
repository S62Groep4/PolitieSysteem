package domain;

import javax.persistence.Entity;

public interface ITransLocation {
    
    Double getLat();
    
    Double getLon();
    
    String getDateTime();
    
    String getSerialNumber();
    
    String getCountryCode();
}
