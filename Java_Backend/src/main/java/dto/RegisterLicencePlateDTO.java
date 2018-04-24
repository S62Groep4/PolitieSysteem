/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author M
 */
public class RegisterLicencePlateDTO implements Serializable {

    private String hashedLicencePlate;
    
    public RegisterLicencePlateDTO(){
        
    }
    
    public RegisterLicencePlateDTO(String hashedLicencePlate){
        this.hashedLicencePlate = hashedLicencePlate;
    }
    
    public void setHashedLicencePlate(String hashedLicencePlate){
        this.hashedLicencePlate = hashedLicencePlate;
    }
    
    public String getHashedLicencePlate(){
        return this.hashedLicencePlate;
    }

}
