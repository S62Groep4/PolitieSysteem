import {SubInvoice} from './subinvoiceObject';

export class Vehicle {
  public licencePlate: String
  public hashedLicencePlate: String;
  public journeyUrl: String;
  public journeys: Number;
  public subInvoiceUrl: String;
  public subInvoices: SubInvoice[];


  constructor(licencePlate: String, hashedLicencePlate: String, journeyUrl: String, journeys: Number, subInvoiceUrl: String, subInvoices: SubInvoice[]) {
    this.licencePlate = licencePlate;
    this.hashedLicencePlate = hashedLicencePlate;
    this.journeyUrl = journeyUrl;
    this.journeys = journeys;
    this.subInvoiceUrl = subInvoiceUrl;
    this.subInvoices = subInvoices;
  }

  setLicencePlate(licencePlate: String) {
    this.licencePlate = licencePlate;
  }

  getLicencePlate() {
    return this.licencePlate;
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
