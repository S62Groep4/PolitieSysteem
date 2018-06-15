/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author M
 */
@Stateless
@Entity
@NamedQueries({
    @NamedQuery(name = "VehicleEuropol.getStolenVehicles", query = "SELECT v FROM VehicleEuropol v")
    ,
    @NamedQuery(name = "VehicleEuropol.findStolenVehicle", query = "SELECT v FROM VehicleEuropol v WHERE v.id = :id"),
    @NamedQuery(name = "VehicleEuropol.removeStolenVehicle", query = "DELETE FROM VehicleEuropol WHERE licensePlate = :licensePlate")
})
public class VehicleEuropol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty(value = "url")
    private String url;
    @JsonProperty(value = "licensePlate")
    private String licensePlate;
    @JsonProperty(value = "serialNumber")
    private String serialNumber;
    @JsonProperty(value = "originCountry")
    private String originCountry;

    public VehicleEuropol() {

    }

    public VehicleEuropol(String url, String licensePlate, String serialNumber, String originCountry) {
        this.url = url;
        this.licensePlate = licensePlate;
        this.serialNumber = serialNumber;
        this.originCountry = originCountry;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

}
