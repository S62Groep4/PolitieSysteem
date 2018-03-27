package domain;


public interface ISubInvoice {
    
    String getInvoiceNumber();
    
    String getCountry();
    
    boolean getPaymentStatus();
    
    String getInvoiceDate();
    
    double getPrice();
}
