
export class VehicleEuropol {
  public url: String;
  public licensePlate: String;
  public serialNumber: String;
  public originCountry: String;

  constructor(url: String, licensePlate: String, serialNumber: String, originCountry: String) {
    this.url = url;
    this.licensePlate = licensePlate;
    this.serialNumber = serialNumber;
    this.originCountry = originCountry;
  }
}
