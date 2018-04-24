export class RegisterLicensePlateDTO {
  public licencePlate: String;
  public hashedLicencePlate: String;

  constructor(licencePlate: String, hashedLicencePlate: String) {
    this.licencePlate = licencePlate;
    this.hashedLicencePlate = hashedLicencePlate;
  }

  setLicencePlate(licencePlate: String) {
    this.licencePlate = licencePlate;
  }

  getLicencePlate() {
    return this.licencePlate;
  }

  setHashedLicensePlate(hashedLicencePlate: String) {
    this.hashedLicencePlate = hashedLicencePlate;
  }

  getHashedLicensePlate() {
    return this.hashedLicencePlate;
  }
}
