export class Vehicle {
  public hashedlicenseplate: String;

  constructor(hashedlicenseplate: String) {
    this.hashedlicenseplate = hashedlicenseplate;
  }

  setHashedLicenseplate(hashedlicenseplate: String) {
    this.hashedlicenseplate = hashedlicenseplate;
  }

  getHashedLicenseplate() {
    return this.hashedlicenseplate;
  }
}
