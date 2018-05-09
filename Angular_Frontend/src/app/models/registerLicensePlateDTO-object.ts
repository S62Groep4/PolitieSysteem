export class RegisterLicensePlateDTO {
  public licencePlate: String;
  public hashedLicensePlate: String;

  constructor(licencePlate: String, hashedLicensePlate: String) {
    this.licencePlate = licencePlate;
    this.hashedLicensePlate = hashedLicensePlate;
  }

  setLicencePlate(licencePlate: String) {
    this.licencePlate = licencePlate;
  }

  getLicencePlate() {
    return this.licencePlate;
  }

  setHashedLicensePlate(hashedLicensePlate: String) {
    this.hashedLicensePlate = hashedLicensePlate;
  }

  getHashedLicensePlate() {
    return this.hashedLicensePlate;
  }
}
