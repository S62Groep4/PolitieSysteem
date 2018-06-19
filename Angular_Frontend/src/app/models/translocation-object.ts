export class Translocation {
  public countryCode: string;
  public dateTime: string;
  public lat: Number;
  public lon: Number;
  public carTrackerId
  public serialNumber: string;

  constructor(countryCode: string, dateTime: string, lat: Number, lon: Number, carTrackerId: string) {
    this.countryCode = countryCode;
    this.dateTime = dateTime;
    this.lat = lat;
    this.lon = lon;
    this.carTrackerId = carTrackerId;
  }
}
