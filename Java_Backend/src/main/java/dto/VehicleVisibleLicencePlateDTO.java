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
public class VehicleVisibleLicencePlateDTO {

    private String licencePlate;
    private String hashedLicensePlate;
    private String journeyUri;
    private String subInvoiceUri;

    public VehicleVisibleLicencePlateDTO() {
    }

    public VehicleVisibleLicencePlateDTO(String licencePlate, String hashedLicensePlate, String journeyUri, String subInvoiceUri) {
        this.licencePlate = licencePlate;
        this.hashedLicensePlate = hashedLicensePlate;
        this.journeyUri = journeyUri;
        this.subInvoiceUri = subInvoiceUri;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
    
    public void setHashedLicensePlate(String hashedLicensePlate) {
        this.hashedLicensePlate = hashedLicensePlate;
    }

    public void setJourneyUri(String journeyUri) {
        this.journeyUri = journeyUri;
    }

    public void setSubInvoiceUri(String subInvoiceUri) {
        this.subInvoiceUri = subInvoiceUri;
    }

    public String getHashedLicensePlate() {
        return hashedLicensePlate;
    }

    public String getJourneyUri() {
        return journeyUri;
    }

    public String getSubInvoiceUri() {
        return subInvoiceUri;
    }
}
