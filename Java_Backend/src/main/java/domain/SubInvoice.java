package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Teun
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "SubInvoice.findAll", query = "SELECT s FROM SubInvoice s")
    ,@NamedQuery(name = "SubInvoice.findByInvoiceNumber", query = "SELECT s FROM SubInvoice s WHERE s.invoiceNumber = :invoiceNumber")})
public class SubInvoice implements Serializable {

    @Id
    private String invoiceNumber;
    private String country;
    private String isPayed;
    private String invoiceDate;
    private double price;
    @ManyToOne
    private Vehicle vehicle;

    public SubInvoice() {
    }

    public SubInvoice(String invoiceNumber, String country, double price) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.invoiceDate = new Date(System.currentTimeMillis()).toString();
    }

    public SubInvoice(String invoiceNumber, String country, double price, String invoiceDate, String isPayed) {
        this.invoiceNumber = invoiceNumber;
        this.country = country;
        this.price = price;
        this.isPayed = isPayed;
        this.invoiceDate = invoiceDate;
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public void setIsPayed(String isPayed) {
        this.isPayed = isPayed;
    }

    public String getIsPayed() {
        return isPayed;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public double getPrice() {
        return price;
    }
    // </editor-fold>

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SubInvoice)) {
            return false;
        }
        SubInvoice otherUser = (SubInvoice) obj;
        if (this.invoiceNumber == null || otherUser.invoiceNumber == null) {
            return false;
        }
        return this.invoiceNumber.equals(otherUser.invoiceNumber);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.invoiceNumber);
        hash = 97 * hash + Objects.hashCode(this.country);
        hash = 97 * hash + Objects.hashCode(this.isPayed);
        hash = 97 * hash + Objects.hashCode(this.invoiceDate);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.vehicle);
        return hash;
    }
}