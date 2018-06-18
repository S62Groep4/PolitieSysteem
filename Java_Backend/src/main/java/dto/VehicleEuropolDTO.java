/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author M
 */
public class VehicleEuropolDTO {

    private String url;
    private String licensePlate;
    private String serialNumber;
    private String originCountry;

    public VehicleEuropolDTO() {

    }

    public VehicleEuropolDTO(String url, String licensePlate, String serialNumber, String originCountry) {
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
