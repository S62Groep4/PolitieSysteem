import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {RequestOptions, Headers} from '@angular/http';
import {Vehicle} from './models/vehicle-object';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RegisterLicensePlateDTO} from './models/registerLicensePlateDTO-object';
import {SubInvoice} from './models/subinvoice-object';
import {Journey} from './models/journey-object';
import {Translocation} from './models/translocation-object';
import {Person} from './models/person-object';

@Injectable()
export class VehicleService {

  uriAddress = 'http://localhost:44760/Java_Backend/api/';
  externUriAdress = 'http://localhost:8080/Java_Backend/api/persons/';

  constructor(private http: HttpClient, private router: Router) {

  }

  getVehicles(): Observable<Vehicle[]> {
    return this.http.get(this.uriAddress + 'vehicles')
      .map(response => response as Vehicle[]);
  }

  getSubInvoice(uri: string): Observable<SubInvoice[]> {
    return this.http.get(uri)
      .map(response => response as SubInvoice[]);
  }

  getJourneys(uri: string): Observable<Journey[]> {
    return this.http.get(uri)
      .map(response => response as Journey[]);
  }

  getTranslocations(uri: string): Observable<Translocation[]> {
    return this.http.get(uri)
      .map(response => response as Translocation[]);
  }

  getPersonByLicenceplate(unhashedLicenceplate: String): Observable<Person> {
    return this.http.get(this.externUriAdress + 'licenceplate/' + unhashedLicenceplate)
      .map(response => response as Person);
  }

  insertVehicle(vehicle: String): Observable<any> {
    const newVehicle = new RegisterLicensePlateDTO(vehicle, vehicle);
    const header = {headers: new HttpHeaders({'Content-type': 'application/json'})};
    return this.http.post(this.uriAddress + 'vehicles', newVehicle, header);
  }

  searchCarByLicensePlate(licencePlate: String): Observable<Vehicle[]> {
    return this.http.get(this.uriAddress + 'vehicles/searchvehicles/' + licencePlate)
      .map(response => response as Vehicle[]);
  }
}
