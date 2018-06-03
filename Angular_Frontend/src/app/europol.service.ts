import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {VehicleEuropol} from './models/VehicleEuropol';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class EuropolService {

  URI_EUROPOL = 'http://192.168.24.101:8000/api/vehicles/?originCountry=DE';

  constructor(private http: HttpClient) {

  }

  getStolenVehicles(): Observable<VehicleEuropol[]> {
    return this.http.get(this.URI_EUROPOL)
      .map(response => response as VehicleEuropol[]);
  }
}
