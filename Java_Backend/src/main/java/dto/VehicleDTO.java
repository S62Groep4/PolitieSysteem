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
public class VehicleDTO implements Serializable {

    private String licencePlate;
    private String hashedLicencePlate;
    private String journeyUrl;
    private int journeys;
    private String subInvoiceUrl;
    private int subInvoices;

    public VehicleDTO() {
    }

    public VehicleDTO(String licencePlate, String hashedLicencePlate, String journeyUrl, int journeys, String subInvoiceUrl, int subInvoices) {
        this.licencePlate = licencePlate;
        this.hashedLicencePlate = hashedLicencePlate;
        this.journeyUrl = journeyUrl;
        this.journeys = journeys;
        this.subInvoiceUrl = subInvoiceUrl;
        this.subInvoices = subInvoices;
    }

    public String getLicencePlate(String licencePlate) {
        return this.licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getHashedLicencePlate() {
        return hashedLicencePlate;
    }

    public void setHashedLicencePlate(String hashedLicencePlate) {
        this.hashedLicencePlate = hashedLicencePlate;
    }

    public String getJourneyUrl() {
        return journeyUrl;
    }

    public void setJourneyUrl(String journeyUrl) {
        this.journeyUrl = journeyUrl;
    }

    public int getJourneys() {
        return journeys;
    }

    public void setJourneys(int journeys) {
        this.journeys = journeys;
    }

    public String getSubInvoiceUrl() {
        return subInvoiceUrl;
    }

    public void setSubInvoiceUrl(String subInvoiceUrl) {
        this.subInvoiceUrl = subInvoiceUrl;
    }

    public int getSubInvoices() {
        return subInvoices;
    }

    public void setSubInvoices(int subInvoices) {
        this.subInvoices = subInvoices;
    }
}
