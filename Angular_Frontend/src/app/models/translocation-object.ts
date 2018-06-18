export class Translocation {
  public countryCode: String;
  public dateTime: String;
  public lat: Number;
  public lon: Number;
  public carTrackerId
  public serialNumber: String;

  constructor(countryCode: String, dateTime: String, lat: Number, lon: Number, carTrackerId: String) {
    this.countryCode = countryCode;
    this.dateTime = dateTime;
    this.lat = lat;
    this.lon = lon;
    this.carTrackerId = carTrackerId;
  }
}
