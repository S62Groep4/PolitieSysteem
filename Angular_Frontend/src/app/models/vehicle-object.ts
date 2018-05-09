
import {SubInvoice} from './subinvoice-object';

export class Vehicle {
  public licencePlate: String
  public hashedLicensePlate: String;
  public journeyUri: String;
  public subInvoiceUri: SubInvoice[];


  constructor(hashedLicensePlate: String, journeyUri: String, subInvoiceUri: SubInvoice[]) {
    this.hashedLicensePlate = hashedLicensePlate;
    this.journeyUri = journeyUri;
    this.subInvoiceUri = subInvoiceUri;
  }

  setLicencePlate(licencePlate: String) {
    this.licencePlate = licencePlate;
  }

  getLicencePlate() {
    return this.licencePlate;
  }

  setHashedLicenseplate(hashedLicensePlate: String) {
    this.hashedLicensePlate = hashedLicensePlate;
  }

  getHashedLicenseplate() {
    return this.hashedLicensePlate;
  }

  setJourneyUrl(journeyUri: String) {
    this.journeyUri = journeyUri;
  }

  setJourneys(journeyUri: String) {
    this.journeyUri = journeyUri;
  }

  setSubInvoices(subInvoiceUri: SubInvoice[]) {
    this.subInvoiceUri = subInvoiceUri;
  }
}
