export class RegisterLicensePlateDTO {
  public licensePlate: String;
  public hashedLicensePlate: String;
  public serialNumber: String;

  constructor(licensePlate: String, hashedLicensePlate: String, serialNumber: String) {
    this.licensePlate = licensePlate;
    this.hashedLicensePlate = hashedLicensePlate;
    this.serialNumber = serialNumber;
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
