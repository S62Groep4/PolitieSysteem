
export class VehicleEuropol {
  public url: String;
  public HashedLicensePlate: String;
  public serialNumber: String;
  public originCountry: String;

  constructor(url: String, HashedLicensePlate: String, serialNumber: String, originCountry: String) {
    this.url = url;
    this.HashedLicensePlate = HashedLicensePlate;
    this.serialNumber = serialNumber;
    this.originCountry = originCountry;
  }
}
