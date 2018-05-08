import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {RequestOptions, Headers} from '@angular/http';
import {Vehicle} from './models/vehicleObject';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RegisterLicensePlateDTO} from './models/registerLicensePlateDTO-object';

@Injectable()
export class VehicleService {

  ipAddress = 'http://localhost:44760/Java_Backend/api/';

  constructor(private http: HttpClient, private router: Router) {

  }

  getVehicles(): Observable<Vehicle[]> {
    return this.http.get(this.ipAddress + 'vehicles')
      .map(response => response as Vehicle[]);
  }

  insertVehicle(vehicle: String): Observable<any> {
    const newVehicle = new RegisterLicensePlateDTO(vehicle, vehicle);
    const header = {headers: new HttpHeaders({'Content-type': 'application/json'})};
    return this.http.post(this.ipAddress + 'vehicles', newVehicle, header);
  }

  searchCarByLicensePlate(licencePlate: String): Observable<Vehicle[]> {
    return this.http.get(this.ipAddress + 'vehicles/' + licencePlate)
      .map(response => response as Vehicle[]);
  }
}
