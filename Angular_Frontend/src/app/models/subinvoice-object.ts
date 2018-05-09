export class SubInvoice {
  public country: String;
  public invoiceDate: String;
  public invoiceNumber: Number;
  public paymentStatus: String;
  public price: Number;

  constructor(country: String, invoiceDate: String, invoiceNumber: Number, paymentStatus: String, price: Number) {
    this.country = country;
    this.invoiceDate = invoiceDate;
    this.invoiceNumber = invoiceNumber;
    this.paymentStatus = paymentStatus;
    this.price = price;
  }
}
