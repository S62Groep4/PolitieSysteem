import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {RequestOptions, Headers} from '@angular/http';
import {Vehicle} from './models/vehicle-object';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class VehicleService {

  constructor(private http: HttpClient, private router: Router) {

  }

  registerLicenseplate(licenseplate: Vehicle): Observable<Vehicle> {
    return this.http.post<Vehicle>('', licenseplate);
  }
}
