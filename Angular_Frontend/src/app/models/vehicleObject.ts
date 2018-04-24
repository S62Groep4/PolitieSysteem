import {SubInvoice} from './subinvoiceObject';

export class Vehicle {
  public hashedLicencePlate: String;
  public journeyUrl: String;
  public journeys: Number;
  public subInvoiceUrl: String;
  public subInvoices: SubInvoice[];


  constructor(hashedLicencePlate: String, journeyUrl: String, journeys: Number, subInvoiceUrl: String, subInvoices: SubInvoice[]) {
    this.hashedLicencePlate = hashedLicencePlate;
    this.journeyUrl = journeyUrl;
    this.journeys = journeys;
    this.subInvoiceUrl = subInvoiceUrl;
    this.subInvoices = subInvoices;
  }

  setHashedLicenseplate(hashedLicencePlate: String) {
    this.hashedLicencePlate = hashedLicencePlate;
  }

  getHashedLicenseplate() {
    return this.hashedLicencePlate;
  }

  setJourneyUrl(journeyUrl: String) {
    this.journeyUrl = journeyUrl;
  }

  setJourneys(journeys: Number) {
    this.journeys = journeys;
  }

  setSubinvoiceUrl(subInvoiceUrl: String) {
    this.subInvoiceUrl = subInvoiceUrl;
  }

  setSubInvoices(subInvoices: SubInvoice[]) {
    this.subInvoices = subInvoices;
  }
}
