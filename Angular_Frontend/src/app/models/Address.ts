
export class Address {
  public streetName: string;
  public streetNumber: string;
  public zipCode: string;
  public city: string;
  public country: string;

  constructor(streetName: string, streetNumber: string, zipCode: string, country: string) {
    this.streetName = streetName;
    this.streetNumber = streetNumber;
    this.zipCode = zipCode;
    this.country = country;
  }
}
