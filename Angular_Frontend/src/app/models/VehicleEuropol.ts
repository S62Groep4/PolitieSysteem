
export class VehicleEuropol {
  public url: String;
  public licensePlate: string;
  public serialNumber: string;
  public originCountry: string;

  constructor(url: string, licensePlate: string, serialNumber: string, originCountry: string) {
    this.url = url;
    this.licensePlate = licensePlate;
    this.serialNumber = serialNumber;
    this.originCountry = originCountry;
  }
}
