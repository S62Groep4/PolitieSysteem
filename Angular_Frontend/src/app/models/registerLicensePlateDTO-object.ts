export class RegisterLicensePlateDTO {
  hashedLicencePlate: String;

  constructor(hashedLicencePlate: String) {
    this.hashedLicencePlate = hashedLicencePlate;
  }

  setHashedLicensePlate(hashedLicencePlate: String) {
    this.hashedLicencePlate = hashedLicencePlate;
  }

  getHashedLicensePlate() {
    return this.hashedLicencePlate;
  }
}
