export class SubInvoice {
  public invoiceNumber: String;
  public country: String;
  public price: Number;

  constructor(invoiceNumber: String, country: String, price: Number) {
    this.invoiceNumber = invoiceNumber;
    this.country = country;
    this.price = price;
  }

  setInvoiceNumber(invoiceNumber: String) {
    this.invoiceNumber = invoiceNumber;
  }

  getInvoiceNumber() {
    return this.invoiceNumber;
  }

  setCountry(country: String) {
    this.country = country;
  }

  getCountry() {
    return this.country;
  }

  setPrice(price: Number) {
    this.price = price;
  }

  getPrice() {
    return this.price;
  }
}
