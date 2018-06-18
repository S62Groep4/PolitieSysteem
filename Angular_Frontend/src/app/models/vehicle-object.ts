
import {SubInvoice} from './subinvoice-object';
import {Person} from './person-object';

export class Vehicle {
  public licencePlate: string
  public hashedLicensePlate: string;
  public journeyUri: string;
  public subInvoiceUri: SubInvoice[];
  public ownerUri: Person;


  constructor(licencePlate: string, hashedLicensePlate: string, journeyUri: string, ownerUri: Person, subInvoiceUri: SubInvoice[]) {
    this.licencePlate = licencePlate;
    this.hashedLicensePlate = hashedLicensePlate;
    this.journeyUri = journeyUri;
    this.ownerUri = ownerUri;
    this.subInvoiceUri = subInvoiceUri;
  }

  setLicencePlate(licencePlate: string) {
    this.licencePlate = licencePlate;
  }

  getLicencePlate() {
    return this.licencePlate;
  }

  setHashedLicenseplate(hashedLicensePlate: string) {
    this.hashedLicensePlate = hashedLicensePlate;
  }

  getHashedLicenseplate() {
    return this.hashedLicensePlate;
  }

  setJourneyUrl(journeyUri: string) {
    this.journeyUri = journeyUri;
  }

  setJourneys(journeyUri: string) {
    this.journeyUri = journeyUri;
  }

  setSubInvoices(subInvoiceUri: SubInvoice[]) {
    this.subInvoiceUri = subInvoiceUri;
  }
}
