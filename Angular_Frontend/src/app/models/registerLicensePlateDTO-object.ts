export class RegisterLicensePlateDTO {
  public licensePlate: String;
  public hashedLicensePlate: String;
  public serialNumber: String;
  public originCountry: String;

  constructor(licensePlate: String, hashedLicensePlate: String, serialNumber: String, originCountry: String) {
    this.licensePlate = licensePlate;
    this.hashedLicensePlate = hashedLicensePlate;
    this.serialNumber = serialNumber;
    this.originCountry = originCountry;
  }

  setLicencePlate(licencePlate: String) {
    this.licensePlate = licencePlate;
  }

  getLicencePlate() {
    return this.licensePlate;
  }

  setHashedLicensePlate(hashedLicensePlate: String) {
    this.hashedLicensePlate = hashedLicensePlate;
  }

  getHashedLicensePlate() {
    return this.hashedLicensePlate;
  }

  setSerialNumber(serialNumber: String) {
    this.serialNumber = serialNumber;
  }

  getSerialNumber() {
    return this.serialNumber;
  }
}
